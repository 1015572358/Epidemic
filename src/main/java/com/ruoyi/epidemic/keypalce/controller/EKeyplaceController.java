package com.ruoyi.epidemic.keypalce.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.epidemic.keypalce.domain.EKeyplace;
import com.ruoyi.epidemic.keypalce.service.IEKeyplaceService;
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

import java.util.List;

/**
 * 重点场所Controller
 * 
 * @author yuancc
 * @date 2022-08-11
 */
@Controller
@RequestMapping("/epidemic/keyplace")
public class EKeyplaceController extends BaseController
{
    private String prefix = "epidemic/keyplace";

    @Autowired
    private IEKeyplaceService eKeyplaceService;

    @RequiresPermissions("epidemic:keyplace:view")
    @GetMapping()
    public String keyplace()
    {
        return prefix + "/keyplace";
    }

    /**
     * 查询重点场所列表
     */
    @RequiresPermissions("epidemic:keyplace:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EKeyplace eKeyplace)
    {
        startPage();
        List<EKeyplace> list = eKeyplaceService.selectEKeyplaceList(eKeyplace);
        return getDataTable(list);
    }

    /**
     * 导出重点场所列表
     */
    @RequiresPermissions("epidemic:keyplace:export")
    @Log(title = "重点场所", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EKeyplace eKeyplace)
    {
        List<EKeyplace> list = eKeyplaceService.selectEKeyplaceList(eKeyplace);
        ExcelUtil<EKeyplace> util = new ExcelUtil<EKeyplace>(EKeyplace.class);
        return util.exportExcel(list, "重点场所数据");
    }

    /**
     * 新增重点场所
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存重点场所
     */
    @RequiresPermissions("epidemic:keyplace:add")
    @Log(title = "重点场所", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EKeyplace eKeyplace)
    {
        return toAjax(eKeyplaceService.insertEKeyplace(eKeyplace));
    }

    /**
     * 修改重点场所
     */
    @RequiresPermissions("epidemic:keyplace:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EKeyplace eKeyplace = eKeyplaceService.selectEKeyplaceById(id);
        mmap.put("eKeyplace", eKeyplace);
        return prefix + "/edit";
    }

    /**
     * 修改保存重点场所
     */
    @RequiresPermissions("epidemic:keyplace:edit")
    @Log(title = "重点场所", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EKeyplace eKeyplace)
    {
        return toAjax(eKeyplaceService.updateEKeyplace(eKeyplace));
    }

    /**
     * 删除重点场所
     */
    @RequiresPermissions("epidemic:keyplace:remove")
    @Log(title = "重点场所", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eKeyplaceService.deleteEKeyplaceByIds(ids));
    }
}
