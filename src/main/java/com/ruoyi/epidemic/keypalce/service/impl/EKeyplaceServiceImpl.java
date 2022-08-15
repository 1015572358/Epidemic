package com.ruoyi.epidemic.keypalce.service.impl;

import com.ruoyi.epidemic.keypalce.domain.EKeyplace;
import com.ruoyi.epidemic.keypalce.mapper.EKeyplaceMapper;
import com.ruoyi.epidemic.keypalce.service.IEKeyplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

import java.util.List;

/**
 * 重点场所Service业务层处理
 * 
 * @author yuancc
 * @date 2022-08-11
 */
@Service
public class EKeyplaceServiceImpl implements IEKeyplaceService
{
    @Autowired
    private EKeyplaceMapper eKeyplaceMapper;

    /**
     * 查询重点场所
     * 
     * @param id 重点场所主键
     * @return 重点场所
     */
    @Override
    public EKeyplace selectEKeyplaceById(Long id)
    {
        return eKeyplaceMapper.selectEKeyplaceById(id);
    }

    /**
     * 查询重点场所列表
     * 
     * @param eKeyplace 重点场所
     * @return 重点场所
     */
    @Override
    public List<EKeyplace> selectEKeyplaceList(EKeyplace eKeyplace)
    {
        return eKeyplaceMapper.selectEKeyplaceList(eKeyplace);
    }

    /**
     * 新增重点场所
     * 
     * @param eKeyplace 重点场所
     * @return 结果
     */
    @Override
    public int insertEKeyplace(EKeyplace eKeyplace)
    {
        return eKeyplaceMapper.insertEKeyplace(eKeyplace);
    }

    /**
     * 修改重点场所
     * 
     * @param eKeyplace 重点场所
     * @return 结果
     */
    @Override
    public int updateEKeyplace(EKeyplace eKeyplace)
    {
        return eKeyplaceMapper.updateEKeyplace(eKeyplace);
    }

    /**
     * 批量删除重点场所
     * 
     * @param ids 需要删除的重点场所主键
     * @return 结果
     */
    @Override
    public int deleteEKeyplaceByIds(String ids)
    {
        return eKeyplaceMapper.deleteEKeyplaceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除重点场所信息
     * 
     * @param id 重点场所主键
     * @return 结果
     */
    @Override
    public int deleteEKeyplaceById(Long id)
    {
        return eKeyplaceMapper.deleteEKeyplaceById(id);
    }
}
