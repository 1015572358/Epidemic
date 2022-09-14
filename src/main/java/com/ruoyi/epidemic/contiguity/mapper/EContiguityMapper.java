package com.ruoyi.epidemic.contiguity.mapper;

import java.util.List;
import com.ruoyi.epidemic.contiguity.domain.EContiguity;

/**
 * 密接者Mapper接口
 * 
 * @author yuancc
 * @date 2022-08-19
 */
public interface EContiguityMapper 
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
     * 删除密接者
     * 
     * @param id 密接者主键
     * @return 结果
     */
    public int deleteEContiguityById(Long id);

    /**
     * 批量删除密接者
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEContiguityByIds(String[] ids);
}
