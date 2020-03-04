/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.yymt.common.utils;

/**
 * 常量
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2016-11-15
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;
    /**
     * 数据权限过滤
     */
    public static final String SQL_FILTER = "sql_filter";
    /**
     * 场馆服务类型
     * */
    public static final String SERVER_TYPE = "servicetype";
    /**
     * 商城举报类型
     * */
    public static final String MALL_REVEAL = "mallReveal";
    /**
     * 文件上传最大50M
     */
    public static final Integer MAX_FILE_SIZE = 50 * 1024 * 1024;
    /**
     * 文件上传最大20M
     */
    public static final Integer MAX_FILE_SIZE_TWENTY = 20 * 1024 * 1024;
    /**
     * 文件上传最大30M
     */
    public static final Integer MAX_SOUND_FILE_SIZE = 30 * 1024 * 1024;

    /**
     * 消息类型：消息-1
     */
    public static final Integer MESSAGE_TYPE_MSG = 1;
//    public static final Integer MESSAGE_TYPE_WORDS = 2;
    /**
     * 消息栏目（赞-1，评论-2，关注-3）
     */
    public static final Integer MESSAGE_TAB_GREATS = 1;
    public static final Integer MESSAGE_TAB_COMMENT = 2;
    public static final Integer MESSAGE_TAB_FOLLOW = 3;
