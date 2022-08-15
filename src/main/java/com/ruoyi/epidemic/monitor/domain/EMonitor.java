package com.ruoyi.epidemic.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 监测点对象 e_monitor
 *
 * @author yuancc
 * @date 2022-08-12
 */
public class EMonitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 监测点 */
    @Excel(name = "监测点")
    private String monitorPlace;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 备注 */
    @Excel(name = "备注")
    private String bz;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMonitorPlace(String monitorPlace)
    {
        this.monitorPlace = monitorPlace;
    }

    public String getMonitorPlace()
    {
        return monitorPlace;
    }
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return longitude;
    }
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("monitorPlace", getMonitorPlace())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("bz", getBz())
                .toString();
    }
}
