package com.gaoce.whatever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* 
*
* @author msgao
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("t_range_config")
    public class RangeConfig implements Serializable {

private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 值域名
     */
    @TableField("NAME")
    private String name;

    /**
     * 等级
     */
    @TableField("GRADE")
    private String grade;

//    /**
//     * 比较符
//     */
//    @TableField("COMPARISON")
//    private String comparison;

    /**
     * 单位
     */
    @TableField("COMPANY")
    private String company;

//    /**
//     * 告警阈值
//     */
//    @TableField("WRANGE")
//    private Double wrange;

    /**
     * 阈值最小值
     */
    @TableField("MINV")
    private Double minv;

    /**
     * 阈值最大值
     */
    @TableField("MAXV")
    private Double maxv;

    /**
     * 告警类型
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField("EDITOR")
    private Long editor;

    /**
     * 修改时间
     */
    @TableField("EDITTIME")
    private Date edittime;

    /**
     * 修改人名
     */
    @TableField("EDITORNAME")
    private String editorname;


}
