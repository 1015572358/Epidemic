package com.ruoyi.epidemic.monitor.service;


import com.ruoyi.epidemic.monitor.domain.EMonitor;

import java.util.List;

/**
 * 监测点Service接口
 * 
 * @author yuancc
 * @date 2022-08-12
 */
public interface IEMonitorService 
{
    /**
     * 查询监测点
     * 
     * @param id 监测点主键
     * @return 监测点
     */
    public EMonitor selectEMonitorById(Long id);

    /**
     * 查询监测点列表
     * 
     * @param eMonitor 监测点
     * @return 监测点集合
     */
    public List<EMonitor> selectEMonitorList(EMonitor eMonitor);

    /**
     * 新增监测点
     * 
     * @param eMonitor 监测点
     * @return 结果
     */
    public int insertEMonitor(EMonitor eMonitor);

    /**
     * 修改监测点
     * 
     * @param eMonitor 监测点
     * @return 结果
     */
    public int updateEMonitor(EMonitor eMonitor);

    /**
     * 批量删除监测点
     * 
     * @param ids 需要删除的监测点主键集合
     * @return 结果
     */
    public int deleteEMonitorByIds(String ids);

    /**
     * 删除监测点信息
     * 
     * @param id 监测点主键
     * @return 结果
     */
    public int deleteEMonitorById(Long id);
}
