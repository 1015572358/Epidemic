package com.ruoyi.epidemic.monitor.service.impl;

import java.util.List;

import com.ruoyi.epidemic.monitor.domain.EMonitor;
import com.ruoyi.epidemic.monitor.mapper.EMonitorMapper;
import com.ruoyi.epidemic.monitor.service.IEMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 监测点Service业务层处理
 * 
 * @author yuancc
 * @date 2022-08-12
 */
@Service
public class EMonitorServiceImpl implements IEMonitorService
{
    @Autowired
    private EMonitorMapper eMonitorMapper;

    /**
     * 查询监测点
     * 
     * @param id 监测点主键
     * @return 监测点
     */
    @Override
    public EMonitor selectEMonitorById(Long id)
    {
        return eMonitorMapper.selectEMonitorById(id);
    }

    /**
     * 查询监测点列表
     * 
     * @param eMonitor 监测点
     * @return 监测点
     */
    @Override
    public List<EMonitor> selectEMonitorList(EMonitor eMonitor)
    {
        return eMonitorMapper.selectEMonitorList(eMonitor);
    }

    /**
     * 新增监测点
     * 
     * @param eMonitor 监测点
     * @return 结果
     */
    @Override
    public int insertEMonitor(EMonitor eMonitor)
    {
        return eMonitorMapper.insertEMonitor(eMonitor);
    }

    /**
     * 修改监测点
     * 
     * @param eMonitor 监测点
     * @return 结果
     */
    @Override
    public int updateEMonitor(EMonitor eMonitor)
    {
        return eMonitorMapper.updateEMonitor(eMonitor);
    }

    /**
     * 批量删除监测点
     * 
     * @param ids 需要删除的监测点主键
     * @return 结果
     */
    @Override
    public int deleteEMonitorByIds(String ids)
    {
        return eMonitorMapper.deleteEMonitorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除监测点信息
     * 
     * @param id 监测点主键
     * @return 结果
     */
    @Override
    public int deleteEMonitorById(Long id)
    {
        return eMonitorMapper.deleteEMonitorById(id);
    }
}
