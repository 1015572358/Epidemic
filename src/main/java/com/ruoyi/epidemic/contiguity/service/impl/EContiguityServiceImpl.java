package com.ruoyi.epidemic.contiguity.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.eperson.mapper.EPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.epidemic.contiguity.mapper.EContiguityMapper;
import com.ruoyi.epidemic.contiguity.domain.EContiguity;
import com.ruoyi.epidemic.contiguity.service.IEContiguityService;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 密接者Service业务层处理
 *
 * @author yuancc
 * @date 2022-08-19
 */
@Service
public class EContiguityServiceImpl implements IEContiguityService
{
    @Autowired
    private EContiguityMapper eContiguityMapper;
    @Autowired
    private EPersonMapper ePersonMapper;
    @Autowired
    protected Validator validator;

    /**
     * 查询密接者
     *
     * @param id 密接者主键
     * @return 密接者
     */
    @Override
    public EContiguity selectEContiguityById(Long id)
    {
        return eContiguityMapper.selectEContiguityById(id);
    }

    /**
     * 查询密接者列表
     *
     * @param eContiguity 密接者
     * @return 密接者
     */
    @Override
    public List<EContiguity> selectEContiguityList(EContiguity eContiguity)
    {
        return eContiguityMapper.selectEContiguityList(eContiguity);
    }

    /**
     * 新增密接者
     *
     * @param eContiguity 密接者
     * @return 结果
     */
    @Override
    public int insertEContiguity(EContiguity eContiguity)
    {
        return eContiguityMapper.insertEContiguity(eContiguity);
    }

    /**
     * 修改密接者
     *
     * @param eContiguity 密接者
     * @return 结果
     */
    @Override
    public int updateEContiguity(EContiguity eContiguity)
    {
        return eContiguityMapper.updateEContiguity(eContiguity);
    }

    /**
     * 批量删除密接者
     *
     * @param ids 需要删除的密接者主键
     * @return 结果
     */
    @Override
    public int deleteEContiguityByIds(String ids)
    {
        return eContiguityMapper.deleteEContiguityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除密接者信息
     *
     * @param id 密接者主键
     * @return 结果
     */
    @Override
    public int deleteEContiguityById(Long id)
    {
        return eContiguityMapper.deleteEContiguityById(id);
    }

    @Override
    public String importConti(List<EContiguity> contiList) {
        if (StringUtils.isNull(contiList) || contiList.size() == 0)
        {
            throw new ServiceException("导入密接数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (EContiguity eContiguity : contiList) {
            try {
                BeanValidators.validateWithException(validator, eContiguity);
                this.insertEContiguity(eContiguity);
                successNum++;
                successMsg.append("<br/>" + successNum + "、姓名： " + eContiguity.getName() + " 导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + failureNum + "、姓名： " + eContiguity.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
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
