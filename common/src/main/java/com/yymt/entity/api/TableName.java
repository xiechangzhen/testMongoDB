package com.yymt.entity.api;

/**
 * Created by yyt on 2018/9/28.
 */
public enum TableName {
    NEWS("news"),
    GAMES("games"),
    HALL("hall"),
    CORPORATION("corporation"),
    INDUSTRY_PERSON("industry_person"),
    GUIDE("guide"),
    ORGANIZATION("organization"),
    FORUMS("forums"),
    USER("user"),
    GOODS("goods"),
    HALL_SERVE("hall_serve"),
    COACHING_SERVICE("coaching_service"),;

    TableName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return this.name;
    }
}
