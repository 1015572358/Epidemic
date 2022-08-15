package com.ruoyi.epidemic.map;

import com.ruoyi.epidemic.etrack.domain.ETrack;
import java.util.List;

public class BMapTrack {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;


    /** 姓名 */
    private String name;

    /** 性别 */
    private String gender;

    /** 身份证号 */
    private String sfzh;

    /** 年龄 */
    private Long age;

    /** 所在社区 */
    private String community;

    private List<ETrack> eTracks;

    private Integer trackCount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
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
    public void setCommunity(String community)
    {
        this.community = community;
    }

    public String getCommunity()
    {
        return community;
    }

    public List<ETrack> geteTracks() {
        return eTracks;
    }

    public void seteTracks(List<ETrack> eTracks) {
        this.eTracks = eTracks;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }
}
