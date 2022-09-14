package com.ruoyi.epidemic.contiguity.service;

import java.util.List;
import com.ruoyi.epidemic.contiguity.domain.EContiguity;

/**
 * 密接者Service接口
 * 
 * @author yuancc
 * @date 2022-08-19
 */
public interface IEContiguityService 
{
    /**
     * 查询密接者
     * 
     * @param id 密接者主键
     * @return 密接者
     */
    public EContiguity selectEContiguityById(Long id);

    /**
     * 查询密接者列表
     * 
     * @param eContiguity 密接者
     * @return 密接者集合
     */
    public List<EContiguity> selectEContiguityList(EContiguity eContiguity);

    /**
     * 新增密接者
     * 
     * @param eContiguity 密接者
     * @return 结果
     */
    public int insertEContiguity(EContiguity eContiguity);

    /**
     * 修改密接者
     * 
     * @param eContiguity 密接者
     * @return 结果
     */
    public int updateEContiguity(EContiguity eContiguity);

    /**
     * 批量删除密接者
     * 
     * @param ids 需要删除的密接者主键集合
     * @return 结果
     */
    public int deleteEContiguityByIds(String ids);

    /**
     * 删除密接者信息
     * 
     * @param id 密接者主键
     * @return 结果
     */
    public int deleteEContiguityById(Long id);

    String importConti(List<EContiguity> contiList);
}
