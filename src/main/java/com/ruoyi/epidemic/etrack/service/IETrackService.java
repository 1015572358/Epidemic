package com.ruoyi.epidemic.etrack.service;


import com.ruoyi.epidemic.etrack.domain.ETrack;
import com.ruoyi.epidemic.etrack.domain.ETrackPlModel;

import java.util.List;
import java.util.Map;

/**
 * 轨迹Service接口
 * 
 * @author yuancc
 * @date 2022-08-10
 */
public interface IETrackService 
{
    /**
     * 查询轨迹
     * 
     * @param id 轨迹主键
     * @return 轨迹
     */
    public ETrack selectETrackById(Long id);

    /**
     * 查询轨迹列表
     * 
     * @param eTrack 轨迹
     * @return 轨迹集合
     */
    public List<ETrack> selectETrackList(ETrack eTrack);

    /**
     * 新增轨迹
     * 
     * @param eTrack 轨迹
     * @return 结果
     */
    public int insertETrack(ETrack eTrack);

    /**
     * 修改轨迹
     * 
     * @param eTrack 轨迹
     * @return 结果
     */
    public int updateETrack(ETrack eTrack);

    /**
     * 批量删除轨迹
     * 
     * @param ids 需要删除的轨迹主键集合
     * @return 结果
     */
    public int deleteETrackByIds(String ids);

    /**
     * 删除轨迹信息
     * 
     * @param id 轨迹主键
     * @return 结果
     */
    public int deleteETrackById(Long id);

    int insertOrupdatePl(ETrackPlModel eTrackPlModel);

    Map<String, Object> getBMapView(String namekey);
}
