package com.ruoyi.epidemic.analyse;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.framework.web.domain.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "epidemic/analyse/analyse";
    }


    @ResponseBody
    @GetMapping("/view")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult getView() {
        Map<String,Object> result = this.personService.getView();
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping("/secondView_chart1/{paramName}")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult secondView_chart1(@PathVariable("paramName") String chartParam) {
        if(chartParam == null || "".equals(chartParam)){
            return AjaxResult.error();
        }
        Map<String,Object> result = this.personService.getSecondView(chartParam);
        return AjaxResult.success(result);
    }


    @GetMapping("/showMyChart1/{paramName}")
    public String showMyChart1(@PathVariable("paramName") String chartParam, Model model) {
        model.addAttribute("chartParam",chartParam);
        return "epidemic/analyse/showMyChart1";
    }

    @GetMapping("/showMyChart2/{paramName}")
    public String showMyChart2(@PathVariable("paramName") String chartParam, Model model) {
        model.addAttribute("chartParam",chartParam);
        return "epidemic/analyse/showMyChart2";
    }

    @ResponseBody
    @GetMapping("/secondView_chart2/{paramName}")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult secondView_chart2(@PathVariable("paramName") String chartParam) {
        if(chartParam == null || "".equals(chartParam)){
            return AjaxResult.error();
        }
        Map<String,Object> result = this.personService.getThirdView(chartParam);
        return AjaxResult.success(result);
    }

    @ResponseBody
    @GetMapping("/secondView_chart3/{paramName}")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult secondView_chart3(@PathVariable("paramName") String chartParam) {
        if(chartParam == null || "".equals(chartParam)){
            return AjaxResult.error();
        }
        Map<String,Object> result = this.personService.getSixView(chartParam);
        return AjaxResult.success(result);
    }


    @GetMapping("/showMyChart3/{paramName}")
    public String showMyChart3(@PathVariable("paramName") String chartParam, Model model) {
        model.addAttribute("chartParam",chartParam);
        return "epidemic/analyse/showMyChart3";
    }

    @GetMapping("/showMyChart4/{paramName}")
    public String showMyChart4(@PathVariable("paramName") String chartParam, Model model) {
        model.addAttribute("chartParam",chartParam.equals("男")?"0":"1");
        return "epidemic/analyse/showMyChart4";
    }

    @ResponseBody
    @GetMapping("/secondView_chart4/{paramName}")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult secondView_chart4(@PathVariable("paramName") String chartParam) {
        if(chartParam == null || "".equals(chartParam)){
            return AjaxResult.error();
        }
        Map<String,Object> result = this.personService.getFourView(chartParam);
        return AjaxResult.success(result);
    }


    @GetMapping("/showMyChart5/{paramName}/{gender}")
    public String showMyChart5(@PathVariable("paramName") String chartParam,@PathVariable("gender") String gender, Model model) {
        //处理参数
        model.addAttribute("chartParam",chartParam.substring(0,chartParam.length()-1));
        model.addAttribute("paramGender",gender);
        return "epidemic/analyse/showMyChart5";
    }

    @ResponseBody
    @GetMapping("/secondView_chart5/{paramName}/{paramGender}")
    @RequiresPermissions("analyse:analyse:view")
    public AjaxResult secondView_chart5(@PathVariable("paramName") String chartParam,@PathVariable("paramGender") String gender) {
        if(chartParam == null || "".equals(chartParam)){
            return AjaxResult.error();
        }
        Map<String,Object> result = this.personService.getFiveView(chartParam,gender);
        return AjaxResult.success(result);
    }
}
