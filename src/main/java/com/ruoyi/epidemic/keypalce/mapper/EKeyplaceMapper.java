package com.ruoyi.epidemic.keypalce.mapper;


import com.ruoyi.epidemic.keypalce.domain.EKeyplace;

import java.util.List;

/**
 * 重点场所Mapper接口
 * 
 * @author yuancc
 * @date 2022-08-11
 */
public interface EKeyplaceMapper 
{
    /**
     * 查询重点场所
     * 
     * @param id 重点场所主键
     * @return 重点场所
     */
    public EKeyplace selectEKeyplaceById(Long id);

    /**
     * 查询重点场所列表
     * 
     * @param eKeyplace 重点场所
     * @return 重点场所集合
     */
    public List<EKeyplace> selectEKeyplaceList(EKeyplace eKeyplace);

    /**
     * 新增重点场所
     * 
     * @param eKeyplace 重点场所
     * @return 结果
     */
    public int insertEKeyplace(EKeyplace eKeyplace);

    /**
     * 修改重点场所
     * 
     * @param eKeyplace 重点场所
     * @return 结果
     */
    public int updateEKeyplace(EKeyplace eKeyplace);

    /**
     * 删除重点场所
     * 
     * @param id 重点场所主键
     * @return 结果
     */
    public int deleteEKeyplaceById(Long id);

    /**
     * 批量删除重点场所
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEKeyplaceByIds(String[] ids);
}
