package com.ruoyi.epidemic.analyse;

import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.framework.web.domain.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 数据分析模块
 */
@Controller
@RequestMapping("/analyse")
public class AnalyseController {

    @Autowired
    IEPersonService personService;

    @RequiresPermissions("analyse:analyse:view")
    @GetMapping()
    public String analyseView() {
        return "/epidemic/analyse/analyse";
    }


    @ResponseBody
    @GetMapping("/view")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult getView() {
        Map<String,Object> result = this.personService.getView();
        return AjaxResult.success(result);
    }
}
