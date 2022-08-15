package com.ruoyi.epidemic.etrack.service.impl;

import com.ruoyi.epidemic.etrack.domain.ETrack;
import com.ruoyi.epidemic.etrack.domain.ETrackPlModel;
import com.ruoyi.epidemic.etrack.mapper.ETrackMapper;
import com.ruoyi.epidemic.etrack.service.IETrackService;
import com.ruoyi.epidemic.map.BMapTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 轨迹Service业务层处理
 * 
 * @author yuancc
 * @date 2022-08-10
 */
@Service
public class ETrackServiceImpl implements IETrackService
{
    @Autowired
    private ETrackMapper eTrackMapper;

    /**
     * 查询轨迹
     * 
     * @param id 轨迹主键
     * @return 轨迹
     */
    @Override
    public ETrack selectETrackById(Long id)
    {
        return eTrackMapper.selectETrackById(id);
    }

    /**
     * 查询轨迹列表
     * 
     * @param eTrack 轨迹
     * @return 轨迹
     */
    @Override
    public List<ETrack> selectETrackList(ETrack eTrack)
    {
        return eTrackMapper.selectETrackList(eTrack);
    }

    /**
     * 新增轨迹
     * 
     * @param eTrack 轨迹
     * @return 结果
     */
    @Override
    public int insertETrack(ETrack eTrack)
    {
        return eTrackMapper.insertETrack(eTrack);
    }

    /**
     * 修改轨迹
     * 
     * @param eTrack 轨迹
     * @return 结果
     */
    @Override
    public int updateETrack(ETrack eTrack)
    {
        return eTrackMapper.updateETrack(eTrack);
    }

    /**
     * 批量删除轨迹
     * 
     * @param ids 需要删除的轨迹主键
     * @return 结果
     */
    @Override
    public int deleteETrackByIds(String ids)
    {
        return eTrackMapper.deleteETrackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除轨迹信息
     * 
     * @param id 轨迹主键
     * @return 结果
     */
    @Override
    public int deleteETrackById(Long id)
    {
        return eTrackMapper.deleteETrackById(id);
    }

    @Override
    public int insertOrupdatePl(ETrackPlModel eTrackPlModel) {
        if(eTrackPlModel != null && eTrackPlModel.getEtrack() != null && eTrackPlModel.getEtrack().size()>0 ){
            //操作删除的数据
            if(eTrackPlModel.getIdArr().length > 0){
                //部分删除
                eTrackMapper.deleteETrackByNotInIdArr(eTrackPlModel.getIdArr());
            }else{
                //全部删除
                eTrackMapper.deleteETrackBysfzh(eTrackPlModel.getSfzh());
            }
           return eTrackMapper.insertOrupdatePl(eTrackPlModel.getEtrack(),eTrackPlModel.getId(),eTrackPlModel.getSfzh());
        } else {
            //全部删除
            eTrackMapper.deleteETrackBysfzh(eTrackPlModel.getSfzh());
            return 1;
        }
    }

    /**
     * 时间：2022年8月12日
     * 获取地图轨迹相关数据
     * @return
     */
    @Override
    public Map<String, Object> getBMapView(String namekey) {
        List<BMapTrack> list = eTrackMapper.getBMapTrack(namekey);
        list.stream().map(item->{
            item.setTrackCount(item.geteTracks().size());
            return item;
        }).collect(Collectors.toList());
        Map<String, Object> result = new HashMap<>();
        result.put("data",list);
        return result;
    }
}
