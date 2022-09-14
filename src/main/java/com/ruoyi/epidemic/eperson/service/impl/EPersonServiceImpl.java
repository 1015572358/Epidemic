package com.ruoyi.epidemic.eperson.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.eperson.mapper.EPersonMapper;
import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.epidemic.keypalce.domain.EKeyplace;
import com.ruoyi.epidemic.keypalce.mapper.EKeyplaceMapper;
import com.ruoyi.epidemic.monitor.domain.EMonitor;
import com.ruoyi.epidemic.monitor.mapper.EMonitorMapper;
import com.ruoyi.project.system.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 阳性人员Service业务层处理
 *
 * @author yuancc
 * @date 2022-08-04
 */
@Service
public class EPersonServiceImpl implements IEPersonService
{
    private static final Logger log = LoggerFactory.getLogger(EPersonServiceImpl.class);

    @Autowired
    private EPersonMapper ePersonMapper;
    @Autowired
    protected Validator validator;
    @Autowired
    private EMonitorMapper emonitorMapper;
    @Autowired
    private EKeyplaceMapper ekeyplaceMapper;

    /**
     * 查询阳性人员
     *
     * @param id 阳性人员主键
     * @return 阳性人员
     */
    @Override
    public EPerson selectEPersonById(Long id)
    {
        return ePersonMapper.selectEPersonById(id);
    }

    /**
     * 查询阳性人员列表
     *
     * @param ePerson 阳性人员
     * @return 阳性人员
     */
    @Override
    public List<EPerson> selectEPersonList(EPerson ePerson)
    {
        return ePersonMapper.selectEPersonList(ePerson);
    }

    /**
     * 新增阳性人员
     *
     * @param ePerson 阳性人员
     * @return 结果
     */
    @Override
    public int insertEPerson(EPerson ePerson)
    {
        return ePersonMapper.insertEPerson(ePerson);
    }

    /**
     * 修改阳性人员
     *
     * @param ePerson 阳性人员
     * @return 结果
     */
    @Override
    public int updateEPerson(EPerson ePerson)
    {
        return ePersonMapper.updateEPerson(ePerson);
    }

