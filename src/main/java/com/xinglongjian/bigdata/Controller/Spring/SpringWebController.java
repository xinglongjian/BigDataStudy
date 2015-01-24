package com.xinglongjian.bigdata.Controller.Spring;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * spring web controller
 * @author root
 *
 */
@Controller
public class SpringWebController {
	
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/spring/springmvc", method = RequestMethod.GET)
	public String springmvc(Locale locale, Model model) {
		return "spring/springmvc/index";
	}

}
