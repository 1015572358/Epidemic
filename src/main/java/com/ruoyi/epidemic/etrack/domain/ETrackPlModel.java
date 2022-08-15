package com.ruoyi.epidemic.etrack.domain;

import java.util.List;

public class ETrackPlModel {
    private Long id;
    private String sfzh;
    private List<ETrack> etrack;
    private Long[] idArr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public List<ETrack> getEtrack() {
        return etrack;
    }

    public void setEtrack(List<ETrack> etrack) {
        this.etrack = etrack;
    }

    public Long[] getIdArr() {
        return idArr;
    }

    public void setIdArr(Long[] idArr) {
        this.idArr = idArr;
    }
}