    /**
     * 批量删除阳性人员
     *
     * @param ids 需要删除的阳性人员主键
     * @return 结果
     */
    @Override
    public int deleteEPersonByIds(String ids)
    {
        return ePersonMapper.deleteEPersonByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除阳性人员信息
     *
     * @param id 阳性人员主键
     * @return 结果
     */
    @Override
    public int deleteEPersonById(Long id)
    {
        return ePersonMapper.deleteEPersonById(id);
    }

    /**
     * 导入用户数据
     *
     * @param personList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importPerson(List<EPerson> personList, boolean isUpdateSupport)
    {
        if (StringUtils.isNull(personList) || personList.size() == 0)
        {
            throw new ServiceException("导入人员数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String yqbh = "";
        for (EPerson person : personList)
        {
            try
            {
                // 验证是否存在这个用户
                EPerson ep = ePersonMapper.selectEPersonBySfzh(person.getSfzh());
                BeanValidators.validateWithException(validator, person);
                if(null != person.getENo() && !"".equals(person.getENo())){
                    yqbh = person.getENo();
                } else {
                    person.setENo(yqbh);
                }
                if (StringUtils.isNull(ep))
                {

                    if("".equals(person.getENo())){
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、人员： '" + person.getName() + "' 无法获取疫情编号");
                    } else {
                        //疫情编号拼接年份
                        person.setENo(DateUtils.getDate_year()+"."+person.getENo());
                        this.ePersonMapper.insertEPerson(person);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、人员 " + person.getName() + " 更新成功");
                    }
                }
                else if (isUpdateSupport)
                {
                    if("".equals(person.getENo())){
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、人员： '" + person.getName() + "' 无法获取疫情编号");
                    } else {
                        //疫情编号拼接年份
                        person.setENo(DateUtils.getDate_year()+"."+person.getENo());
                        person.setId(ep.getId());
                        this.ePersonMapper.updateEPerson(person);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、人员 " + person.getName() + " 更新成功");
                    }
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、人员 " +  person.getName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、人员 " + person.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
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

    @Override
    public HashMap<String, Object> getData_Month() {
        HashMap<String,Object> map = new HashMap<String,Object>();
        //查询12个月的数据
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        List<Map<String, Object>> list = this.ePersonMapper.getData_Month(nums);
        String[] name = new String[12];
        String[] allData = new String[12];
        String[] wzzData = new String[12];
        String[] jwsrData = new String[12];
        for(int i=0;i<list.size();i++) {
            Map hashMap = (HashMap<String, Object>) list.get(i);
            name[i] = String.valueOf(hashMap.get("time"));
            allData[i] = String.valueOf(hashMap.get("allnum")==null?"0":hashMap.get("allnum"));
            wzzData[i] = String.valueOf(hashMap.get("wzznum")==null?"0":hashMap.get("wzznum"));
            jwsrData[i] = String.valueOf(hashMap.get("jwsrnum")==null?"0":hashMap.get("jwsrnum"));
        }
        map.put("name", name);
        map.put("allData", allData);
        map.put("wzzData", wzzData);
        map.put("jwsrData", jwsrData);
        return map;
    }

    @Override
    public List<EPerson> getConfirmed() {
        return ePersonMapper.getConfirmed();
    }

    @Override
    public List queryAllTimeTable() {
        return ePersonMapper.queryAllTimeTable();
    }

    @Override
    public Map<String, Object> getView() {
        List<Map<String,Object>> part1 = ePersonMapper.getViewPart1();
        List<Map<String,Object>> part2 = ePersonMapper.getViewPart2();
        List<Map<String,Object>> part3 = ePersonMapper.getViewPart3();
        List<Map<String,Object>> part4 = ePersonMapper.getViewPart4();
        List<Map<String,Object>> part5 = ePersonMapper.getViewPart5();
        Map<String,Object> result = new HashMap<>();
        result.put("part1",part1);
        result.put("part2",part2);
        result.put("part3",part3);
        result.put("part4",part4);
        result.put("part5",part5);
        return result;
    }

    @Override
    public Map<String, Object> getBMapView() {
        //获取确诊人员的经纬度（忽略没有填写的）
        List<EPerson> part1 = ePersonMapper.getBMapViewJWD();
        List<EPerson> collect = null;
        if(part1!=null && part1.size()>0) {
            collect = part1.stream().map(person -> {
                person.setGender("0".equals(person.getGender())?"男":"女");
                if ("1".equals(person.getConfirmd())) {
                    person.setConfirmd("是");
                } else if ("2".equals(person.getConfirmd())) {
                    person.setConfirmd("无症状");
                } else {
                    person.setConfirmd("不确定");
                }
                return person;
            }).collect(Collectors.toList());
        }
        List<EKeyplace> part2 = ekeyplaceMapper.selectEKeyplaceList(new EKeyplace());
        List<EMonitor> part3 = emonitorMapper.selectEMonitorList(new EMonitor());
        Map<String,Object> result = new HashMap<>();
        result.put("part1",collect);
        result.put("part2",part2);
        result.put("part3",part3);
        return result;
    }

    @Override
    public List<EPerson> selectEPersonListExitRyId(EPerson ePerson) {
        return ePersonMapper.selectEPersonListExitRyId(ePerson);
    }

    @Override
    public void addRelations(String ids,Long eId) {
        ePersonMapper.addRelations(ids,eId);
    }

    @Override
    public String selectRelationByeId(Long ryId) {
        return this.ePersonMapper.selectRelationByeId(ryId);
    }

    @Override
    public List<EPerson> getRelationByIds(Long ryId) {
        return ePersonMapper.getRelationByIds(ryId);
    }

    @Override
    public Map<String, Object> getSecondView(String chartParam) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> part1 = ePersonMapper.getTop10ByCommunity(chartParam);
        List<Map<String,Object>> part2 = ePersonMapper.getGenderByConfirmd(chartParam);
        List<Map<String,Object>> part3 = ePersonMapper.getProfessionByCommunity(chartParam);
        List<Map<String,Object>> part4 = ePersonMapper.getReseauByCommunity(chartParam);
        result.put("part1",part1);
        result.put("part2",part2);
        result.put("part3",part3);
        result.put("part4",part4);
        return result;
    }

    @Override
    public Map<String, Object> getThirdView(String chartParam) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> part1 = ePersonMapper.getTop10ByCasesSource(chartParam);
        List<Map<String,Object>> part2 = ePersonMapper.getGenderByCasesSource(chartParam);
        result.put("part1",part1);
        result.put("part2",part2);
        return result;
    }

    @Override
    public Map<String, Object> getFourView(String chartParam) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> part1 = ePersonMapper.getTop10ByGender(chartParam);
        result.put("part1",part1);
        return result;
    }

    @Override
    public Map<String, Object> getFiveView(String chartParam,String gender) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> part1 = ePersonMapper.getReseauByAge(chartParam.split("-")[0],chartParam.split("-")[1],gender);
        result.put("part1",part1);
        return result;
    }

    @Override
    public List<EPerson> selectEPersonList_echarts(EPerson person) {
        return ePersonMapper.selectEPersonList_echarts(person.getGender(),person.getLatitude().split("-")[0],person.getLatitude().split("-")[1]);
    }

    @Override
    public Map<String, Object> getSixView(String chartParam) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> part1 = ePersonMapper.getTop10ByCommunity_wg(chartParam);
        List<Map<String,Object>> part2 = ePersonMapper.getGenderByConfirmd_wg(chartParam);
        List<Map<String,Object>> part3 = ePersonMapper.getProfessionByCommunity_wg(chartParam);
        result.put("part1",part1);
        result.put("part2",part2);
        result.put("part3",part3);
        return result;
    }

    @Override
    public Map<String, Object> getReportData(String startTime, String endTime) {
        Map<String, Object> result = new HashMap<>();
        //图一 病例特征
        List<Map<String,Object>> part1 = ePersonMapper.getReportDataByGraphOne(startTime,endTime);
        //图二 性别分布
        List<Map<String,Object>> part2 = ePersonMapper.getReportDataByGraphTwo(startTime,endTime);
        //图三 病例年龄分布
        List<Map<String,Object>> part3 = ePersonMapper.getReportDataByGraphThree(startTime,endTime);
        //图四 职业年龄分布
        List<Map<String,Object>> part4 = ePersonMapper.getReportDataByGraphFour(startTime,endTime);
        //图五 职业年龄分布
        List<Map<String,Object>> part5 = ePersonMapper.getReportDataByGraphFive(startTime,endTime);
        //图六初筛阳性病例 按照日统计
        List<Map<String,Object>> part6 = ePersonMapper.getReportDataByGraphSix(startTime,endTime);
        //图七初筛阳性病例 按照日统计
        List<Map<String,Object>> part7 = ePersonMapper.getReportDataByGraphSeven(startTime,endTime);
        //图八 社区分布占比
        List<Map<String,Object>> part8 = ePersonMapper.getReportDataByGraphEight(startTime,endTime);
        result.put("part1",part1);
        result.put("part2",part2);
        result.put("part3",part3);
        result.put("part4",part4);
        result.put("part5",part5);
        result.put("part6",part6);
        result.put("part7",part7);
        result.put("part8",part8);
        return result;
    }
}
