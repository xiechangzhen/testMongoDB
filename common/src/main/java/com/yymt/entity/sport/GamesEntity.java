package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 赛事培训表
 *
 * @author cots
 * @date 2018-09-13 10:16:31
 */
@TableName("tb_games")
@ApiModel(description = "赛事培训表")
public class GamesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 赛事Id
     */
    @TableId
    @ApiModelProperty(value = "赛事Id")
    private Integer id;
    /**
     * 新闻标题
     */
    @ApiModelProperty(value = "新闻标题")
    private String gameTitle;
    /**
     * 新闻内容
     */
    @ApiModelProperty(value = "新闻内容")
    private String gameContent;
    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String gameSummary;
    /**
     * 新闻导航图片
     */
    @ApiModelProperty(value = "新闻导航图片")
    private String gameNavImage;
    /**
     * 赛事类型（体育项目表）
     */
    @ApiModelProperty(value = "赛事类型（体育项目表）")
    private Integer gameType;
    /**
     * 新闻状态(1-审核中,2-审核通过,3-审核失败，4-删除)
     */
    @ApiModelProperty(value = "新闻状态(1-审核中,2-审核通过,3-审核失败，4-删除)")
    @JsonIgnore
    private Integer gameStatus;
    /**
     * 报名开始时间
     * JsonFormat会影响保存的数据，慎用
     */
    @ApiModelProperty(value = "报名开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityStartTime;
    /**
     * 报名截止时间
     */
    @ApiModelProperty(value = "报名截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;
    /**
     * 报名方式
     */
    @ApiModelProperty(value = "报名方式")
    private String signUpWay;
    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    @JsonIgnore
    private Long gameAuthor;
    /**
     * 作者类别（1-管理员，2-普通用户）
     */
    @ApiModelProperty(value = "作者类别（1-管理员，2-普通用户）")
    @JsonIgnore
    private Integer authorType;
    /**
     * 新闻栏目
     */
    @ApiModelProperty(value = "新闻栏目")
    private Integer gameColumn;
    /**
     * 所属社团ID
     */
    @ApiModelProperty(value = "所属社团ID")
    private Integer corporationId;
    /**
     * 点击数
     */
    @ApiModelProperty(value = "点击数")
    @JsonIgnore
    private Integer pageView;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
    private Date gameCreateTime;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    @JsonIgnore
    private Long gameAuditor;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    @JsonIgnore
    private Date gameAuditTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
    private Date gameUpdateTime;
    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    @JsonIgnore
    private Long gameUpdator;
    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    private Integer gameIsRecommend;
    /**
     * 赞助联系人电话
     */
    @ApiModelProperty(value = "赞助联系人电话")
    private String gameSupportContact;
    /**
     * 赞助联系人姓名
     */
    @ApiModelProperty(value = "赞助联系人姓名")
    private String gameSupportContactName;
    /**
     * 是否需要赞助
     */
    @ApiModelProperty(value = "是否需要赞助")
    private Integer gameNeedSupport;
    /**
     * 是否开启报名
     */
    @ApiModelProperty(value = "是否开启报名")
    private Integer gameIsOpen;
    /**
     * 参与人数限制
     */
    @ApiModelProperty(value = "参与人数限制")
    private Long gamePeopleLimit;
    /**
     * 上传文档
     */
    @ApiModelProperty(value = "上传文档")
    private String gameFiles;
    /**
     * 省份代码
     */
    @ApiModelProperty(value = "省份代码")
    private Long gameProvinceCode;
    /**
     * 城市代码
     */
    @ApiModelProperty(value = "城市代码")
    private Long gameCityCode;
    /**
     * 区县代码
     */
    @ApiModelProperty(value = "区县代码")
    private Long gameAreaCode;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String gameDetailAddress;
    /**
     * 最小年龄限制
     */
    @ApiModelProperty(value = "最小年龄限制")
    private Integer gameAgeLimitMin;
    /**
     * 最大年龄限制
     */
    @ApiModelProperty(value = "最大年龄限制")
    private Integer gameAgeLimitMax;
    /**
     * 完整地址
     */
    @ApiModelProperty(value = "完整地址")
    private String gameFullAddress;
    /**
     * 附件
     */
    @ApiModelProperty(value = "附件")
    private String gameAttach;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 点赞数
     */
    @TableField(exist = false)
    private Integer greats;

    /**
     * 报名人数是否达到限额人数
     */
    @TableField(exist = false)
    private Boolean isPeopleOver;

    public String getGameAttach() {
        return gameAttach;
    }

    public void setGameAttach(String gameAttach) {
        this.gameAttach = gameAttach;
    }

    /**
     * 设置：赛事Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：赛事Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：新闻标题
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    /**
     * 获取：新闻标题
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * 设置：新闻内容
     */
    public void setGameContent(String gameContent) {
        this.gameContent = gameContent;
    }

    /**
     * 获取：新闻内容
     */
    public String getGameContent() {
        return gameContent;
    }

    /**
     * 设置：摘要
     */
    public void setGameSummary(String gameSummary) {
        this.gameSummary = gameSummary;
    }

    /**
     * 获取：摘要
     */
    public String getGameSummary() {
        return gameSummary;
    }

    /**
     * 设置：新闻导航图片
     */
    public void setGameNavImage(String gameNavImage) {
        this.gameNavImage = gameNavImage;
    }

    /**
     * 获取：新闻导航图片
     */
    public String getGameNavImage() {
        return gameNavImage;
    }

    /**
     * 设置：赛事类型（体育项目表）
     */
    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    /**
     * 获取：赛事类型（体育项目表）
     */
    public Integer getGameType() {
        return gameType;
    }

    /**
     * 设置：新闻状态(1-审核中,2-审核通过,3-审核失败，4-删除)
     */
    public void setGameStatus(Integer gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * 获取：新闻状态(1-审核中,2-审核通过,3-审核失败，4-删除)
     */
    public Integer getGameStatus() {
        return gameStatus;
    }

    /**
     * 设置：报名开始时间
     */
    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    /**
     * 获取：报名开始时间
     */
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    /**
     * 设置：报名截止时间
     */
    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    /**
     * 获取：报名截止时间
     */
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public String getSignUpWay() {
        return signUpWay;
    }

    public void setSignUpWay(String signUpWay) {
        this.signUpWay = signUpWay;
    }

    /**
     * 设置：作者
     */
    public void setGameAuthor(Long gameAuthor) {
        this.gameAuthor = gameAuthor;
    }

    /**
     * 获取：作者
     */
    public Long getGameAuthor() {
        return gameAuthor;
    }

    /**
     * 设置：作者类别（1-管理员，2-普通用户）
     */
    public void setAuthorType(Integer authorType) {
        this.authorType = authorType;
    }

    /**
     * 获取：作者类别（1-管理员，2-普通用户）
     */
    public Integer getAuthorType() {
        return authorType;
    }

    /**
     * 设置：新闻栏目
     */
    public void setGameColumn(Integer gameColumn) {
        this.gameColumn = gameColumn;
    }

    /**
     * 获取：新闻栏目
     */
    public Integer getGameColumn() {
        return gameColumn;
    }

    /**
     * 设置：所属社团ID
     */
    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }

    /**
     * 获取：所属社团ID
     */
    public Integer getCorporationId() {
        return corporationId;
    }

    /**
     * 设置：点击数
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * 获取：点击数
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * 设置：创建时间
     */
    public void setGameCreateTime(Date gameCreateTime) {
        this.gameCreateTime = gameCreateTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getGameCreateTime() {
        return gameCreateTime;
    }

    /**
     * 设置：审核人
     */
    public void setGameAuditor(Long gameAuditor) {
        this.gameAuditor = gameAuditor;
    }

    /**
     * 获取：审核人
     */
    public Long getGameAuditor() {
        return gameAuditor;
    }

    /**
     * 设置：审核时间
     */
    public void setGameAuditTime(Date gameAuditTime) {
        this.gameAuditTime = gameAuditTime;
    }

    /**
     * 获取：审核时间
     */
    public Date getGameAuditTime() {
        return gameAuditTime;
    }

    /**
     * 设置：修改时间
     */
    public void setGameUpdateTime(Date gameUpdateTime) {
        this.gameUpdateTime = gameUpdateTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getGameUpdateTime() {
        return gameUpdateTime;
    }

    /**
     * 设置：修改人
     */
    public void setGameUpdator(Long gameUpdator) {
        this.gameUpdator = gameUpdator;
    }

    /**
     * 获取：修改人
     */
    public Long getGameUpdator() {
        return gameUpdator;
    }

    /**
     * 设置：是否推荐
     */
    public void setGameIsRecommend(Integer gameIsRecommend) {
        this.gameIsRecommend = gameIsRecommend;
    }

    /**
     * 获取：是否推荐
     */
    public Integer getGameIsRecommend() {
        return gameIsRecommend;
    }

    /**
     * 设置：赞助联系人电话
     */
    public void setGameSupportContact(String gameSupportContact) {
        this.gameSupportContact = gameSupportContact;
    }

    /**
     * 获取：赞助联系人电话
     */
    public String getGameSupportContact() {
        return gameSupportContact;
    }

    /**
     * 设置：赞助联系人姓名
     */
    public void setGameSupportContactName(String gameSupportContactName) {
        this.gameSupportContactName = gameSupportContactName;
    }

    /**
     * 获取：赞助联系人姓名
     */
    public String getGameSupportContactName() {
        return gameSupportContactName;
    }

    /**
     * 设置：是否需要赞助
     */
    public void setGameNeedSupport(Integer gameNeedSupport) {
        this.gameNeedSupport = gameNeedSupport;
    }

    /**
     * 获取：是否需要赞助
     */
    public Integer getGameNeedSupport() {
        return gameNeedSupport;
    }

    /**
     * 设置：是否开启报名
     */
    public void setGameIsOpen(Integer gameIsOpen) {
        this.gameIsOpen = gameIsOpen;
    }

    /**
     * 获取：是否开启报名
     */
    public Integer getGameIsOpen() {
        return gameIsOpen;
    }

    /**
     * 设置：参与人数限制
     */
    public void setGamePeopleLimit(Long gamePeopleLimit) {
        this.gamePeopleLimit = gamePeopleLimit;
    }

    /**
     * 获取：参与人数限制
     */
    public Long getGamePeopleLimit() {
        return gamePeopleLimit;
    }

    /**
     * 设置：上传文档
     */
    public void setGameFiles(String gameFiles) {
        this.gameFiles = gameFiles;
    }

    /**
     * 获取：上传文档
     */
    public String getGameFiles() {
        return gameFiles;
    }

    /**
     * 设置：省份代码
     */
    public void setGameProvinceCode(Long gameProvinceCode) {
        this.gameProvinceCode = gameProvinceCode;
    }

    /**
     * 获取：省份代码
     */
    public Long getGameProvinceCode() {
        return gameProvinceCode;
    }

    /**
     * 设置：城市代码
     */
    public void setGameCityCode(Long gameCityCode) {
        this.gameCityCode = gameCityCode;
    }

    /**
     * 获取：城市代码
     */
    public Long getGameCityCode() {
        return gameCityCode;
    }

    /**
     * 设置：区县代码
     */
    public void setGameAreaCode(Long gameAreaCode) {
        this.gameAreaCode = gameAreaCode;
    }

    /**
     * 获取：区县代码
     */
    public Long getGameAreaCode() {
        return gameAreaCode;
    }

    /**
     * 设置：详细地址
     */
    public void setGameDetailAddress(String gameDetailAddress) {
        this.gameDetailAddress = gameDetailAddress;
    }

    /**
     * 获取：详细地址
     */
    public String getGameDetailAddress() {
        return gameDetailAddress;
    }

    /**
     * 设置：最小年龄限制
     */
    public void setGameAgeLimitMin(Integer gameAgeLimitMin) {
        this.gameAgeLimitMin = gameAgeLimitMin;
    }

    /**
     * 获取：最小年龄限制
     */
    public Integer getGameAgeLimitMin() {
        return gameAgeLimitMin;
    }

    /**
     * 设置：最大年龄限制
     */
    public void setGameAgeLimitMax(Integer gameAgeLimitMax) {
        this.gameAgeLimitMax = gameAgeLimitMax;
    }

    /**
     * 获取：最大年龄限制
     */
    public Integer getGameAgeLimitMax() {
        return gameAgeLimitMax;
    }

    /**
     * 设置：完整地址
     */
    public void setGameFullAddress(String gameFullAddress) {
        this.gameFullAddress = gameFullAddress;
    }

    /**
     * 获取：完整地址
     */
    public String getGameFullAddress() {
        return gameFullAddress;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 获取：点赞数
     */
    public Integer getGreats() {
        return greats;
    }

    /**
     * 设置：点赞数
     */
    public void setGreats(Integer greats) {
        this.greats = greats;
    }

    /*
    public boolean isActive() {
        boolean result = true;
        Date now = new Date();
        if (this.activityStartTime != null && this.activityEndTime != null
                && !this.activityStartTime.after(now)
                && !this.activityEndTime.before(now)
                ) {
            result = false;
        }
        return result;
    }
    */


    /**
     * 获取：报名人数是否达到限额人数
     *
     * @return
     */
    public Boolean isPeopleOver() {
        return isPeopleOver;
    }

    /**
     * 设置：报名人数是否达到限额人数
     *
     * @param peopleOver
     */
    public void setPeopleOver(Boolean peopleOver) {
        isPeopleOver = peopleOver;
    }

}
