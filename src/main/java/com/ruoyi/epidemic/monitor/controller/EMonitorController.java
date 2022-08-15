package com.ruoyi.epidemic.monitor.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.epidemic.monitor.domain.EMonitor;
import com.ruoyi.epidemic.monitor.service.IEMonitorService;
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
 * 监测点Controller
 * 
 * @author yuancc
 * @date 2022-08-12
 */
@Controller
@RequestMapping("/epidemic/monitor")
public class EMonitorController extends BaseController
{
    private String prefix = "epidemic/monitor";

    @Autowired
    private IEMonitorService eMonitorService;

    @RequiresPermissions("epidemic:monitor:view")
    @GetMapping()
    public String monitor()
    {
        return prefix + "/monitor";
    }

    /**
     * 查询监测点列表
     */
    @RequiresPermissions("epidemic:monitor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EMonitor eMonitor)
    {
        startPage();
        List<EMonitor> list = eMonitorService.selectEMonitorList(eMonitor);
        return getDataTable(list);
    }

    /**
     * 导出监测点列表
     */
    @RequiresPermissions("epidemic:monitor:export")
    @Log(title = "监测点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EMonitor eMonitor)
    {
        List<EMonitor> list = eMonitorService.selectEMonitorList(eMonitor);
        ExcelUtil<EMonitor> util = new ExcelUtil<EMonitor>(EMonitor.class);
        return util.exportExcel(list, "监测点数据");
    }

    /**
     * 新增监测点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存监测点
     */
    @RequiresPermissions("epidemic:monitor:add")
    @Log(title = "监测点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EMonitor eMonitor)
    {
        return toAjax(eMonitorService.insertEMonitor(eMonitor));
    }

    /**
     * 修改监测点
     */
    @RequiresPermissions("epidemic:monitor:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EMonitor eMonitor = eMonitorService.selectEMonitorById(id);
        mmap.put("eMonitor", eMonitor);
        return prefix + "/edit";
    }

    /**
     * 修改保存监测点
     */
    @RequiresPermissions("epidemic:monitor:edit")
    @Log(title = "监测点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EMonitor eMonitor)
    {
        return toAjax(eMonitorService.updateEMonitor(eMonitor));
    }

    /**
     * 删除监测点
     */
    @RequiresPermissions("epidemic:monitor:remove")
    @Log(title = "监测点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eMonitorService.deleteEMonitorByIds(ids));
    }
}
