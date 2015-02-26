package com.xinglongjian.bigdata.controller.spring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinglongjian.bigdata.web.site.FrontUtils;
import com.xinglongjian.bigdata.web.site.SiteUtils;
import com.xinglongjian.bigdata.web.site.StudySite;

/**
 * Controller for RMI Examples
 * @author root
 *
 */
@Controller
public class RmiController {
	
	@RequestMapping(value = "/rmi/", method = RequestMethod.GET)
	public String index(Locale locale, ModelMap model,HttpServletRequest request) {
		StudySite site=SiteUtils.getSiteFromRequest(request);
		FrontUtils.frontData(request, model, site);
		model.addAttribute("menu","j2ee");
		model.addAttribute("ddmenu","rmi");
		model.addAttribute("submenu","index");
		return "restful/index";
	}
    
}
