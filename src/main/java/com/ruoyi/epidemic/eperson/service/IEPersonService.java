package com.ruoyi.epidemic.eperson.service;


import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.project.system.user.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阳性人员Service接口
 * 
 * @author yuancc
 * @date 2022-08-04
 */
public interface IEPersonService 
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
     * 批量删除阳性人员
     * 
     * @param ids 需要删除的阳性人员主键集合
     * @return 结果
     */
    public int deleteEPersonByIds(String ids);

    /**
     * 删除阳性人员信息
     * 
     * @param id 阳性人员主键
     * @return 结果
     */
    public int deleteEPersonById(Long id);

    /**
     * excel导入
     * @param personList
     * @param updateSupport
     * @return
     */
    String importPerson(List<EPerson> personList, boolean updateSupport);

    /**
     * 获取总体情况折线图数据
     * @return
     */
    HashMap<String, Object> getData_Month();

    /**
     * 获取是否确诊
     * @return
     */
    List<EPerson> getConfirmed();

    List queryAllTimeTable();

    Map<String, Object> getView();

    Map<String, Object> getBMapView();

    List<EPerson> selectEPersonListExitRyId(EPerson ePerson);

    void addRelations(String ids,Long eId);

    String selectRelationByeId(Long ryId);

    List<EPerson> getRelationByIds(Long ryId);
}
