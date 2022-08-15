package com.ruoyi.epidemic.eperson.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 阳性人员Controller
 *
 * @author yuancc
 * @date 2022-08-04
 */
@Controller
@RequestMapping("/epidemic/eperson")
public class EPersonController extends BaseController
{
    private String prefix = "epidemic/eperson";

    @Autowired
    private IEPersonService ePersonService;

    @RequiresPermissions("epidemic:eperson:view")
    @GetMapping()
    public String eperson()
    {
        return prefix + "/eperson";
    }

    /**
     * 查询阳性人员列表
     */
    @RequiresPermissions("epidemic:eperson:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EPerson ePerson)
    {
        startPage();
        List<EPerson> list = ePersonService.selectEPersonList(ePerson);
        return getDataTable(list);
    }

    /**
     * 导出阳性人员列表
     */
    @RequiresPermissions("epidemic:eperson:export")
    @Log(title = "阳性人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EPerson ePerson)
    {
        List<EPerson> list = ePersonService.selectEPersonList(ePerson);
        ExcelUtil<EPerson> util = new ExcelUtil<EPerson>(EPerson.class);
        return util.exportExcel(list, "阳性人员数据");
    }

    /**
     * 新增阳性人员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存阳性人员
     */
    @RequiresPermissions("epidemic:eperson:add")
    @Log(title = "阳性人员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EPerson ePerson)
    {
        return toAjax(ePersonService.insertEPerson(ePerson));
    }

    /**
     * 修改阳性人员
     */
    @RequiresPermissions("epidemic:eperson:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EPerson ePerson = ePersonService.selectEPersonById(id);
        mmap.put("ePerson", ePerson);
        return prefix + "/edit";
    }

    /**
     * 修改保存阳性人员
     */
    @RequiresPermissions("epidemic:eperson:edit")
    @Log(title = "阳性人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EPerson ePerson)
    {
        return toAjax(ePersonService.updateEPerson(ePerson));
    }

    /**
     * 删除阳性人员
     */
    @RequiresPermissions("epidemic:eperson:remove")
    @Log(title = "阳性人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ePersonService.deleteEPersonByIds(ids));
    }


    @RequiresPermissions("epidemic:eperson:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<EPerson> util = new ExcelUtil<EPerson>(EPerson.class);
        return util.importTemplateExcel("阳性人员数据");
    }


    @Log(title = "阳性人员", businessType = BusinessType.IMPORT)
    @RequiresPermissions("epidemic:eperson:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<EPerson> util = new ExcelUtil<EPerson>(EPerson.class);
        List<EPerson> personList = util.importExcel(file.getInputStream());
        String message = ePersonService.importPerson(personList, updateSupport);
        return AjaxResult.success(message);
    }

    @GetMapping("/data_month")
    @ResponseBody
    public String data_month() {
        HashMap<String,Object> map = this.ePersonService.getData_Month();
        return JSON.toJSONString(map);
    }

    @RequestMapping("/queryAllTimeTable")
    @ResponseBody
    public String queryTable() {
        List list = this.ePersonService.queryAllTimeTable();
        return JSONObject.toJSONString(list);
    }
}
