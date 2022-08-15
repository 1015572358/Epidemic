package com.ruoyi.epidemic.etrack.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.epidemic.etrack.domain.ETrack;
import com.ruoyi.epidemic.etrack.domain.ETrackPlModel;
import com.ruoyi.epidemic.etrack.service.IETrackService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * 轨迹Controller
 *
 * @author yuancc
 * @date 2022-08-10
 */
@Controller
@RequestMapping("/epidemic/etrack")
public class ETrackController extends BaseController {
    private String prefix = "epidemic/etrack";

    @Autowired
    private IETrackService eTrackService;
    @Autowired
    IEPersonService personService;

    @RequiresPermissions("epidemic:etrack:view")
    @GetMapping()
    public String track() {
        return prefix + "/track";
    }

    /**
     * 查询轨迹列表
     */
    @RequiresPermissions("epidemic:etrack:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ETrack eTrack) {
        startPage();
        List<ETrack> list = eTrackService.selectETrackList(eTrack);
        return getDataTable(list);
    }

    /**
     * 导出轨迹列表
     */
    @RequiresPermissions("epidemic:etrack:export")
    @Log(title = "轨迹", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ETrack eTrack) {
        List<ETrack> list = eTrackService.selectETrackList(eTrack);
        ExcelUtil<ETrack> util = new ExcelUtil<ETrack>(ETrack.class);
        return util.exportExcel(list, "轨迹数据");
    }

    /**
     * 新增轨迹
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存轨迹
     */
    @RequiresPermissions("epidemic:etrack:add")
    @Log(title = "轨迹", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ETrack eTrack) {
        return toAjax(eTrackService.insertETrack(eTrack));
    }

    /**
     * 修改轨迹
     */
    @RequiresPermissions("epidemic:etrack:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ETrack eTrack = eTrackService.selectETrackById(id);
        mmap.put("eTrack", eTrack);
        return prefix + "/edit";
    }

    /**
     * 修改保存轨迹
     */
    @RequiresPermissions("epidemic:etrack:edit")
    @Log(title = "轨迹", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ETrack eTrack) {
        return toAjax(eTrackService.updateETrack(eTrack));
    }

    /**
     * 删除轨迹
     */
    @RequiresPermissions("epidemic:etrack:remove")
    @Log(title = "轨迹", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eTrackService.deleteETrackByIds(ids));
    }

    /**
     * 动态添加轨迹
     */
    @RequiresPermissions("epidemic:etrack:view")
    @GetMapping("/addGJs/{ryId}")
    public String addGjs(@PathVariable("ryId") Long ryId, Model model) {
        EPerson person = personService.selectEPersonById(ryId);
        model.addAttribute("person", person);
        return prefix + "/addgjs";
    }

    /**
     * 批量新增保存轨迹
     */
    @RequiresPermissions("epidemic:etrack:add")
    @Log(title = "轨迹", businessType = BusinessType.INSERT)
    @PostMapping("/addPL")
    @ResponseBody
    public AjaxResult addPL(ETrackPlModel eTrackPlModel) {
        return toAjax(eTrackService.insertOrupdatePl(eTrackPlModel));
    }

    @ResponseBody
    @GetMapping("/getTrackByeId/{eid}")
    @RequiresPermissions("epidemic:etrack:view")
    public AjaxResult getTrackByeId(@PathVariable("eid") Long eid) {
        ETrack eTrack = new ETrack();
        eTrack.seteId(eid);
        List<ETrack> eTracks = eTrackService.selectETrackList(eTrack);
        return AjaxResult.success(eTracks);
    }
}
