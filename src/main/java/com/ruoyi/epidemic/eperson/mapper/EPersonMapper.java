package com.ruoyi.epidemic.eperson.mapper;


import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.eperson.service.impl.EPersonServiceImpl;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阳性人员Mapper接口
 * 
 * @author yuancc
 * @date 2022-08-04
 */
public interface EPersonMapper 
{
    /**
     * 查询阳性人员
     * 
     * @param id 阳性人员主键
     * @return 阳性人员
     */
    public EPerson selectEPersonById(Long id);

    /**
     * 查询阳性人员列表
     * 
     * @param ePerson 阳性人员
     * @return 阳性人员集合
     */
    public List<EPerson> selectEPersonList(EPerson ePerson);

    /**
     * 新增阳性人员
     * 
     * @param ePerson 阳性人员
     * @return 结果
     */
    public int insertEPerson(EPerson ePerson);

    /**
     * 修改阳性人员
     * 
     * @param ePerson 阳性人员
     * @return 结果
     */
    public int updateEPerson(EPerson ePerson);

    /**
     * 删除阳性人员
     * 
     * @param id 阳性人员主键
     * @return 结果
     */
    public int deleteEPersonById(Long id);

    /**
     * 批量删除阳性人员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEPersonByIds(String[] ids);

    /**
     * 根据身份证号查询是否存在
     * @param sfzh
     */
    EPerson selectEPersonBySfzh(String sfzh);

    /**
     *
     * @param nums
     * @return
     */
    @MapKey("time")
    List<Map<String, Object>> getData_Month(@Param("nums") int nums[]);

    List<EPerson> getConfirmed();

    List queryAllTimeTable();

    List<Map<String,Object>> getViewPart1();

    @MapKey("cases_source")
    List<Map<String, Object>> getViewPart2();

    @MapKey("reseau")
    List<Map<String, Object>> getViewPart3();

    List<Map<String, Object>> getViewPart4();

    List<Map<String, Object>> getViewPart5();

    List<EPerson> getBMapViewJWD();

    List<EPerson> selectEPersonListExitRyId(EPerson person);

    void addRelations(@Param("ids") String ids,@Param("eId") Long eId);

    String selectRelationByeId(Long ryId);

    List<EPerson> getRelationByIds(Long ryId);
}

