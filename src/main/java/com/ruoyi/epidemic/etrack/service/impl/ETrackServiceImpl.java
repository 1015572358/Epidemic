package com.ruoyi.epidemic.etrack.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.epidemic.eperson.mapper.EPersonMapper;
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
    @Autowired
    private EPersonMapper ePersonMapper;

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
           return eTrackMapper.insertOrupdatePl(eTrackPlModel.getEtrack(),eTrackPlModel.getId(),eTrackPlModel.getSfzh());
        } else {
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

    @Override
    public void delTrackByIds(Long[] ids) {
        eTrackMapper.delTrackByIds(ids);
    }

    @Override
    public String importTracks(List<ETrack> tracksList) {
        //数据直接追加
        if (StringUtils.isNull(tracksList) || tracksList.size() == 0)
        {
            throw new ServiceException("导入轨迹数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ETrack eTrack : tracksList) {
            try {
                //身份证和姓名确定唯一数据，否则直接提示异常
                if(StringUtils.isEmpty(eTrack.geteName()) || StringUtils.isEmpty(eTrack.getSfzh())){
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、轨迹数据： '" + eTrack.geteName() + "||" + eTrack.getSfzh() +"' 无法获取姓名或者身份证号码");
                } else {
                    //匹配追加入库
                    Long eid = ePersonMapper.getEIdByNameAndSfzh(eTrack.geteName(), eTrack.getSfzh());
                    if(eid != null){
                        eTrack.seteId(eid);
                        eTrackMapper.insertETrack(eTrack);
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、轨迹数据： '" + eTrack.geteName() + "||" + eTrack.getSfzh() +"'未在病例中找到相关人员数据");
                    }
                }

            }catch (Exception e){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、轨迹数据： '" + eTrack.geteName() + "||" + eTrack.getSfzh() +"'导入异常");
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
