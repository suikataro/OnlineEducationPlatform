package com.learning.edu.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author felix
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PromotionAd implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告名
     */
    private String name;

    /**
     * 广告位id
     */
    @TableField("spaceId")
    private Integer spaceId;

    /**
     * 精确搜索关键词
     */
    private String keyword;

    /**
     * 静态广告的内容
     */
    @TableField("htmlContent")
    private String htmlContent;

    /**
     * 文字
     */
    private String text;

    /**
     * 链接
     */
    private String link;

    /**
     * 开始时间
     */
    @TableField("startTime")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("endTime")
    private Date endTime;

    @TableField("createTime")
    private Date createTime;

    @TableField("updateTime")
    private Date updateTime;

    private Integer status;

    /**
     * 优先级
     */
    private Integer priority;

    private String img;


}
