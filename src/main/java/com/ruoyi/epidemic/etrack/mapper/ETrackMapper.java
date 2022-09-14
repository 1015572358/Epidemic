package com.ruoyi.epidemic.etrack.mapper;


import com.ruoyi.epidemic.etrack.domain.ETrack;
import com.ruoyi.epidemic.etrack.domain.ETrackPlModel;
import com.ruoyi.epidemic.map.BMapTrack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轨迹Mapper接口
 * 
 * @author yuancc
 * @date 2022-08-10
 */
public interface ETrackMapper 
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
     * 删除轨迹
     * 
     * @param id 轨迹主键
     * @return 结果
     */
    public int deleteETrackById(Long id);

    /**
     * 批量删除轨迹
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteETrackByIds(String[] ids);

    int insertOrupdatePl(@Param("list") List<ETrack> list,@Param("eid") Long eid,@Param("sfzh") String sfzh);

    void deleteETrackBysfzh(String sfzh);

    void deleteETrackByNotInIdArr(@Param("idArr") Long[] idArr,@Param("ryId") Long ryId);

    List<BMapTrack> getBMapTrack(@Param("name") String namekey);

    void delTrackByIds(Long[] ids);

}
