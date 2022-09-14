package com.ruoyi.epidemic.etrack.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 轨迹对象 e_track
 *
 * @author yuancc
 * @date 2022-08-10
 */
public class ETrack extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 人员id */
    private Long eId;

    @Excel(name = "姓名")
    private String eName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String sfzh;

    /** 活动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "活动时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss",prompt = "请按照正确的时间格式，例：’1994-09-18 12:12:12‘")
    private Date activeTime;

    /** 活动地点 */
    @Excel(name = "活动地点")
    private String activePlace;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void seteId(Long eId)
    {
        this.eId = eId;
    }

    public Long geteId()
    {
        return eId;
    }
    public void setSfzh(String sfzh)
    {
        this.sfzh = sfzh;
    }

    public String getSfzh()
    {
        return sfzh;
    }
    public void setActiveTime(Date activeTime)
    {
        this.activeTime = activeTime;
    }

    public Date getActiveTime()
    {
        return activeTime;
    }
    public void setActivePlace(String activePlace)
    {
        this.activePlace = activePlace;
    }

    public String getActivePlace()
    {
        return activePlace;
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

    public String geteName() {
        return eName;
    }

    //导入导出使用
    public String getEName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("eId", geteId())
                .append("eName", geteName())
                .append("sfzh", getSfzh())
                .append("activeTime", getActiveTime())
                .append("activePlace", getActivePlace())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .toString();
    }
}
