package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.IndexCategory;
import com.yymt.entity.api.TableName;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.*;
import com.yymt.search.LuceneUtils;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yyt on 2018/9/28.
 */
@RestController
@RequestMapping("/search")
@Api(tags = "APP搜索")
public class SearchController extends BaseController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private GamesService gamesService;

    @Autowired
    private HallService hallService;

    @Autowired
    private CorporationService corporationService;

    @Autowired
    private GuideService guideService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ForumsService forumsService;

    @Autowired
    private HallSportService hallSportService;

    @Autowired
    private SportsService sportsService;

    @Autowired
    private IndustryPersonService industryPersonService;

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private HallServeService hallServeService;
    @Autowired
    private CoachingServiceService coachingServiceService;
    @Autowired
    private UserService userService;

    /**
     * 首页搜索
     *
     * @param query 搜索字串
     */
    @PostMapping("/index/{query}")
    //@ApiOperation("首页搜索")
    public RWapper searchIndex(@PathVariable String query) throws IOException, ParseException {
        int pageNum = 1, pageSize = 100;
        RWapper ok = RWapper.ok();

        //体育动态
        PageUtils sports_dynamics = LuceneUtils.searcher(IndexCategory.SPORTS_DYNAMICS, query, pageNum, pageSize);
        List<Map<String, String>> sportsDynamicsData = (List<Map<String, String>>) sports_dynamics.getList();
        List<NewsEntity> sportsDynamicsList = new ArrayList<>();
        if (sportsDynamicsData.size() > 0) {
            List<Integer> sportsDynamicsIds = new ArrayList<Integer>();
            for (Map<String, String> map : sportsDynamicsData) {
                int id = Integer.parseInt(map.get("id"));
                sportsDynamicsIds.add(id);
            }
            sportsDynamicsList = newsService.getNewsListByIds(sportsDynamicsIds);
        }
        HashMap<String, Object> sportsDynamicsResult = new HashMap<>();
        sportsDynamicsResult.put("order", 1);
        sportsDynamicsResult.put("name", IndexCategory.SPORTS_DYNAMICS.getDesc());
        sportsDynamicsResult.put("list", sportsDynamicsList);
        ok.put(IndexCategory.SPORTS_DYNAMICS.toString().toLowerCase(), sportsDynamicsResult);

        //体育赛事
        PageUtils sports_games = LuceneUtils.searcher(IndexCategory.SPORTS_GAMES, query, pageNum, pageSize);
        List<Map<String, String>> sportsGamesData = (List<Map<String, String>>) sports_games.getList();
        List<GamesEntity> sportsGamesList = new ArrayList<>();
        if (sportsGamesData.size() > 0) {
            List<Integer> sportsGamesIds
                    = sportsGamesData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            sportsGamesList = gamesService.getGamesListByIds(sportsGamesIds);
        }
        HashMap<String, Object> sportsGamesResult = new HashMap<>();
        sportsGamesResult.put("order", 2);
        sportsGamesResult.put("name", IndexCategory.SPORTS_GAMES.getDesc());
        sportsGamesResult.put("list", sportsGamesList);
        ok.put(IndexCategory.SPORTS_GAMES.toString().toLowerCase(), sportsGamesResult);

        //群众体育
        PageUtils mass_sports = LuceneUtils.searcher(IndexCategory.MASS_SPORTS, query, pageNum, pageSize);
        List<Map<String, String>> massSportsData = (List<Map<String, String>>) mass_sports.getList();
        List<NewsEntity> massSportsList = new ArrayList<>();
        if (massSportsData.size() > 0) {
            List<Integer> massSportsIds
                    = massSportsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            massSportsList = newsService.getNewsListByIds(massSportsIds);
        }
        HashMap<String, Object> massSportsResult = new HashMap<>();
        massSportsResult.put("order", 3);
        massSportsResult.put("name", IndexCategory.MASS_SPORTS.getDesc());
        massSportsResult.put("list", massSportsList);
        ok.put(IndexCategory.MASS_SPORTS.toString().toLowerCase(), massSportsResult);

        //竞技体育
        PageUtils competitive_sports = LuceneUtils.searcher(IndexCategory.COMPETITIVE_SPORTS, query, pageNum, pageSize);
        List<Map<String, String>> competitiveSportsData = (List<Map<String, String>>) competitive_sports.getList();
        List<NewsEntity> competitiveSportsList = new ArrayList<>();
        if (competitiveSportsData.size() > 0) {
            List<Integer> competitiveSportsIds
                    = competitiveSportsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            competitiveSportsList = newsService.getNewsListByIds(competitiveSportsIds);
        }
        HashMap<String, Object> competitiveSportsResult = new HashMap<>();
        competitiveSportsResult.put("order", 4);
        competitiveSportsResult.put("name", IndexCategory.COMPETITIVE_SPORTS.getDesc());
        competitiveSportsResult.put("list", competitiveSportsList);
        ok.put(IndexCategory.COMPETITIVE_SPORTS.toString().toLowerCase(), competitiveSportsResult);

        //体育产业
        PageUtils sports_industry = LuceneUtils.searcher(IndexCategory.SPORTS_INDUSTRY, query, pageNum, pageSize);
        List<Map<String, String>> sportsIndustryData = (List<Map<String, String>>) sports_industry.getList();
        List<NewsEntity> sportsIndustryList = new ArrayList<>();
        if (sportsIndustryData.size() > 0) {
            List<Integer> sportsIndustryIds
                    = sportsIndustryData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            sportsIndustryList = newsService.getNewsListByIds(sportsIndustryIds);
        }
        HashMap<String, Object> sportsIndustryResult = new HashMap<>();
        sportsIndustryResult.put("order", 5);
        sportsIndustryResult.put("name", IndexCategory.SPORTS_INDUSTRY.getDesc());
        sportsIndustryResult.put("list", sportsIndustryList);
        ok.put(IndexCategory.SPORTS_INDUSTRY.toString().toLowerCase(), sportsIndustryResult);

        return ok.encode(isEncryption);
    }

    /**
     * 按类分页搜索
     */
    @PostMapping("/categoryMore")
    //@ApiOperation("按类分页搜索")
    public RWapper categoryMore(@RequestBody Map<String, Object> params) throws IOException, ParseException {
        int pageNum = Optional.ofNullable(params.get("pageNum")).map(n -> (int) n).orElse(1);
        int pageSize = Optional.ofNullable(params.get("pageSize")).map(n -> (int) n).orElse(10);
        String query = (String) params.get("query");
        Object categoryParam = params.get("category");
        if (categoryParam == null)
            return RWapper.error("category参数为空。").encode(isEncryption);
        IndexCategory category = Enum.valueOf(IndexCategory.class, ((String) categoryParam).toUpperCase());

        RWapper ok = RWapper.ok();
        PageUtils pageResult = LuceneUtils.searcher(category, query, pageNum, pageSize);

        return ok.put("page", pageResult).encode(isEncryption);
    }

    /**
     * 搜索公共服务
     *
     * @param query 搜索字串
     */
    @PostMapping("/publicService/{query}")
    //@ApiOperation("搜索公共服务")
    public RWapper publicService(@PathVariable String query) throws IOException, ParseException {
        int pageNum = 1, pageSize = 100;
        RWapper ok = RWapper.ok();

        //场馆
        PageUtils hallsPaged = LuceneUtils.searcher(IndexCategory.HALL, query, pageNum, pageSize);
        List<Map<String, String>> hallsData = (List<Map<String, String>>) hallsPaged.getList();
        List<HallEntity> hallList = new ArrayList<>();
        if (hallsData.size() > 0) {
            List<Integer> hallIds
                    = hallsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            hallList = hallService.getHallsListByIds(hallIds);
        }
        HashMap<String, Object> hallsResult = new HashMap<>();
        hallsResult.put("order", 1);
        hallsResult.put("name", IndexCategory.HALL.getDesc());
        hallsResult.put("list", hallList);
        ok.put(IndexCategory.HALL.toString().toLowerCase(), hallsResult);

        //社团
        PageUtils corporationsPaged = LuceneUtils.searcher(IndexCategory.CORPORATION, query, pageNum, pageSize);
        List<Map<String, String>> corporationsData = (List<Map<String, String>>) corporationsPaged.getList();
        List<CorporationEntity> corporationList = new ArrayList<>();
        if (corporationsData.size() > 0) {
            List<Integer> corporationIds
                    = corporationsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            corporationList = corporationService.getCorporationListByIds(corporationIds);
        }
        HashMap<String, Object> corporationsResult = new HashMap<>();
        corporationsResult.put("order", 2);
        corporationsResult.put("name", IndexCategory.CORPORATION.getDesc());
        corporationsResult.put("list", corporationList);
        ok.put(IndexCategory.CORPORATION.toString().toLowerCase(), corporationsResult);

        //行业人员
        PageUtils industryPersonsPaged = LuceneUtils.searcher(IndexCategory.INDUSTRY_PERSON, query, pageNum, pageSize);
        List<Map<String, String>> industryPersonsData = (List<Map<String, String>>) industryPersonsPaged.getList();
        List<IndustryPersonEntity> industryPersonList = new ArrayList<>();
        if (industryPersonsData.size() > 0) {
            List<Integer> industryPersonIds
                    = industryPersonsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            industryPersonList = industryPersonService.getIndustryPersonListByIds(industryPersonIds);
        }
        HashMap<String, Object> industryPersonResult = new HashMap<>();
        industryPersonResult.put("order", 3);
        industryPersonResult.put("name", IndexCategory.INDUSTRY_PERSON.getDesc());
        industryPersonResult.put("list", industryPersonList);
        ok.put(IndexCategory.INDUSTRY_PERSON.toString().toLowerCase(), industryPersonResult);

        //指南
        PageUtils guidesPaged = LuceneUtils.searcher(IndexCategory.GUIDE, query, pageNum, pageSize);
        List<Map<String, String>> guidesData = (List<Map<String, String>>) guidesPaged.getList();
        List<GuideEntity> guideList = new ArrayList<>();
        if (guidesData.size() > 0) {
            List<Integer> guideIds
                    = guidesData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            guideList = guideService.getGuideListByIds(guideIds);
        }
        HashMap<String, Object> guidesResult = new HashMap<>();
        guidesResult.put("order", 4);
        guidesResult.put("name", IndexCategory.GUIDE.getDesc());
        guidesResult.put("list", guideList);
        ok.put(IndexCategory.GUIDE.toString().toLowerCase(), guidesResult);

        //机构
        PageUtils organizationsPaged = LuceneUtils.searcher(IndexCategory.ORGANIZATION, query, pageNum, pageSize);
        List<Map<String, String>> organizationsData = (List<Map<String, String>>) organizationsPaged.getList();
        List<OrganizationEntity> organizationList = new ArrayList<>();
        if (organizationsData.size() > 0) {
            List<Integer> organizationIds
                    = organizationsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            organizationList = organizationService.getOrganizationListByIds(organizationIds);
        }
        HashMap<String, Object> organizationsResult = new HashMap<>();
        organizationsResult.put("order", 5);
        organizationsResult.put("name", IndexCategory.ORGANIZATION.getDesc());
        organizationsResult.put("list", organizationList);
        ok.put(IndexCategory.ORGANIZATION.toString().toLowerCase(), organizationsResult);

        return ok.encode(isEncryption);
    }

    /**
     * 搜索社区
     *
     * @param query 搜索字串
     */
    @PostMapping("/forums/{query}")
    //@ApiOperation("搜索社区")
    public RWapper forums(@PathVariable String query) throws IOException, ParseException {
        int pageNum = 1, pageSize = 100;
        RWapper ok = RWapper.ok();

        //运动健身
        PageUtils exerciseFitnessPaged = LuceneUtils.searcher(IndexCategory.EXERCISE_FITNESS, query, pageNum, pageSize);
        List<Map<String, String>> exerciseFitnessData = (List<Map<String, String>>) exerciseFitnessPaged.getList();
        List<ForumsEntity> exerciseFitnessList = new ArrayList<>();
        if (exerciseFitnessData.size() > 0) {
            List<Integer> exerciseFitnessIds
                    = exerciseFitnessData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            exerciseFitnessList = forumsService.getPostListByIds(exerciseFitnessIds);
        }
        HashMap<String, Object> exerciseFitnessResult = new HashMap<>();
        exerciseFitnessResult.put("order", 1);
        exerciseFitnessResult.put("name", IndexCategory.EXERCISE_FITNESS.getDesc());
        exerciseFitnessResult.put("list", exerciseFitnessList);
        ok.put(IndexCategory.EXERCISE_FITNESS.toString().toLowerCase(), exerciseFitnessResult);

        //营养
        PageUtils nutritionPaged = LuceneUtils.searcher(IndexCategory.NUTRITION, query, pageNum, pageSize);
        List<Map<String, String>> nutritionData = (List<Map<String, String>>) nutritionPaged.getList();
        List<ForumsEntity> nutritionList = new ArrayList<>();
        if (nutritionData.size() > 0) {
            List<Integer> nutritionIds
                    = nutritionData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            nutritionList = forumsService.getPostListByIds(nutritionIds);
        }
        HashMap<String, Object> nutritionResult = new HashMap<>();
        nutritionResult.put("order", 2);
        nutritionResult.put("name", IndexCategory.NUTRITION.getDesc());
        nutritionResult.put("list", nutritionList);
        ok.put(IndexCategory.NUTRITION.toString().toLowerCase(), nutritionResult);

        return ok.encode(isEncryption);
    }


    /**
     * 搜索商城
     *
     * @param query 搜索字串
     */
    @PostMapping("/mall/{query}")
    //@ApiOperation("搜索商城")
    public RWapper mall(@PathVariable String query) throws IOException, ParseException {
        int pageNum = 1, pageSize = 100;
        RWapper ok = RWapper.ok();

        //商品
        PageUtils goodsPaged = LuceneUtils.searcher(IndexCategory.GOODS, query, pageNum, pageSize);
        List<Map<String, String>> goodsData = (List<Map<String, String>>) goodsPaged.getList();
        List<GoodsEntity> goodsList = new ArrayList<>();
        if (goodsData.size() > 0) {
            List<Integer> goodsIds
                    = goodsData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            goodsList = goodsService.getGoodsListByIds(goodsIds);
        }
        HashMap<String, Object> goodsResult = new HashMap<>();
        goodsResult.put("order", 1);
        goodsResult.put("name", IndexCategory.GOODS.getDesc());
        goodsResult.put("list", goodsList);
        ok.put(IndexCategory.GOODS.toString().toLowerCase(), goodsResult);

        //场馆服务
        PageUtils hallServePaged = LuceneUtils.searcher(IndexCategory.HALL_SERVE, query, pageNum, pageSize);
        List<Map<String, String>> hallServeData = (List<Map<String, String>>) hallServePaged.getList();
        List<HallServeEntity> hallServeList = new ArrayList<>();
        if (hallServeData.size() > 0) {
            List<Integer> hallServeIds
                    = hallServeData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            hallServeList = hallServeService.getHallServeListByIds(hallServeIds);
        }
        HashMap<String, Object> hallServeResult = new HashMap<>();
        hallServeResult.put("order", 2);
        hallServeResult.put("name", IndexCategory.HALL_SERVE.getDesc());
        hallServeResult.put("list", hallServeList);
        ok.put(IndexCategory.HALL_SERVE.toString().toLowerCase(), hallServeResult);

        //教练服务
        PageUtils coachingServicePaged = LuceneUtils.searcher(IndexCategory.COACHING_SERVICE, query, pageNum, pageSize);
        List<Map<String, String>> coachingServiceData = (List<Map<String, String>>) coachingServicePaged.getList();
        List<CoachingServiceEntity> coachingServiceList = new ArrayList<>();
        if (coachingServiceData.size() > 0) {
            List<Integer> coachingServiceIds
                    = coachingServiceData.stream().map(m -> Integer.parseInt(m.get("id"))).collect(Collectors.toList());
            coachingServiceList = coachingServiceService.getCoachingServiceListByIds(coachingServiceIds);
        }
        HashMap<String, Object> coachingServiceResult = new HashMap<>();
        coachingServiceResult.put("order", 3);
        coachingServiceResult.put("name", IndexCategory.COACHING_SERVICE.getDesc());
        coachingServiceResult.put("list", coachingServiceList);
        ok.put(IndexCategory.COACHING_SERVICE.toString().toLowerCase(), coachingServiceResult);

        return ok.encode(isEncryption);
    }

    /**
     * 生成索引数据
     *
     * @param credential 凭据
     * @return
     */
    @PostMapping("/buildIndexData")
    //@ApiOperation("生成索引数据")
    public RWapper buildIndexData(@RequestParam String credential) throws IOException {
        if (!credential.equals("yymt.com"))
            return RWapper.error("凭据错误。");

        EnumSet<IndexCategory> newsCategory =
                EnumSet.of(IndexCategory.SPORTS_DYNAMICS,
                        IndexCategory.MASS_SPORTS,
                        IndexCategory.COMPETITIVE_SPORTS,
                        IndexCategory.SPORTS_INDUSTRY,
                        IndexCategory.OTHER_NEWS
                );
        for (IndexCategory category : newsCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }

        List<NewsEntity> newsList = newsService.selectList(
                new EntityWrapper<NewsEntity>()
                        .eq("news_status", 2)
        );
        for (NewsEntity news : newsList) {
            LuceneUtils.indexItem(
                    IndexCategory.matchCategory(TableName.NEWS, news.getNewsColumn()),
                    news.getId(),
                    news.getNewsTitle(),
                    news.getNewsContent()
            );
        }

        EnumSet<IndexCategory> gamesCategory =
                EnumSet.of(IndexCategory.SPORTS_GAMES,
                        IndexCategory.CORPORATION_GAMES
                );
        for (IndexCategory category : gamesCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<GamesEntity> gamesList = gamesService.selectList(
                new EntityWrapper<GamesEntity>()
                        .eq("game_status", 2)
        );
        for (GamesEntity game : gamesList) {
            LuceneUtils.indexItem(
                    IndexCategory.matchCategory(TableName.GAMES, game.getGameColumn()),
                    game.getId(),
                    game.getGameTitle(),
                    game.getGameContent()
            );
        }

        EnumSet<IndexCategory> hallsCategory =
                EnumSet.of(IndexCategory.HALL);
        for (IndexCategory category : hallsCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<HallEntity> hallList = hallService.selectList(
                new EntityWrapper<HallEntity>()
                        .eq("hall_status", 1)
        );
        for (HallEntity hall : hallList) {
            String contentText = "";
            contentText += Optional.ofNullable(hall.getHallIntroduction()).orElse("") + "\r\n";
            contentText += Optional.ofNullable(hall.getHallAddress()).orElse("") + "\r\n";
            List<HallSportEntity> hallSports = hallSportService.selectList(
                    new EntityWrapper<HallSportEntity>().eq("hall_id", hall.getId()));
            for (HallSportEntity hallSport : hallSports) {
                SportsEntity sportsEntity = sportsService.selectById(hallSport.getSportId());
                contentText += Optional.ofNullable(sportsEntity.getSportName()).orElse("") + "\r\n";
            }
            LuceneUtils.indexItem(
                    IndexCategory.HALL,
                    hall.getId(),
                    hall.getHallName(),
                    contentText
            );
        }

        EnumSet<IndexCategory> corporationsCategory =
                EnumSet.of(
                        IndexCategory.CORPORATION
                );
        for (IndexCategory category : corporationsCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<CorporationEntity> corporationList = corporationService.selectList(
                new EntityWrapper<CorporationEntity>()
                        .eq("corporation_status", 1)
        );
        for (CorporationEntity corporation : corporationList) {
            String contentText = "";
            contentText += Optional.ofNullable(corporation.getCorporationLeader()).orElse("") + "\r\n";
            contentText += Optional.ofNullable(corporation.getCorporationContact()).orElse("") + "\r\n";
            contentText += Optional.ofNullable(corporation.getCorporationAddress()).orElse("") + "\r\n";
            contentText += Optional.ofNullable(corporation.getCorporationIntroduce()).orElse("") + "\r\n";
            LuceneUtils.indexItem(
                    IndexCategory.CORPORATION,
                    corporation.getId(),
                    corporation.getCorporationName(),
                    contentText
            );
        }

        EnumSet<IndexCategory> industryPersonCategory =
                EnumSet.of(IndexCategory.INDUSTRY_PERSON);
        for (IndexCategory category : industryPersonCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<IndustryPersonEntity> industryPersonList = industryPersonService.getIndustryPersonListAll();
        for (IndustryPersonEntity industryPerson : industryPersonList) {
            String contentText = "";
            contentText += Optional.ofNullable(industryPerson.getSportLevelString()).orElse("") + "\r\n";

            LuceneUtils.indexItem(
                    IndexCategory.INDUSTRY_PERSON,
                    industryPerson.getId(),
                    industryPerson.getRealName(),
                    contentText
            );
        }

        EnumSet<IndexCategory> guidesCategory =
                EnumSet.of(
                        IndexCategory.GUIDE
                );
        for (IndexCategory category : guidesCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<GuideEntity> guideList = guideService.selectList(
                new EntityWrapper<>()
        );
        for (GuideEntity guide : guideList) {
            LuceneUtils.indexItem(
                    IndexCategory.GUIDE,
                    guide.getId(),
                    guide.getName(),
                    guide.getFile()
            );
        }

        EnumSet<IndexCategory> organizationsCategory =
                EnumSet.of(
                        IndexCategory.ORGANIZATION
                );
        for (IndexCategory category : organizationsCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<OrganizationEntity> organizationList = organizationService.selectList(
                new EntityWrapper<OrganizationEntity>().eq("status", 2)
        );
        for (OrganizationEntity organization : organizationList) {
            String contentText = "";
            contentText += Optional.ofNullable(organization.getAddress()).orElse("") + "\r\n";
            contentText += Optional.ofNullable(organization.getDuty()).orElse("") + "\r\n";
            LuceneUtils.indexItem(
                    IndexCategory.ORGANIZATION,
                    organization.getId(),
                    organization.getOrgName(),
                    contentText
            );
        }

        EnumSet<IndexCategory> forumsCategory =
                EnumSet.of(
                        IndexCategory.EXERCISE_FITNESS,
                        IndexCategory.NUTRITION,
                        IndexCategory.OTHER_FORUMS_TYPE
                );
        for (IndexCategory category : forumsCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<ForumsEntity> postList = forumsService.selectList(
                new EntityWrapper<ForumsEntity>()
                        .eq("forums_status", 1)
        );
        for (ForumsEntity post : postList) {
            LuceneUtils.indexItem(
                    IndexCategory.matchCategory(TableName.FORUMS, post.getForumsType()),
                    post.getId(),
                    "",
                    post.getContent()
            );
        }

        EnumSet<IndexCategory> goodsCategory =
                EnumSet.of(
                        IndexCategory.GOODS
                );
        for (IndexCategory category : goodsCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<GoodsEntity> goodsList = goodsService.selectList(
                new EntityWrapper<GoodsEntity>().eq("goods_status", 1)
        );
        for (GoodsEntity goods : goodsList) {
            Integer id = goods.getId().intValue();
            String contentText = "";
            contentText += Optional.ofNullable(goods.getGoodsDetails()).orElse("") + "\r\n";
            LuceneUtils.indexItem(
                    IndexCategory.GOODS,
                    id,
                    goods.getGoodsName(),
                    contentText
            );
        }

        EnumSet<IndexCategory> hallServeCategory =
                EnumSet.of(
                        IndexCategory.HALL_SERVE
                );
        for (IndexCategory category : hallServeCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<HallServeEntity> hallServeList = hallServeService.selectList(
                new EntityWrapper<HallServeEntity>().eq("serve_status", 1)
        );
        for (HallServeEntity hallServe : hallServeList) {
            String contentText = "";
            contentText += Optional.ofNullable(hallServe.getServeTips()).orElse("") + "\r\n";
            LuceneUtils.indexItem(
                    IndexCategory.HALL_SERVE,
                    hallServe.getId(),
                    hallServe.getServeName(),
                    contentText
            );
        }

        EnumSet<IndexCategory> coachingServiceCategory =
                EnumSet.of(
                        IndexCategory.COACHING_SERVICE
                );
        for (IndexCategory category : coachingServiceCategory) {
            LuceneUtils.deleteIndexCategory(category);
        }
        List<CoachingServiceEntity> coachingServiceList = coachingServiceService.selectList(
                new EntityWrapper<CoachingServiceEntity>().eq("service_status", 1)
        );

        return RWapper.ok().encode(isEncryption);
    }
}
