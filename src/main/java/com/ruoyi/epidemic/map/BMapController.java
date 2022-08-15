package com.ruoyi.epidemic.map;

import com.ruoyi.epidemic.eperson.service.IEPersonService;
import com.ruoyi.epidemic.etrack.service.IETrackService;
import com.ruoyi.framework.web.domain.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/bmap")
@RequiresPermissions("bmap:bmap:view")
public class BMapController {

    @Autowired
    IEPersonService personService;
    @Autowired
    IETrackService trackService;

    @GetMapping("view")
    @RequiresPermissions("bmap:bmap:view")
    public String showView(){
        return "main_map";
    }

    @GetMapping("track")
    @RequiresPermissions("bmap:track:view")
    public String showTrack(){
        return "bmap_track";
    }

    @GetMapping("/getView")
    @RequiresPermissions("bmap:bmap:view")
    @ResponseBody
    public AjaxResult getView(){
        Map<String,Object> result = personService.getBMapView();
        return AjaxResult.success(result);
    }

    @GetMapping("/getTrack")
    @RequiresPermissions("bmap:bmap:view")
    @ResponseBody
    public AjaxResult getTrack(String namekey){
        Map<String,Object> result = trackService.getBMapView(namekey);
        return AjaxResult.success(result);
    }

}
