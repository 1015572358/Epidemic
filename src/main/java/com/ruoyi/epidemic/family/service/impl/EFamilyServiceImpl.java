package com.ruoyi.epidemic.family.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.epidemic.family.mapper.EFamilyMapper;
import com.ruoyi.epidemic.family.domain.EFamily;
import com.ruoyi.epidemic.family.service.IEFamilyService;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 同住人员信息Service业务层处理
 * 
 * @author yuancc
 * @date 2022-08-17
 */
@Service
public class EFamilyServiceImpl implements IEFamilyService 
{
    @Autowired
    private EFamilyMapper eFamilyMapper;

    /**
     * 查询同住人员信息
     * 
     * @param id 同住人员信息主键
     * @return 同住人员信息
     */
    @Override
    public EFamily selectEFamilyById(Long id)
    {
        return eFamilyMapper.selectEFamilyById(id);
    }

    /**
     * 查询同住人员信息列表
     * 
     * @param eFamily 同住人员信息
     * @return 同住人员信息
     */
    @Override
    public List<EFamily> selectEFamilyList(EFamily eFamily)
    {
        return eFamilyMapper.selectEFamilyList(eFamily);
    }

    /**
     * 新增同住人员信息
     * 
     * @param eFamily 同住人员信息
     * @return 结果
     */
    @Override
    public int insertEFamily(EFamily eFamily)
    {
        return eFamilyMapper.insertEFamily(eFamily);
    }

    /**
     * 修改同住人员信息
     * 
     * @param eFamily 同住人员信息
     * @return 结果
     */
    @Override
    public int updateEFamily(EFamily eFamily)
    {
        return eFamilyMapper.updateEFamily(eFamily);
    }

    /**
     * 批量删除同住人员信息
     * 
     * @param ids 需要删除的同住人员信息主键
     * @return 结果
     */
    @Override
    public int deleteEFamilyByIds(String ids)
    {
        return eFamilyMapper.deleteEFamilyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除同住人员信息信息
     * 
     * @param id 同住人员信息主键
     * @return 结果
     */
    @Override
    public int deleteEFamilyById(Long id)
    {
        return eFamilyMapper.deleteEFamilyById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delFamilyByIds(Long[] ids) {
        eFamilyMapper.delFamilyByIds(ids);
    }
}
