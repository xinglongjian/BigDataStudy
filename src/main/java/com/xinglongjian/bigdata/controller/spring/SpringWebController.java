package com.xinglongjian.bigdata.controller.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinglongjian.bigdata.web.model.Order;
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


	/**
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/spring/order", method = RequestMethod.GET)
	public String order(Locale locale, ModelMap model,HttpServletRequest request) {
		StudySite site=SiteUtils.getSiteFromRequest(request);
		FrontUtils.frontData(request, model, site);
		List<Order> orders=new ArrayList<Order>();
		orders.add(new Order("1111", "1111", 10, new Date()));
		orders.add(new Order("2222", "2222", 12, new Date()));
		orders.add(new Order("3333", "3333", 13, new Date()));
		orders.add(new Order("4444", "4444", 14, new Date()));
		orders.add(new Order("5555", "5555", 15, new Date()));
		model.addAttribute("orders",orders);
		model.addAttribute("menu","spring");
		model.addAttribute("ddmenu","springweb");
		model.addAttribute("submenu","order");
		return "spring/springweb/order";
	}
	
	/**
	 * for XML
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/spring/order.xml", method = RequestMethod.GET)
	public String xml(Locale locale, ModelMap model,HttpServletRequest request) {
		List<Order> orders=new ArrayList<Order>();
		orders.add(new Order("1111", "1111", 10, new Date()));
		orders.add(new Order("2222", "2222", 12, new Date()));
		orders.add(new Order("3333", "3333", 13, new Date()));
		orders.add(new Order("4444", "4444", 14, new Date()));
		orders.add(new Order("5555", "5555", 15, new Date()));
		model.addAttribute("orders",orders);
		return "order";
	}
	
	/**
	 * for JSON
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/spring/order.json", method = RequestMethod.GET)
	public String json(Locale locale, ModelMap model,HttpServletRequest request) {
		List<Order> orders=new ArrayList<Order>();
		orders.add(new Order("1111", "1111", 10, new Date()));
		orders.add(new Order("2222", "2222", 12, new Date()));
		orders.add(new Order("3333", "3333", 13, new Date()));
		orders.add(new Order("4444", "4444", 14, new Date()));
		orders.add(new Order("5555", "5555", 15, new Date()));
		model.addAttribute("orders",orders);
		return "order";
	}
}
