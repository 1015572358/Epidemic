package com.ruoyi.epidemic.contiguity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.naming.Name;
import javax.validation.constraints.NotNull;

/**
 * 密接者对象 e_contiguity
 * 
 * @author yuancc
 * @date 2022-08-19
 */
public class EContiguity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 人员主键 */
    private Long eId;

    /** 临时字段 */
    private String e_name;

    /** 姓名 */
    @Excel(name = "姓名")
    @NotNull(message = "姓名不能为空")
    private String name;

    /** 身份证号/护照号 */
    @Excel(name = "身份证号/护照号")
    private String sfzh;

    /** 性别 */
    @Excel(name = "性别",readConverterExp = "0=男,1=女,2=未知",combo = {"男","女"})
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 乡镇 */
    @Excel(name = "乡镇")
    private String town;

    /** 社区 */
    @Excel(name = "社区")
    private String community;

    /** 门牌号 */
    @Excel(name = "门牌号")
    private String apartment;

    /** 网格分布 */
    @Excel(name = "网格分布")
    private String gridDistribution;

    /** 接触地点 */
    @Excel(name = "接触地点及方式")
    private String contactSite;

    /** 接触频率 */
    @Excel(name = "接触频率")
    private String contactFrequency;

    /** 与病例关系 */
    @Excel(name = "与病例关系")
    private String relation;

    /** 是否出现临床症状 */
    @Excel(name = "是否出现临床症状",dictType = "e_yes_no",combo = {"否","是"})
    private String symptom;
    @Excel(name = "备注")
    private String remark;

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSfzh(String sfzh)
    {
        this.sfzh = sfzh;
    }

    public String getSfzh()
    {
        return sfzh;
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
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setTown(String town)
    {
        this.town = town;
    }

    public String getTown()
    {
        return town;
    }
    public void setCommunity(String community)
    {
        this.community = community;
    }

    public String getCommunity()
    {
        return community;
    }
    public void setApartment(String apartment)
    {
        this.apartment = apartment;
    }

    public String getApartment()
    {
        return apartment;
    }
    public void setGridDistribution(String gridDistribution)
    {
        this.gridDistribution = gridDistribution;
    }

    public String getGridDistribution()
    {
        return gridDistribution;
    }
    public void setContactSite(String contactSite)
    {
        this.contactSite = contactSite;
    }

    public String getContactSite()
    {
        return contactSite;
    }
    public void setContactFrequency(String contactFrequency)
    {
        this.contactFrequency = contactFrequency;
    }

    public String getContactFrequency()
    {
        return contactFrequency;
    }
    public void setRelation(String relation)
    {
        this.relation = relation;
    }

    public String getRelation()
    {
        return relation;
    }
    public void setSymptom(String symptom)
    {
        this.symptom = symptom;
    }

    public String getSymptom()
    {
        return symptom;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("eId", geteId())
            .append("name", getName())
            .append("sfzh", getSfzh())
            .append("gender", getGender())
            .append("age", getAge())
            .append("phone", getPhone())
            .append("town", getTown())
            .append("community", getCommunity())
            .append("apartment", getApartment())
            .append("gridDistribution", getGridDistribution())
            .append("contactSite", getContactSite())
            .append("contactFrequency", getContactFrequency())
            .append("relation", getRelation())
            .append("symptom", getSymptom())
            .append("remark", getRemark())
            .toString();
    }
}
