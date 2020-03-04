package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sys.SysUserEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻资讯
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@TableName("tb_news")
public class NewsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(hidden = true)
    private Integer id;
    /**
     * 新闻标题
     */
    private String newsTitle;
    /**
     * 新闻内容
     */
    private String newsContent;
    /**
     * 摘要
     */
    private String newsSummary;
    /**
     * 摘要图片
     */
    private String newsSummaryImage;
    /**
     * 新闻导航图片
     */
    private String newsNavImage;
    /**
     * 附件
     */
    private String newsAttach;
    /**
     * 新闻标签
     */
    @ApiModelProperty(hidden = true)
    private String newsTags;
    /**
     * 作者标识
     */
    @ApiModelProperty(hidden = true)
    private Long newsAuthor;

    /**
     * 作者（管理员）
     */
    @TableField(exist = false)
    private SysUserEntity authorSysUser;

    /**
     * 作者（用户）
     */
    @TableField(exist = false)
    private UserEntity authorFrontUser;

    /**
     * 作者类别（1-管理员，2-专家，3-咨询师）
     */
    @ApiModelProperty(hidden = true)
    private Integer authorType;
    /**
     * 新闻栏目
     */
    private Integer newsColumn;
    /**
     * 点击数
     */
    @ApiModelProperty(hidden = true)
    private Integer pageView;
    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date newsCreateTime;
    /**
     * 审核人
     */
    @ApiModelProperty(hidden = true)
    private Long newsAuditor;
    /**
     * 审核时间
     */
    @ApiModelProperty(hidden = true)
    private Date newsAuditTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(hidden = true)
    private Date newsUpdateTime;
    /**
     * 修改人
     */
    @ApiModelProperty(hidden = true)
    private Long newsUpdator;

    /**
     * 新闻状态(1-审核中,2-审核通过，3-删除)
     */
    @ApiModelProperty(hidden = true)
    private Integer newsStatus;
    /**
     * 是否放置宣传栏
     */
    private Integer isRecommend;
    /**
     * 审核不通过原因
     */
    private String remark;

    /**
     * 社团标识
     */
    private Integer corporationId;

    /**
     * 点赞数
     */
    @TableField(exist = false)
    private Integer greats;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：新闻标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 获取：新闻标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 设置：新闻内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    /**
     * 获取：新闻内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 设置：摘要
     */
    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }

    /**
     * 获取：摘要
     */
    public String getNewsSummary() {
        return newsSummary;
    }

    /**
     * 设置：新闻导航图片
     */
    public void setNewsNavImage(String newsNavImage) {
        this.newsNavImage = newsNavImage;
    }

    /**
     * 获取：新闻导航图片
     */
    public String getNewsNavImage() {
        return newsNavImage;
    }

    public String getNewsAttach() {
        return newsAttach;
    }

    public void setNewsAttach(String newsAttach) {
        this.newsAttach = newsAttach;
    }

    /**
     * 设置：新闻标签
     */
    public void setNewsTags(String newsTags) {
        this.newsTags = newsTags;
    }

    /**
     * 获取：新闻标签
     */
    public String getNewsTags() {
        return newsTags;
    }

    /**
     * 设置：作者
     */
    public void setNewsAuthor(Long newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    /**
     * 获取：作者
     */
    public Long getNewsAuthor() {
        return newsAuthor;
    }

    /**
     * 设置：作者类别（1-管理员，2-专家，3-咨询师）
     */
    public void setAuthorType(Integer authorType) {
        this.authorType = authorType;
    }

    /**
     * 获取：作者类别（1-管理员，2-专家，3-咨询师）
     */
    public Integer getAuthorType() {
        return authorType;
    }

    /**
     * 设置：新闻栏目
     */
    public void setNewsColumn(Integer newsColumn) {
        this.newsColumn = newsColumn;
    }

    /**
     * 获取：新闻栏目
     */
    public Integer getNewsColumn() {
        return newsColumn;
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
    public void setNewsCreateTime(Date newsCreateTime) {
        this.newsCreateTime = newsCreateTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getNewsCreateTime() {
        return newsCreateTime;
    }

    /**
     * 设置：审核人
     */
    public void setNewsAuditor(Long newsAuditor) {
        this.newsAuditor = newsAuditor;
    }

    /**
     * 获取：审核人
     */
    public Long getNewsAuditor() {
        return newsAuditor;
    }

    /**
     * 设置：审核时间
     */
    public void setNewsAuditTime(Date newsAuditTime) {
        this.newsAuditTime = newsAuditTime;
    }

    /**
     * 获取：审核时间
     */
    public Date getNewsAuditTime() {
        return newsAuditTime;
    }

    /**
     * 设置：修改时间
     */
    public void setNewsUpdateTime(Date newsUpdateTime) {
        this.newsUpdateTime = newsUpdateTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getNewsUpdateTime() {
        return newsUpdateTime;
    }

    /**
     * 设置：修改人
     */
    public void setNewsUpdator(Long newsUpdator) {
        this.newsUpdator = newsUpdator;
    }

    /**
     * 获取：修改人
     */
    public Long getNewsUpdator() {
        return newsUpdator;
    }

    /**
     * 设置：新闻状态(1-审核中,2-审核通过，3-删除)
     */
    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    /**
     * 获取：新闻状态(1-审核中,2-审核通过，3-删除)
     */
    public Integer getNewsStatus() {
        return newsStatus;
    }

    /**
     * 设置：是否放置宣传栏
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取：是否放置宣传栏
     */
    public Integer getIsRecommend() {
        return isRecommend;
    }

    /**
     * 设置：审核不通过原因
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：审核不通过原因
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 获取：摘要图片
     */
    public String getNewsSummaryImage() {
        return newsSummaryImage;
    }

    /**
     * 设置：摘要图片
     */
    public void setNewsSummaryImage(String newsSummaryImage) {
        this.newsSummaryImage = newsSummaryImage;
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

    /**
     * 获取：作者（管理员）
     */
    public SysUserEntity getAuthorSysUser() {
        return authorSysUser;
    }

    /**
     * 设置：作者（管理员）
     */
    public void setAuthorSysUser(SysUserEntity authorSysUser) {
        this.authorSysUser = authorSysUser;
    }

    /**
     * 获取：作者（用户）
     */
    public UserEntity getAuthorFrontUser() {
        return authorFrontUser;
    }

    /**
     * 设置：作者（用户）
     */
    public void setAuthorFrontUser(UserEntity authorFrontUser) {
        this.authorFrontUser = authorFrontUser;
    }

    /**
     * 获取：社团标识
     */
    public Integer getCorporationId() {
        return corporationId;
    }

    /**
     * 设置：社团标识
     */
    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }
}
