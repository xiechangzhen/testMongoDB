package com.yymt.modules.common.entity.antiepidemic;

import com.alibaba.fastjson.JSONObject;

/**
 * todo
 *
 * @author xiezhen
 * @since 2020/3/3
 */
public class MongoEntity {
    private JSONObject Metadata;

    public JSONObject getMetadata() {
        return Metadata;
    }

    public void setMetadata(JSONObject metadata) {
        Metadata = metadata;
    }
}
