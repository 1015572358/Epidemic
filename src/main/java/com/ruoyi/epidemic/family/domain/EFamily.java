package com.ruoyi.epidemic.family.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 同住人员信息对象 e_family
 * 
 * @author yuancc
 * @date 2022-08-17
 */
public class EFamily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 人员表主键 */
    private Long eId;

    /** 关系 */
    @Excel(name = "关系")
    private String relation;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String sfzh;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 职业 */
    @Excel(name = "职业",dictType = "e_profession")
    private String profession;

    /** 现住址 */
    private String address;

    /** 户籍地址 */
    private String domicile;

    /** 疫苗接种情况 */
    private String vaccination;

    /** 核酸检测情况 */
    private String testing;

    /** 管控情况 */
    private String controlSituation;

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
    public void setRelation(String relation)
    {
        this.relation = relation;
    }

    public String getRelation()
    {
        return relation;
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
    public void setSfzh(String sfzh)
    {
        this.sfzh = sfzh;
    }

    public String getSfzh()
    {
        return sfzh;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public String getProfession()
    {
        return profession;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setDomicile(String domicile)
    {
        this.domicile = domicile;
    }

    public String getDomicile()
    {
        return domicile;
    }
    public void setVaccination(String vaccination)
    {
        this.vaccination = vaccination;
    }

    public String getVaccination()
    {
        return vaccination;
    }
    public void setTesting(String testing)
    {
        this.testing = testing;
    }

    public String getTesting()
    {
        return testing;
    }
    public void setControlSituation(String controlSituation)
    {
        this.controlSituation = controlSituation;
    }

    public String getControlSituation()
    {
        return controlSituation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("eId", geteId())
            .append("relation", getRelation())
            .append("name", getName())
            .append("gender", getGender())
            .append("age", getAge())
            .append("sfzh", getSfzh())
            .append("phone", getPhone())
            .append("profession", getProfession())
            .append("address", getAddress())
            .append("domicile", getDomicile())
            .append("vaccination", getVaccination())
            .append("testing", getTesting())
            .append("controlSituation", getControlSituation())
            .toString();
    }
}
