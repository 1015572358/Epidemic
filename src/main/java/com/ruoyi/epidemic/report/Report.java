package com.ruoyi.epidemic.report;

import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.epidemic.report.service.ReportService;
import com.ruoyi.epidemic.report.vo.ImgVo;
import com.ruoyi.epidemic.report.vo.ReportVo;
import com.ruoyi.framework.web.domain.AjaxResult;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * author:yuancc
 * time:2022年8月17日
 * 流行病学调查报告
 */
@Controller
@RequestMapping("/report")
@RequiresPermissions("report:report:view")
public class Report {

    @Autowired
    ReportService reportService;
    @Autowired
    IEPersonService personService;

    @GetMapping()
    public String addReport() {
        return "epidemic/report/addReport";
    }

    @GetMapping("showPerson")
    public String showPerson(){
        return "epidemic/report/showPerson";
    }

    @PostMapping("/addReport")
    @ResponseBody
    public AjaxResult addReport(ReportVo reportVo) {
        if(null == reportVo.getE_id() || "".equals(reportVo.getE_id())) {
            return AjaxResult.error();
        }
        reportService.insertReport(reportVo);
        return AjaxResult.success();
    }

    @GetMapping("/checkPerson/{ryId}")
    @ResponseBody
    public AjaxResult checkPerson(@PathVariable("ryId") Long ryId){
        Integer personCount = reportService.checkPerson(ryId);
        return AjaxResult.success(personCount);
    }

    @GetMapping("/getReport/{ryId}")
    @ResponseBody
    public AjaxResult getReport(@PathVariable("ryId") Long ryId){
        ReportVo reportVo = reportService.getReport(ryId);
        return AjaxResult.success(reportVo);
    }

    @GetMapping("/showReport/{ryId}")
    public String showReport(@PathVariable("ryId") Long ryId, Model model) {
        ReportVo reportVo = reportService.getReport(ryId);
        model.addAttribute("report",reportVo);
        return "epidemic/report/showReport";
    }



    //首页导出数据echarts图形数据获取
    @GetMapping("/getReportData/{startTime}/{endTime}")
    @ResponseBody
    public AjaxResult getReportData(@PathVariable("startTime") String startTime,@PathVariable("endTime") String endTime){
        Map<String,Object> result = personService.getReportData(startTime,endTime);
        return AjaxResult.success(result);
    }

    /**
     * 导出数据模板
     */
    @PostMapping("/exportData")
    public AjaxResult exportData(ImgVo imagevo, HttpServletResponse response) {
        Class iclass = imagevo.getClass();
        Field[] declaredFields = iclass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field ff = declaredFields[i];
            ff.setAccessible(true);
            try {
                String fValue = (String) ff.get(imagevo);
                if(fValue != null){
                    String base64 = fValue.replaceAll(" ", "+");
                    String[] arr = base64.split("base64,");
                    ff.set(imagevo,arr[1]);
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
//        String base64 = image.replaceAll(" ", "+");
//        // 数据中：data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABI4AAAEsCAYAAAClh/jbAAA ...  在"base64,"之后的才是图片信息
//        String[] arr = base64.split("base64,");
//        image = arr[1];
        Map<String,Object> dataMap=new HashMap<String,Object>();
        dataMap.put("img1",imagevo.getImg1());
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        String path = "D://ycc";
        try {
            configuration.setDirectoryForTemplateLoading(new File(path));  //FTL文件所存在的位置
        } catch (IOException e) {
            e.printStackTrace();
        }
        Template t = null;
        try {
            t = configuration.getTemplate("test2.ftl"); //文件名
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.reset();
            response.setContentType("application/vnd.ms-word;charset=gbk");
            response.setHeader("Content-Disposition", "attachment; filename=123.doc");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
            String fileName = sdf.format(new Date()) + ".doc";
            String outpath = "D:/pgbg/" + fileName;
            File file = new File(outpath);     //文件路径
            if (!file.exists()) {
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new File(outpath), "UTF-8");
            OutputStream outs = response.getOutputStream();
            t.process(dataMap, writer);
            File outFile = new File(outpath); //导出文件
            FileInputStream in = new FileInputStream(outFile);
            byte buffer[] = new byte[1024];
            int len = 0;
            while((len=in.read(buffer))>0){
                outs.write(buffer, 0, len);
            }
            writer.close();
            in.close();
            response.flushBuffer();
            outs.close();
        }catch (Exception e){

        }
        return AjaxResult.success();
    }
}
