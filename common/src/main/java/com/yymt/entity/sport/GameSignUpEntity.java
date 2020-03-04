package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 赛事培训报名表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_game_sign_up")
@ApiModel(description = "赛事培训报名表")
public class GameSignUpEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 赛事培训id
     */
    @ApiModelProperty(value = "赛事培训id")
    private Integer gameId;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;


    @ApiModelProperty(value = "报名时间")
    private Date signUpTime;

    /**
     * 赛事培训
     */
    @TableField(exist = false)
    private GamesEntity game;

    public Date getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    /**
     * 设置：赛事培训id
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    /**
     * 获取：赛事培训id
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     * 设置：用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 获取：赛事培训
     */
    public GamesEntity getGame() {
        return game;
    }

    /**
     * 设置：赛事培训
     */
    public void setGame(GamesEntity game) {
        this.game = game;
    }
}
