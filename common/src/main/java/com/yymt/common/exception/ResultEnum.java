package com.yymt.common.exception;

/**
 * Created by yymt_hgq on 2018/2/6.
 */
public enum ResultEnum {
    NO_IMPLEMENT(-1, "接口尚未实现"),

    SUCCESS(0, "成功"),

    ERROR(500, "服务器异常，请联系管理员"),
    REDIS_ERROR(501, "Redis服务异常"),

    DATA_ALREADY_EXIST(100, "数据库中已存在该记录"),

    DATA_NOT_EXIST(101, "数据不存在"),
    DELETE_ERROR(102, "删除失败"),
    ADD_ERROR(103, "添加失败"),
    UPDATE_ERROR(104, "修改失败"),
    MANAGE_ERROR(105, "操作失败"),
    SUBMIT_ERROR(99, "审核失败"),

    USERNAME_PASSWORD_ERROR(106, "账号或密码错误"),
    USER_LOCKED(107, "账号已被锁定,请联系管理员"),
    USER_AUTH_ERROR(108, "账户验证失败"),
    NO_PERMISSION(109, "没有权限，请联系管理员授权"),
    OLD_PASSWORD_MISTAKE(110, "原密码不正确"),
    ADMIN_CANT_DELETE(111, "系统管理员不能删除"),
    USER_CANT_DELETE(112, "当前用户不能删除"),
    USER_NOT_EXPERT(113, "您不是咨询师"),
    USER_NOT_EXIST(114, "用户不存在"),
    USER_FORBID(115, "当前账号被禁用"),
    USER_DELETED(116, "账号被删除"),
    USER_EXIST(117, "用户已存在"),
    USER_PWD_ERROR(118, "新密码与确认密码不相同"),
    UPDATE_PWD_FAIL(119, "修改密码失败"),
    ACCOUNT_NOT_EXIST(120, "账号不存在"),
    USERNAME_NULL(121, "请输入用户名"),
    PASSWORD_NULL(122, "请输入密码"),
    RESTRICT_LOGIN(123, "连续五次密码输入错误,请一小时后再登录"),
    EXPERT_FORBID_CANT_COMMENT(124, "该专家被禁用，不能评价"),
    MUSTH_FROM_THIRD_PARTY(125, "登录失败，请使用第三方登录"),
    ADMIN_ROLE_CANT_MODIFY(125, "不能更改系统管理员角色权限"),

    SENSITIVE_WORD(599, "您输入的信息中包含了违禁信息"),
    INVALID_INPUT(600, "包含非法字符"),
    PARAM_TYPE_ERROR(601, "参数类型错误"),
    PARAM_BLANK(602, "参数为空"),
    PARAM_NULL(603, "参数NULL"),
    GET_PARAM_ERROR(604, "获取参数失败"),
    VALIDATOR_NOT_PASS(605, "校验未通过"),
    API_ONLY_MAP(606, "数据权限接口，只能是Map类型参数，且不能为NULL"),

    VALIDATOR_CODE_MISTAKE(664, "验证码不正确"),
    VALIDATOR_CODE_SEND_ERROR(665, "发送验证码失败"),
    VALIDATOR_CODE_INVALID(666, "验证码已失效"),

    MENU_NOT_NULL(700, "菜单名称不能为空"),
    PARENT_MENU_NOT_NULL(701, "上级菜单不能为空"),
    MENU_URL_NOT_NULL(702, "菜单URL不能为空"),
    PARENT_MENU_ONLY_CATALOG(702, "上级菜单只能为目录类型"),
    PARENT_MENU_ONLY_MENU(703, "上级菜单只能为菜单类型"),
    SYSTEM_MENU_CANT_DELETE(704, "系统菜单，不能删除"),
    DELETE_CHILD_OR_BUTTON_FIRST(705, "请先删除子菜单或按钮"),
    SYSTEM_COLUMN_CANT_UPDATE(706, "系统的栏目名称不能修改"),
    SYSTEM_COLUMN_CANT_DELETE(707, "所选的数据中包含了系统的栏目，不能删除"),

    DELETE_CHILD_DEPARTMENT_FIRST(710, "请先删除子部门"),

    NICK_NAME_ALREADY_EXIST(800, "昵称已存在"),
    SELF_CAN_NOT_FOLLOW_SELF(801, "自己不能关注自己"),
    JOIN_ACTIVITY_REPEAT(802, "重复参与"),
    CAN_NOT_REPLY_SELF(803, "不能给自己留言"),
    OVER_LIMIT_MESSAGE_COUNT(804, "留言条数已到达10条,请预约详聊."),

