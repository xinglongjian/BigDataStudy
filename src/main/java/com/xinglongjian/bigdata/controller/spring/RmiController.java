package com.xinglongjian.bigdata.controller.spring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xinglongjian.bigdata.web.site.FrontUtils;
import com.xinglongjian.bigdata.web.site.SiteUtils;
import com.xinglongjian.bigdata.web.site.StudySite;
import com.xinglongjian.remoting.rmi.client.RmiClient;
import com.xinglongjian.remoting.rmi.client.RmiSpringClient;
import com.xinglongjian.remoting.rmi.server.IRmiService;
import com.xinglongjian.rmi.RmiCall;

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
		return "rmitest/index";
	}
	
	@RequestMapping(value = "/rmi/call.json", method = RequestMethod.GET)
	public String call(Locale locale, ModelMap model,HttpServletRequest request) {
		RmiClient rc=new RmiClient();
		rc.init();
		String s=rc.print();
		System.out.println(s);
		model.addAttribute("orders",s);
		return "order";
	}
//	@RequestMapping(value = "/rmi/call.json", method = RequestMethod.GET)
//	public String clientcall(Locale locale, ModelMap model,HttpServletRequest request) {
//		System.out.println(rmiServiceClient.getValues());
//		model.addAttribute("orders",rmiServiceClient.getValues());
//		return "order";
//	}
//	@Autowired
//    public RmiSpringClient rmiServiceClient;
}
