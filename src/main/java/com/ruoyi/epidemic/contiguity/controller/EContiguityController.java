package com.ruoyi.epidemic.contiguity.controller;

import java.util.List;

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
import com.ruoyi.epidemic.contiguity.domain.EContiguity;
import com.ruoyi.epidemic.contiguity.service.IEContiguityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 密接者Controller
 *
 * @author yuancc
 * @date 2022-08-19
 */
@Controller
@RequestMapping("/contiguity/contiguity")
public class EContiguityController extends BaseController
{
    private String prefix = "epidemic/contiguity";

    @Autowired
    private IEContiguityService eContiguityService;

    @RequiresPermissions("epidemic:contiguity:view")
    @GetMapping()
    public String contiguity()
    {
        return prefix + "/contiguity";
    }

    /**
     * 查询密接者列表
     */
    @RequiresPermissions("epidemic:contiguity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EContiguity eContiguity)
    {
        startPage();
        //判断查询条件
        List<EContiguity> list = eContiguityService.selectEContiguityList(eContiguity);
        return getDataTable(list);
    }

    /**
     * 导出密接者列表
     */
    @RequiresPermissions("epidemic:contiguity:export")
    @Log(title = "密接者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EContiguity eContiguity)
    {
        List<EContiguity> list = eContiguityService.selectEContiguityList(eContiguity);
        ExcelUtil<EContiguity> util = new ExcelUtil<EContiguity>(EContiguity.class);
        return util.exportExcel(list, "密接者数据");
    }

    /**
     * 新增密接者
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存密接者
     */
    @RequiresPermissions("epidemic:contiguity:add")
    @Log(title = "密接者", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EContiguity eContiguity)
    {
        return toAjax(eContiguityService.insertEContiguity(eContiguity));
    }

    /**
     * 修改密接者
     */
    @RequiresPermissions("epidemic:contiguity:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EContiguity eContiguity = eContiguityService.selectEContiguityById(id);
        mmap.put("eContiguity", eContiguity);
        return prefix + "/edit";
    }

    /**
     * 修改保存密接者
     */
    @RequiresPermissions("epidemic:contiguity:edit")
    @Log(title = "密接者", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EContiguity eContiguity)
    {
        return toAjax(eContiguityService.updateEContiguity(eContiguity));
    }

    /**
     * 删除密接者
     */
    @RequiresPermissions("epidemic:contiguity:remove")
    @Log(title = "密接者", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eContiguityService.deleteEContiguityByIds(ids));
    }

    /**
     * 导出模板
     * @return
     */
    @RequiresPermissions("epidemic:contiguity:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<EContiguity> util = new ExcelUtil<EContiguity>(EContiguity.class);
        return util.importTemplateExcel("密接数据");
    }

    /**
     * 导入数据
     * @param file
     * @return
     * @throws Exception
     */
    @Log(title = "密接管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("epidemic:contiguity:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file,String relationValue) throws Exception
    {
        if(relationValue == null){
            return AjaxResult.success("请选择关联病例！");
        }
        ExcelUtil<EContiguity> util = new ExcelUtil<EContiguity>(EContiguity.class);
        List<EContiguity> contiList = util.importExcel(file.getInputStream());
        String message = eContiguityService.importConti(contiList);
        return AjaxResult.success(message);
    }
}
