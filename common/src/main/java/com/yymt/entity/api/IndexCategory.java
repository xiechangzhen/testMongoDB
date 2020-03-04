package com.yymt.entity.api;

import java.util.Arrays;

/**
 * 搜索栏目大类
 * Created by yyt on 2018/9/28.
 */
public enum IndexCategory {

    SPORTS_DYNAMICS("体育动态", TableName.NEWS, new int[]{23, 24, 25}),
    SPORTS_GAMES("体育赛事", TableName.GAMES, new int[]{13, 15, 17}),
    MASS_SPORTS("群众体育", TableName.NEWS, new int[]{16}),
    COMPETITIVE_SPORTS("竞技体育", TableName.NEWS, new int[]{12}),
    SPORTS_INDUSTRY("体育产业", TableName.NEWS, new int[]{18}),
    OTHER_NEWS("其它新闻", TableName.NEWS, new int[]{14, 19, 20, 22}),
    CORPORATION_GAMES("社团赛事", TableName.GAMES, new int[]{21}),
    HALL("场馆", TableName.HALL, null),
    CORPORATION("社团", TableName.CORPORATION, null),
    GUIDE("指南", TableName.GUIDE, null),
    INDUSTRY_PERSON("行业人员", TableName.INDUSTRY_PERSON, null),
    ORGANIZATION("机构", TableName.ORGANIZATION, null),
    EXERCISE_FITNESS("运动健身", TableName.FORUMS, new int[]{1}),
    NUTRITION("营养", TableName.FORUMS, new int[]{2}),
    OTHER_FORUMS_TYPE("其它社区栏目", TableName.FORUMS, new int[]{}),
    USER("用户", TableName.USER, null),
    GOODS("商品", TableName.GOODS, null),
    HALL_SERVE("场馆服务", TableName.HALL_SERVE, null),
    COACHING_SERVICE("教练服务", TableName.COACHING_SERVICE, null),;

    /**
     * 根据数据库表名和栏目标识匹配相应搜索模块类别
     *
     * @param tableName 数据库对应的表名
     * @param columnId  新闻和社区需要，其它可传null，或直接使用枚举实例
     * @return IndexCategory
     */
    public static IndexCategory matchCategory(TableName tableName, Integer columnId) {
        IndexCategory[] categories = IndexCategory.class.getEnumConstants();
        switch (tableName) {
            case GOODS:
                return IndexCategory.GOODS;
            case HALL_SERVE:
                return IndexCategory.HALL_SERVE;
            case COACHING_SERVICE:
                return IndexCategory.COACHING_SERVICE;
            case HALL:
                return IndexCategory.HALL;
            case CORPORATION:
                return IndexCategory.CORPORATION;
            case GUIDE:
                return IndexCategory.GUIDE;
            case ORGANIZATION:
                return IndexCategory.ORGANIZATION;
            case USER:
                return IndexCategory.USER;
            case NEWS:
                if (columnId == null)
                    return IndexCategory.OTHER_NEWS;
                return Arrays.stream(categories).filter(c ->
                        c.tableName == TableName.NEWS
                                && Arrays.stream(c.getColumnIds()).anyMatch(id -> id == columnId))
                        .findFirst().orElse(IndexCategory.OTHER_NEWS);
            case GAMES:
                if (columnId == null)
                    return IndexCategory.SPORTS_GAMES;
                return Arrays.stream(categories).filter(c ->
                        c.tableName == TableName.GAMES
                                && Arrays.stream(c.getColumnIds()).anyMatch(id -> id == columnId))
                        .findFirst().orElse(IndexCategory.SPORTS_GAMES);
            case FORUMS:
                if (columnId == null)
                    return IndexCategory.OTHER_FORUMS_TYPE;
                return Arrays.stream(categories).filter(c ->
                        c.tableName == TableName.FORUMS
                                && Arrays.stream(c.getColumnIds()).anyMatch(id -> id == columnId))
                        .findFirst().orElse(IndexCategory.OTHER_FORUMS_TYPE);
        }
        return null;
    }

    IndexCategory(String desc, TableName tableName, int[] columnIds) {
        this.desc = desc;
        this.tableName = tableName;
        this.columnIds = columnIds;
    }

    private String desc;
    private TableName tableName;
    private int[] columnIds;

    public String getDesc() {
        return desc;
    }

    public TableName getTableName() {
        return tableName;
    }

    public int[] getColumnIds() {
        return columnIds;
    }
}
