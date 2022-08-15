package com.ruoyi.epidemic.eperson.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 阳性人员对象 e_person
 * 
 * @author yuancc
 * @date 2022-08-04
 */
public class EPerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 疫情编号 */
    @Excel(name = "疫情编号")
    private String eNo;

    /** 代次序号 */
    @Excel(name = "代次序号")
    private Long eXh;

    /** 姓名 */
    @Excel(name = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    /** 性别 */
    @NotNull(message = "性别不能为空！")
    @Excel(name = "性别",readConverterExp = "0=男,1=女,2=未知")
    private String gender;

    /** 身份证号 */
    @NotBlank(message = "身份证号不能为空！")
    @Excel(name = "身份证号")
    private String sfzh;

    /** 年龄 */
    @NotNull(message = "年龄不能为空！")
    @Excel(name = "年龄")
    private Long age;

    /** 是否确诊 */
    @Excel(name = "是否确诊",readConverterExp = "0=否,1=是,2=无症状")
    private String confirmd;

    /** 户籍地 */
    @Excel(name = "户籍地")
    private String domicile;

    /** 现住址 */
    @Excel(name = "现住址")
    private String address;

    /** 所在社区 */
    @Excel(name = "所在社区")
    private String community;

    /** 网格 */
    @Excel(name = "网格分布")
    private String reseau;

    /** 病历来源 */
    @Excel(name = "病例来源（发现方式）")
    private String casesSource;

    /** 职业 */
    @Excel(name = "职业")
    private String profession;

    /** 职业（副） */
    @Excel(name = "职业(副)")
    private String profession2;

    /** 报告卡时间 */
    @Excel(name = "报卡日期（报告卡）")
    private Date reportTime;

    /** 诊断时间（报告卡） */
    @Excel(name = "诊断时间（报告卡）")
    private Date reportDiagnosticTime;

    /** 所在社区管控情况 */
    @Excel(name = "所在社区管控情况")
    private String controlSituation;

    /** 初筛阳性报告时间 */
    @Excel(name = "初筛阳性报告时间（日）")
    private Date firstPositiveReportTime;

    /** 关联病历 */
    @Excel(name = "关联病历")
    private String relatedCases;

    /** 疫苗接种 */
    @Excel(name = "疫苗接种")
    private String vaccination;

    /** 初筛阳性采样时间 */
    @Excel(name = "初筛阳采样时间")
    private Date firstPositiveSampleTime;

    /** 初筛阳性采样地点 */
    @Excel(name = "初筛阳采样地点")
    private String firstPositiveSamplePlace;

    /** 是否隔离 */
    @Excel(name = "是否隔离",readConverterExp = "1=是,0=否")
    private String quarantine;

    /** 隔离点 */
    @Excel(name = "隔离点")
    private String quarantinePlace;

    /** 房间 */
    @Excel(name = "房间")
    private String roomNo;

    /** 隔离时间 */
    @Excel(name = "隔离时间")
    private Date quarantineTime;

    /** 是否同住 */
    @Excel(name = "是否同住")
    private String staywith;

    /** 初筛阳性时间 */
    @Excel(name = "初筛阳性时间")
    private Date firstPositiveTime;

    /** 初阳检测单位 */
    @Excel(name = "初阳检测单位")
    private String firstTestUnit;

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

    public String getENo() {
        return eNo;
    }

    public void setENo(String eNo) {
        this.eNo = eNo;
    }

    public Long getEXh() {
        return eXh;
    }

    public void setEXh(Long eXh) {
        this.eXh = eXh;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setConfirmd(String confirmd)
    {
        this.confirmd = confirmd;
    }

    public String getConfirmd()
    {
        return confirmd;
    }
    public void setDomicile(String domicile)
    {
        this.domicile = domicile;
    }

    public String getDomicile()
    {
        return domicile;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setCommunity(String community)
    {
        this.community = community;
    }

    public String getCommunity()
    {
        return community;
    }
    public void setReseau(String reseau)
    {
        this.reseau = reseau;
    }

    public String getReseau()
    {
        return reseau;
    }
    public void setCasesSource(String casesSource)
    {
        this.casesSource = casesSource;
    }

    public String getCasesSource()
    {
        return casesSource;
    }
    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public String getProfession()
    {
        return profession;
    }
    public void setProfession2(String profession2)
    {
        this.profession2 = profession2;
    }

    public String getProfession2()
    {
        return profession2;
    }
    public void setReportTime(Date reportTime)
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime()
    {
        return reportTime;
    }
    public void setReportDiagnosticTime(Date reportDiagnosticTime)
    {
        this.reportDiagnosticTime = reportDiagnosticTime;
    }

    public Date getReportDiagnosticTime()
    {
        return reportDiagnosticTime;
    }
    public void setControlSituation(String controlSituation)
    {
        this.controlSituation = controlSituation;
    }

    public String getControlSituation()
    {
        return controlSituation;
    }
    public void setFirstPositiveReportTime(Date firstPositiveReportTime)
    {
        this.firstPositiveReportTime = firstPositiveReportTime;
    }

    public Date getFirstPositiveReportTime()
    {
        return firstPositiveReportTime;
    }
    public void setRelatedCases(String relatedCases)
    {
        this.relatedCases = relatedCases;
    }

    public String getRelatedCases()
    {
        return relatedCases;
    }
    public void setVaccination(String vaccination)
    {
        this.vaccination = vaccination;
    }

    public String getVaccination()
    {
        return vaccination;
    }
    public void setFirstPositiveSampleTime(Date firstPositiveSampleTime)
    {
        this.firstPositiveSampleTime = firstPositiveSampleTime;
    }

    public Date getFirstPositiveSampleTime()
    {
        return firstPositiveSampleTime;
    }
    public void setFirstPositiveSamplePlace(String firstPositiveSamplePlace)
    {
        this.firstPositiveSamplePlace = firstPositiveSamplePlace;
    }

    public String getFirstPositiveSamplePlace()
    {
        return firstPositiveSamplePlace;
    }
    public void setQuarantine(String quarantine)
    {
        this.quarantine = quarantine;
    }

    public String getQuarantine()
    {
        return quarantine;
    }
    public void setQuarantinePlace(String quarantinePlace)
    {
        this.quarantinePlace = quarantinePlace;
    }

    public String getQuarantinePlace()
    {
        return quarantinePlace;
    }
    public void setRoomNo(String roomNo)
    {
        this.roomNo = roomNo;
    }

    public String getRoomNo()
    {
        return roomNo;
    }
    public void setQuarantineTime(Date quarantineTime)
    {
        this.quarantineTime = quarantineTime;
    }

    public Date getQuarantineTime()
    {
        return quarantineTime;
    }
    public void setStaywith(String staywith)
    {
        this.staywith = staywith;
    }

    public String getStaywith()
    {
        return staywith;
    }
    public void setFirstPositiveTime(Date firstPositiveTime)
    {
        this.firstPositiveTime = firstPositiveTime;
    }

    public Date getFirstPositiveTime()
    {
        return firstPositiveTime;
    }
    public void setFirstTestUnit(String firstTestUnit)
    {
        this.firstTestUnit = firstTestUnit;
    }

    public String getFirstTestUnit()
    {
        return firstTestUnit;
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

    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    public Long geteXh() {
        return eXh;
    }

    public void seteXh(Long eXh) {
        this.eXh = eXh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("eNo", getENo())
                .append("eXh", getEXh())
                .append("name", getName())
                .append("sfzh", getSfzh())
                .append("gender", getGender())
                .append("age", getAge())
                .append("confirmd", getConfirmd())
                .append("domicile", getDomicile())
                .append("address", getAddress())
                .append("community", getCommunity())
                .append("reseau", getReseau())
                .append("casesSource", getCasesSource())
                .append("profession", getProfession())
                .append("profession2", getProfession2())
                .append("reportTime", getReportTime())
                .append("reportDiagnosticTime", getReportDiagnosticTime())
                .append("controlSituation", getControlSituation())
                .append("firstPositiveReportTime", getFirstPositiveReportTime())
                .append("relatedCases", getRelatedCases())
                .append("vaccination", getVaccination())
                .append("firstPositiveSampleTime", getFirstPositiveSampleTime())
                .append("firstPositiveSamplePlace", getFirstPositiveSamplePlace())
                .append("quarantine", getQuarantine())
                .append("quarantinePlace", getQuarantinePlace())
                .append("roomNo", getRoomNo())
                .append("quarantineTime", getQuarantineTime())
                .append("staywith", getStaywith())
                .append("firstPositiveTime", getFirstPositiveTime())
                .append("firstTestUnit", getFirstTestUnit())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .toString();
    }
}
