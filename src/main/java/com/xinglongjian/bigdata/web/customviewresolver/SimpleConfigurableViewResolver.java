package com.xinglongjian.bigdata.web.customviewresolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
/**
 * Custom View Resolver
 * @author root
 *
 */
public class SimpleConfigurableViewResolver implements ViewResolver {

	private Map<String, ? extends View> views = new HashMap<String, View>(); 
	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		// TODO Auto-generated method stub
		return views.get(viewName);
	}
	public void setViews(Map<String, ? extends View> views) {        
		this.views = views;    
	}
}