    SCHEDULE_JOB_RUN_ERROR(800, "执行定时任务失败"),
    SCHEDULE_JOB_CRON_ERROR(801, "获取定时任务CronTrigger出现异常"),
    SCHEDULE_JOB_CREATE_ERROR(802, "创建定时任务失败"),
    SCHEDULE_JOB_UPDATE_ERROR(803, "更新定时任务失败"),
    SCHEDULE_JOB_RUN_NOW_ERROR(804, "立即执行定时任务失败"),
    SCHEDULE_JOB_PAUSE_ERROR(805, "暂停定时任务失败"),
    SCHEDULE_JOB_RESUME_ERROR(806, "恢复定时任务失败"),
    SCHEDULE_JOB_DELETE_ERROR(807, "删除定时任务失败"),

    UPLOAD_ERROR(900, "上传文件失败"),
    UPLOAD_ERROR_CHECK_CONFIG(901, "上传文件失败，请检查配置信息"),
    UPLOAD_ERROR_CHECK_QI_NIU(902, "上传文件失败，请核对七牛配置信息"),
    UPLOAD_FILE_NOT_NULL(903, "上传文件不能为空"),
    CHOOSE_FILE(904, "请选择文件"),
    UPLOAD_DIR_NOT_EXIST(905, "上传目录不存在"),
    UPLOAD_DIR_ERROR(906, "文件类型错误"),
    UPLOAD_FILE_SIZE_LIMIT(907, "上传文件大小超过限制"),
    UNSUPPORTED_IMAGE_TYPE(908, "不支持的图片格式"),

    /* token */
    AUTH_TOKEN_INVALID(1000, "token失效，请重新登录"),
    AUTH_TOKEN_NULL(1001, "token不能为空"),
    TOKEN_IS_NULL(1002, "您尚未登录,请登录后在操作"),
    TOKEN_USERNAME_IS_NOT_EXIT(1003, "访问令牌异常或访问令牌已过期,请重新登录"),

    NEWS_ID_NOT_EXIST(2000, "新闻ID不能为空"),
    UNPASS_CORPORATION_CANT_SUBMIT(2001, "该社团未审核通过，不能发布"),
    UNPASS_CORPORATION_CANT_MODIFY(2002, "该社团未审核通过，不能修改"),
    UNPASS_CORPORATION_CANT_DELETE(2003, "该社团未审核通过，不能删除"),
    CORPORATION_NOT_EXIST(2004, "社团不存在"),

    APPOINTMENT_CANT_CHECKE_YOURSELF(3000, "您不能预约自己"),
    APPOINTMENT_CANT_REPEAT_SET(3001, "预约设置已经存在"),
    APPOINTMENT_BE_CHECKED(3002, "该时间段已经被预约啦"),
    APPOINTMENT_OVER_THREE_TIME(3003, "本周已经预约两次,不允许预约"),
    APPOINTMENT_TIME_CONFLICT(3004, "时间存在冲突"),
    APPOINTMENT_ACCOUNT_NOT_EXPERT(3005, "该账号不是咨询师账号，不能预约"),
    APPOINTMENT_THE_SAME_EXPERT_NOT_FINISH(3006, "同一个咨询师上次预约未完成,不允许预约！"),
    APOOINTMENT_EXPERT_NOT_BIND_MENTAL_ROOM(3007, "专家未绑定心防室，不允许预约"),

    HALL_IS_EXIST(4000,"场馆不存在,操作无效"),
    HALL_IS_MODIFY(4001,"该场馆状态已变更,暂时无法操作该服务"),
    HALL_ISNOT_ADMIN(4002,"您已不是该场馆管理员,操作无效"),
    STORE_IS_EXIST(4003,"该店铺已不存在,操作无效"),
    STORE_IS_POSITION(4004,"您的身份已变更,操作无效"),
    HALL_SERVE_IS_EXIST(4005,"场馆服务已删除,操作无效"),
    GOODS_IS_EXIST(4006,"该商品不存在,操作无效"),
    HALL_IS_NOT_OPEN(4007,"场馆已停业,操作无效"),
    COACHING_SERVICE_IS_NOT_EXIST(4008,"该教练服务不存在，操作无效"),


    FINAL_ERROR(999999999, "终极错误");

    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