//    public static final Integer MESSAGE_TAB_WORDS = 4;//留言
    /**
     * 消息栏目再细分（1-新闻点赞2-社团点赞3-社区点赞4-社区评论点赞5-社区评论6-关注个人7-关注社团8-社区评论的回复）
     */
    public static final Integer MESSAGE_TAB_TYPE_GREATS_NEWS = 1;
    public static final Integer MESSAGE_TAB_TYPE_GREATS_CORPORATION = 2;
    public static final Integer MESSAGE_TAB_TYPE_GREATS_FORUMS = 3;
    public static final Integer MESSAGE_TAB_TYPE_GREATS_FORUMS_COMMENT = 4;
    public static final Integer MESSAGE_TAB_TYPE_FORUMS_COMMENT = 5;
    public static final Integer MESSAGE_TAB_TYPE_FOLLOW_PERSON = 6;
    public static final Integer MESSAGE_TAB_TYPE_FOLLOW_CORPORATION = 7;
    public static final Integer MESSAGE_TAB_TYPE_FORUMS_COMMENT_REPLY = 8;


    public static final int USER_STATUS_DELETE = 0;//用户帐号被删除
    public static final int USER_STATUS_NORMAL = 1;//用户帐号正常
    public static final int USER_STATUS_CHECK_PENDING = 2;//用户帐号正常并专家审核中
    public static final int USER_STATUS_CHECK_PASS = 3;//专家号正常
    public static final int USER_STATUS_CHECK_UNPASS = 4;//用户帐号正常，专家升级不通过
    public static final int USER_STATUS_DISABLED = 5;//用户帐号被禁用


    /*** 社区分类 1-运动健身 2-营养***/
    public static final int FORUMS_TYPE_SPORT = 1;
    public static final int FORUMS_TYPE_NUTRITION = 2;

    /*** 社区状态(-1 被删除;0 被隐藏;1 正常;2 被举报) ***/
    public static final int FORUMS_STATUS_DELETE = -1;
    public static final int FORUMS_STATUS_HIDE = 0;
    public static final int FORUMS_STATUS_NORMAL = 1;
    public static final int FORUMS_STATUS_REVEAL = 2;

    /*** 举报状态（0-待处理1-有效举报 2-无效举报） ***/
    public static final Integer REVEAL_ON_AUDIT = 0;
    public static final Integer REVEAL_VALID = 1;
    public static final Integer REVEAL_INVALID = 2;


    /**
     * 身份（1：社团管理员；2：场馆管理员；3：教练；4：商家；）
     * */
    public static final Integer IDENTITY_CORPORATION = 1;
    public static final Integer IDENTITY_HALL = 2;
    public static final Integer IDENTITY_COACH = 3;
    public static final Integer IDENTITY_SELLER = 4;


    /*** 举报类型（1社区举报,2店铺举报,3商品举报,4场馆服务举报,5教练服务举报） ***/
    public static final Integer FORUMS_REVEAL = 1;
    public static final Integer STORE_REVEAL = 2;
    public static final Integer GOODS_REVEAL = 3;
    public static final Integer HALL_SERVE_REVEAL = 4;
    public static final Integer COACHING_SERVICE_REVEAL = 5;


    /**
     * 收到消息留言
     */
    public static final int PUSH_TYPE_MESSAGE = 6;
    /**
     * 预约评价
     */
    public static final int PUSH_TYPE_EVALUATE = 5;
    /**
     * 文章审核通过发送给粉丝
     */
    public static final int PUSH_TYPE_PUBLIC_NEWS_TO_FANS = 4;
    /**
     * 文章审核通过失败
     */
    public static final int PUSH_TYPE_NEWS_PASS_FAID = 3;

    /**
     * 推送的新闻栏新闻
     */
    public static final int PUSH_TYPE_HOME_NEWS = 5;

    /**
     * 推送的赛事
     */
    public static final int PUSH_TYPE_GAME = 4;

    /**
     * 推送的帖子
     */
    public static final int PUSH_TYPE_FORUMS = 3;
    /**
     * 推送的社团新闻
     */
    public static final int PUSH_TYPE_CORPORATION_NEWS = 1;
    /**
     * 推送的社团赛事培训
     */
    public static final int PUSH_TYPE_CORPORATION_GAMES = 2;

    /*** 问题反馈 - 状态（0-未处理，1-待解决，2-已解决）***/
    public static final int FEEDBACK_STATUS_UNHANDLE = 0;
    public static final int FEEDBACK_STATUS_ONHANDLE = 1;
    public static final int FEEDBACK_STATUS_RESOLVED = 2;

    /*** 问题反馈 - 回复人类型（1-后台，2-APP）***/
    public static final int FEEDBACK_UER_TYPE_ADMIN = 1;
    public static final int FEEDBACK_UER_TYPE_USER = 2;
    /**
     * 1-审核中,2-审核通过,3-审核不通过，4-删除
     **/
    public static final int NEWS_STATUS_AUDIT = 1;
    public static final int NEWS_STATUS_PASS = 2;
    public static final int NEWS_STATUS_UNPASS = 3;
    public static final int NEWS_STATUS_DELETE = 4;


    /**
     * 所有新创建的表涉及到审核状态的，统一使用此定义
     * 0-审核中,1-审核通过,2-审核不通过，3-未入驻
     **/
    public static final int STATUS_AUDIT = 0;
    public static final int STATUS_PASS = 1;
    public static final int STATUS_UNPASS = 2;
    public static final int STATUS_UNENTER = 3;
    
    /**
	 *   微信公众平台-用户授权登录锁
	 */
	public static final Object USER_LOCK = new Object();

    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 文件类型
     */
    public enum FileType {

        FILE("file"),
        /**
         * 图片
         */
        IMAGE("image"),
        /**
         * WORD
         */
        WORD("word"),
        /**
         * XLS
         */
        XLS("xls");

        private String type;

        FileType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 搜索类别
     */
    public enum ContentType {
        /**
         * 新闻咨询
         */
        NEWS(0),
        /**
         * 赛事培训
         */
        GAMES(1);

        private int value;

        ContentType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * LUCENE 索引字段
     */
    public enum LuceneField {
        /**
         * 搜索类别
         */
        CATEGORY("category"),
        /**
         * 所属表ID
         */
        ID("id"),
        /**
         * 表类型
         */
        TYPE("type"),
        /**
         * 标题
         */
        TITLE("title"),

        /**
         * 内容
         */
        CONTENT("content");

        private String value;

        LuceneField(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 帮助最佳
     */
    public enum IsBestAnswer {
        /**
         * 最佳
         */
        TRUE(1),
        /**
         * 不是最佳
         */
        FALSE(0);

        private int value;

        IsBestAnswer(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否解决
     */
    public enum IsSolve {
        /**
         * 已解决
         */
        TRUE(1),
        /**
         * 未解决
         */
        FALSE(0);

        private int value;

        IsSolve(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否在线标志
     */
    public enum IsOnline {
        /**
         * 在线
         */
        TRUE(1),
        /**
         * 离线
         */
        FALSE(0);

        private int value;

        IsOnline(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否已读
     */
    public enum MessageStatus {
        /**
         * 已读
         */
        TRUE(1),
        /**
         * 未读
         */
        FALSE(0);

        private int value;

        MessageStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 获取验证码类型
     */
    public enum VcodeType {
        /**
         * 注册
         */
        REGISTER(0),
        /**
         * app忘记密码
         */
        APP_FOGET(1),
        /**
         * 后台忘记密码
         */
        BG_FORGET(2),
        /**
         * APP修改密码
         */
        APP_UPDATE_PWD(3),
        /**
         * 手机绑定
         */
        PHONT_BIND(4);
        private int value;

        VcodeType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
