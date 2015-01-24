package com.xinglongjian.bigdata.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author root
 *
 */
public class FrontUtils {
	/**
	 * 部署路径
	 */
	public static final String BASE = "base";
	/**
	 * 站点
	 */
	public static final String SITE = "site";
	
	/**
	 * 为前台模板设置公用数据
	 * 
	 * @param request
	 * @param model
	 */
	public static void frontData(HttpServletRequest request,Map<String, Object> map, StudySite site) {
		map.put(SITE, site);
		String ctx = site.getContextPath() == null ? "" : site.getContextPath();
		map.put(BASE, ctx);
	}

}
