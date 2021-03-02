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
    @TableName("t_warning")
    public class Warning implements Serializable {

private static final long serialVersionUID = 1L;

            /**
            * ID
            */
            @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

            /**
            * 设备IP
            */
        @TableField("IP")
    private String ip;

            /**
            * 名字
            */
        @TableField("NAME")
    private String name;



    /**
     * 告警类型0=设备，1=端口
     */
    @TableField("EQUIPMENT")
    private Integer equipment;

    /**
     * 告警级别
     */
    @TableField("LEVEL")
    private Integer level;

    /**
     * 告警类型：流量告警
     */
    @TableField("TYPE")
    private String type;

    /**
     * 告警状态0=已处理，1=未处理
     */
    @TableField("STATE")
    private Integer state;


            /**
            * 告警原因
            */
        @TableField("REASON")
    private String reason;

            /**
            * 创建时间
            */
        @TableField("CREATETIME")
    private Date createTime;


    /**
     * 修改人id
     */
    @TableField("EDITOR")
    private Long editor;


    /**
     * 修改人
     */
    @TableField("EDITORNAME")
    private String editorname;


    /**
     * 修改时间
     */
    @TableField("EDITTIME")
    private Date edittime;

    /**
     * 上报id
     */
    @TableField("PUSHID")
    private String pushid;

    private transient String createTimeFrom;
    private transient String createTimeTo;
}
