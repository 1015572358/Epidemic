package com.ruoyi.epidemic.family.mapper;

import java.util.List;
import com.ruoyi.epidemic.family.domain.EFamily;
import org.apache.ibatis.annotations.Param;

/**
 * 同住人员信息Mapper接口
 * 
 * @author yuancc
 * @date 2022-08-17
 */
public interface EFamilyMapper 
{
    /**
     * 查询同住人员信息
     * 
     * @param id 同住人员信息主键
     * @return 同住人员信息
     */
    public EFamily selectEFamilyById(Long id);

    /**
     * 查询同住人员信息列表
     * 
     * @param eFamily 同住人员信息
     * @return 同住人员信息集合
     */
    public List<EFamily> selectEFamilyList(EFamily eFamily);

    /**
     * 新增同住人员信息
     * 
     * @param eFamily 同住人员信息
     * @return 结果
     */
    public int insertEFamily(EFamily eFamily);

    /**
     * 修改同住人员信息
     * 
     * @param eFamily 同住人员信息
     * @return 结果
     */
    public int updateEFamily(EFamily eFamily);

    /**
     * 删除同住人员信息
     * 
     * @param id 同住人员信息主键
     * @return 结果
     */
    public int deleteEFamilyById(Long id);

    /**
     * 批量删除同住人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEFamilyByIds(String[] ids);

    void insertEFamilys(@Param("e_id") Long eId,@Param("list") List<EFamily> family);

    void delFamilyByIds(Long[] ids);
}
