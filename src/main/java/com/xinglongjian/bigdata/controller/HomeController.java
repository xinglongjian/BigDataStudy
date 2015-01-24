package com.xinglongjian.bigdata.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinglongjian.bigdata.web.FrontUtils;
import com.xinglongjian.bigdata.web.SiteUtils;
import com.xinglongjian.bigdata.web.StudySite;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		StudySite site=SiteUtils.getSiteFromRequest(request);
		FrontUtils.frontData(request, model, site);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("menu","home");
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
