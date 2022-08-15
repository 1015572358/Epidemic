package com.ruoyi.epidemic.keypalce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 重点场所对象 e_keyplace
 *
 * @author yuancc
 * @date 2022-08-11
 */
public class EKeyplace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 重点场所 */
    @Excel(name = "重点场所")
    private String keyPlace;

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
    public void setKeyPlace(String keyPlace)
    {
        this.keyPlace = keyPlace;
    }

    public String getKeyPlace()
    {
        return keyPlace;
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
                .append("keyPlace", getKeyPlace())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("bz", getBz())
                .toString();
    }
}
