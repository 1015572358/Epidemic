package com.ruoyi.epidemic.family.controller;

import java.util.List;
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
import com.ruoyi.epidemic.family.domain.EFamily;
import com.ruoyi.epidemic.family.service.IEFamilyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 同住人员信息Controller
 * 
 * @author yuancc
 * @date 2022-08-17
 */
@Controller
@RequestMapping("/family/family")
public class EFamilyController extends BaseController
{
    private String prefix = "family/family";

    @Autowired
    private IEFamilyService eFamilyService;

    @RequiresPermissions("family:family:view")
    @GetMapping()
    public String family()
    {
        return prefix + "/family";
    }

    /**
     * 查询同住人员信息列表
     */
    @RequiresPermissions("family:family:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EFamily eFamily)
    {
        startPage();
        List<EFamily> list = eFamilyService.selectEFamilyList(eFamily);
        return getDataTable(list);
    }

    /**
     * 导出同住人员信息列表
     */
    @RequiresPermissions("family:family:export")
    @Log(title = "同住人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EFamily eFamily)
    {
        List<EFamily> list = eFamilyService.selectEFamilyList(eFamily);
        ExcelUtil<EFamily> util = new ExcelUtil<EFamily>(EFamily.class);
        return util.exportExcel(list, "同住人员信息数据");
    }

    /**
     * 新增同住人员信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存同住人员信息
     */
    @RequiresPermissions("family:family:add")
    @Log(title = "同住人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EFamily eFamily)
    {
        return toAjax(eFamilyService.insertEFamily(eFamily));
    }

    /**
     * 修改同住人员信息
     */
    @RequiresPermissions("family:family:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EFamily eFamily = eFamilyService.selectEFamilyById(id);
        mmap.put("eFamily", eFamily);
        return prefix + "/edit";
    }

    /**
     * 修改保存同住人员信息
     */
    @RequiresPermissions("family:family:edit")
    @Log(title = "同住人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EFamily eFamily)
    {
        return toAjax(eFamilyService.updateEFamily(eFamily));
    }

    /**
     * 删除同住人员信息
     */
    @RequiresPermissions("family:family:remove")
    @Log(title = "同住人员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eFamilyService.deleteEFamilyByIds(ids));
    }

    @Log(title = "批量删除", businessType = BusinessType.DELETE)
    @GetMapping("/delFamilyByIds/{ids}")
    @ResponseBody
    public AjaxResult delFamilyByIds(@PathVariable("ids") Long[] ids){
        eFamilyService.delFamilyByIds(ids);
        return AjaxResult.success();
    }
}
