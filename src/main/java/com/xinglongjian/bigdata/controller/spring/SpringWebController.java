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
 * spring web controller
 * @author root
 *
 */
@Controller
public class SpringWebController {
	
	
	/**
	 *  spring
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/spring/springweb", method = RequestMethod.GET)
	public String springmvc(Locale locale, ModelMap model,HttpServletRequest request) {
		StudySite site=SiteUtils.getSiteFromRequest(request);
		FrontUtils.frontData(request, model, site);
		model.addAttribute("menu","spring");
		model.addAttribute("ddmenu","springweb");
		model.addAttribute("submenu","index");
		return "spring/springweb/index";
	}
	/**
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/spring/pdf", method = RequestMethod.GET)
	public String pdf(Locale locale, ModelMap model,HttpServletRequest request) {
		return "pdf";
	}
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/spring/excel", method = RequestMethod.GET)
	public String excel(Locale locale, ModelMap model,HttpServletRequest request) {
		return "excel";
	}

}
