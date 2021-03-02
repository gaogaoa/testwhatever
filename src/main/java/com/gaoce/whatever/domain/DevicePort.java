package com.gaoce.whatever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author gaochengrui
 * @since 2020-07-31
 */
@TableName("t_device_port")
@Data
public class DevicePort implements Serializable {

    private static final long serialVersionUID = 1464564645L;

    /**
     * 端口ID
     */
	@TableId(value="DEVICE_ID", type= IdType.AUTO)
	private Long deviceId;
    /**
     * 端口描述
     */
	@TableField("DESCRIPTION")
	private String description;
    /**
     * 端口丢包速率（5分钟均值）单位：pps
     */
	@TableField("DISCARDS")
	private BigDecimal discards;
    /**
     * 端口错包速率（5分钟均值），单位：pps
     */
	@TableField("ERROR_PPS")
	private BigDecimal epps;
    /**
     * 端口输入组/广播包速率（5分钟均值），单位：pps
     */
	@TableField("IN_MPPS")
	private BigDecimal iMpps;
    /**
     * 端口输入单播包速率（5分钟均值），单位：pps
     */
	@TableField("IN_UPPS")
	private BigDecimal iUpps;
    /**
     * 端口输入速率（5分钟均值），单位：bps
     */
	@TableField("IN_BPS")
	private BigDecimal ibps;
    /**
     * 设备IP
     */
	@TableField("IP")
	private String ip;
    /**
     * 所属网络
     */
	@TableField("NET")
	private String net;
    /**
     * 端口输出速率（5分钟均值）.单位：bps
     */
	@TableField("OUT_BPS")
	private BigDecimal obps;
    /**
     * 端口输出组/广播包速率（5分钟均值），单位：pps
     */
	@TableField("OUT_MPPS")
	private BigDecimal oMpps;
    /**
     * 端口输出单播包速率（5分钟均值），单位：pps
     */
	@TableField("OUT_UPPS")
	private BigDecimal oUpps;
    /**
     * 端口名
     */
	@TableField("NAME")
	private String port;
    /**
     * 端口带宽，单位Mbps
     */
	@TableField("SPEED")
	private Integer speed;
    /**
     * 端口状态1=UP，2=DOWN，3=SHUT
     */
	@TableField("STATE")
	private Integer state;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;
    /**
     * 修改时间
     */
	@TableField("EDIT_TIME")
	private Date editTime;
    /**
     * 创建人ID
     */
	@TableField("CREATOR")
	private Long creator;
    /**
     * 创建人
     */
	@TableField("CREATOR_NAME")
	private String creatorName;
    /**
     * 修改人ID
     */
	@TableField("EDITOR")
	private Long editor;
    /**
     * 修改人
     */
	@TableField("EDITOR_NAME")
	private String editorName;


	/**
	 * 日志存储时间
	 */
	@TableField("LOG_TIME")
	private Date logTime;


	private transient String createTimeFrom;
	private transient String createTimeTo;
	private transient Long hostId;
	private transient String sysname;
	private transient String parentId;

	public String getKey() {


		return "port-"+getDeviceId();
	}

	public void setKey(String key) {
		this.key = key;
	}

	private transient String key;
}
