package com.gaoce.whatever.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaochengrui
 * @since 2020-07-31
 */
@TableName("t_device_host_port")
@Data
public class DeviceHostPort  implements Serializable  {

    private static final long serialVersionUID = 12435434L;

    /**
     * 设备表ID
     */
	@TableField("HOST_ID")
	private Long hostId;
    /**
     * COLLATE 
     */
	@TableField("PORT_ID")
	private Long portId;






}
