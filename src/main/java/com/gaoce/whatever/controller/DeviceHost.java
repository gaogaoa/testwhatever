package com.gaoce.whatever.controller;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gaoce.whatever.domain.DevicePort;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author gaochengrui
 * @since 2020-07-31
 */
@TableName("t_device_host")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceHost {

    private static final long serialVersionUID = 1L;

    /**
     * 设备的唯一ID
     */
	@TableId(value="DEVICE_ID", type= IdType.AUTO)
	private Long deviceId;

	/**
	 * 设备主机名
	 */
	@TableField("SYSNAME")

	private String sysname;

	/**
	 * 设备IP
	 */
	@TableField("IP")

	private String ip;
    /**
     * 所属地域
     */
	@TableField("CITY")
	private String city;
    /**
     * snmp团体字
     */
	@TableField("COMMUNITY")
	private String community;
    /**
     * PING延迟.单位：s
     */
	@TableField("DELAY")
	private Float delay;
    /**
     * 设备型号
     */
	@TableField("DEVICE_MODEL")
	private String deviceModel;
    /**
     * 采集服务器节点
     */
	@TableField("DG")
	private String dg;
    /**
     * PING丢包0-1
     */
	@TableField("HOST_DROP")
	private Float hostDrop;
	/**
	 * 所属网络
	 */
	@TableField("NET")

	private String net;
    /**
     * 整机输入速率（5分钟均值）单位：bps
     */
	@TableField("IN_BPS")

	private BigDecimal ibps;
    /**
     * 备注
     */
	@TableField("DESCRIPTION")
	private String description;


    /**
     * 整机输出速率（5分钟均值）.单位：bps
     */
	@TableField("OUT_BPS")

	private BigDecimal obps;
    /**
     * 系统版本
     */
	@TableField("OS_VERSION")
	private String osVersion;
    /**
     * 设备拥有者（负责人）
     */
	@TableField("OWNER")
	private String owner;
    /**
     * SNMP采集丢包
     */
	@TableField("SNMP_DROP")
	private Float snmpdrop;
    /**
     * snmp版本
     */
	@TableField("SNMP_VERSION")
	private Integer snmpver;
    /**
     * 设备状态.32位，0表示正常，每一位含义： 0. 正常； 1. 网络不可达或SNMP团体字异常 2. 网络协议异常 3. 未知的设备 4. 未知的用户 5. SNMP无写权限 6-7. 预留 8. 配置错误 9. 端口DOWN 10. 错包 11. 设备间端口不匹配 12-15.预留 16. 流量出大于入 17. 流量出少于入 18. 流量突变 19-23.预留 24. GTC 25. G-D链路数不匹配
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
     * 设备类型
     */
	@TableField("TYPE")
	private String type;

	/**
	 * 日志存储时间
	 */
	@TableField("LOG_TIME")
	private Date logTime;


	private transient String createTimeFrom;
	private transient String createTimeTo;
	/**
	 *   标记 ：0表示设备
	 */
	private transient String identification;

	private transient List<DevicePort> Children;

	public String getKey() {

		return "host-"+getDeviceId();
	}

	public void setKey(String key) {
		this.key = key;
	}

	private transient String key;

	@Override
	public String toString() {
		return "DeviceHost{" +
				"deviceId=" + deviceId +
				", sysname='" + sysname + '\'' +
				", ip='" + ip + '\'' +
				", city='" + city + '\'' +
				", community='" + community + '\'' +
				", delay=" + delay +
				", deviceModel='" + deviceModel + '\'' +
				", dg='" + dg + '\'' +
				", hostDrop=" + hostDrop +
				", net='" + net + '\'' +
				", ibps=" + ibps +
				", description='" + description + '\'' +
				", obps=" + obps +
				", osVersion='" + osVersion + '\'' +
				", owner='" + owner + '\'' +
				", snmpdrop=" + snmpdrop +
				", snmpver=" + snmpver +
				", state=" + state +
				", createTime=" + createTime +
				", editTime=" + editTime +
				", creator=" + creator +
				", creatorName='" + creatorName + '\'' +
				", editor=" + editor +
				", editorName='" + editorName + '\'' +
				", type='" + type + '\'' +
				", logTime=" + logTime +
				", createTimeFrom='" + createTimeFrom + '\'' +
				", createTimeTo='" + createTimeTo + '\'' +
				", identification='" + identification + '\'' +
				", Children=" + Children +
				", key='" + key + '\'' +
				'}';
	}
}
