package com.xnjr.app.customer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xnjr.app.controller.BaseController;
import com.xnjr.app.general.ao.IDictAO;
import com.xnjr.app.http.BizConnecter;
import com.xnjr.app.http.JsonUtils;

@Controller
@RequestMapping(value = "/customer/examination")
public class ExaminationController extends BaseController {
    @Autowired
    protected IDictAO dictAO;
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    public Object addDict(@RequestBody Map map) {
//    	map.put("updater", this.getSessionUser().getUserName());
//  		return BizConnecter.getBizData("807700", JsonUtils.mapToJson(map),
//              Object.class);
//	}
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @ResponseBody
//    public Object dropDict(@RequestBody Map map) {
//  		return BizConnecter.getBizData("807701", JsonUtils.mapToJson(map),
//              Object.class);
//	}
//
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    @ResponseBody
//    public Object editDict(@RequestBody Map map) {
//    	map.put("id", map.get("code"));
//    	map.put("updater", this.getSessionUser().getUserName());
//  		return BizConnecter.getBizData("807702", JsonUtils.mapToJson(map),
//              Object.class);
//	}

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Object queryDictPage(@RequestParam Map<String,String> map) {
  	    return BizConnecter.getBizData("806150", JsonUtils.mapToJson(map),
              Object.class);
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public Object queryDictList(@RequestParam Map<String,String> map) {
//  	    return BizConnecter.getBizData("807706", JsonUtils.mapToJson(map),
//              Object.class);
//    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Object queryDictDetail(@RequestParam Map<String,String> map) {
    	map.put("id", map.get("code"));
  	    return BizConnecter.getBizData("806152", JsonUtils.mapToJson(map),
              Object.class);
    }
    
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public Object editDict(@RequestBody Map map) {
	  	map.put("approveUser", this.getSessionUser().getUserName());
		return BizConnecter.getBizData("806141", JsonUtils.mapToJson(map),
            Object.class);
	}
}
