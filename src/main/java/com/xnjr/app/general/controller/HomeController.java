package com.xnjr.app.general.controller;

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
import com.xnjr.app.util.UploadUtil;

@Controller
@RequestMapping(value = "/general/home")
public class HomeController extends BaseController {
    @Autowired
    protected IDictAO dictAO;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addDict(@RequestBody Map map) {
    	map.put("companyCode", "0");
    	map.put("parentCode", "0");
    	map.put("belong", "1");
    	map.put("updater", this.getSessionUser().getUserName());
    	map.put("pic", UploadUtil.uploadPicture((String)map.get("pic")));
  		return BizConnecter.getBizData("806040", JsonUtils.mapToJson(map),
              Object.class);
	}

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object dropDict(@RequestBody Map map) {
  		return BizConnecter.getBizData("806041", JsonUtils.mapToJson(map),
              Object.class);
	}

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object editDict(@RequestBody Map map) {
    	map.put("companyCode", "0");
    	map.put("parentCode", "0");
    	map.put("belong", "1");
    	map.put("isCompanyEdit", "0");
    	map.put("updater", this.getSessionUser().getUserName());
    	map.put("pic", UploadUtil.uploadPicture((String)map.get("pic")));
  		return BizConnecter.getBizData("806042", JsonUtils.mapToJson(map),
              Object.class);
	}

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Object queryDictPage(@RequestParam Map<String,String> map) {
    	map.put("companyCode", "0");
  	    return BizConnecter.getBizData("806050", JsonUtils.mapToJson(map),
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
  	    return BizConnecter.getBizData("806053", JsonUtils.mapToJson(map),
              Object.class);
    }
}
