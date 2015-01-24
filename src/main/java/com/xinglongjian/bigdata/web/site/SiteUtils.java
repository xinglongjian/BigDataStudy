package com.xinglongjian.bigdata.web.site;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author root
 * 
 */
public class SiteUtils {
	/**
	 * 站点KEY
	 */
	public static final String SITE_KEY = "_site_key";


	/**
	 * 获得站点
	 * 
	 * @param request
	 * @return
	 */
	public static StudySite getSite(HttpServletRequest request) {
		return (StudySite) request.getAttribute(SITE_KEY);
	}

	/**
	 * 设置站点
	 * 
	 * @param request
	 * @param site
	 */
	public static void setSite(HttpServletRequest request, StudySite site) {
		request.setAttribute(SITE_KEY, site);
	}

	/**
	 * 获得站点ID
	 * 
	 * @param request
	 * @return
	 */
	public static Integer getSiteId(HttpServletRequest request) {
		return getSite(request).getId();
	}
	
	public static StudySite getSiteFromRequest(HttpServletRequest request)
	{
	    StudySite site=getSite(request);
	    if(site!=null)
	        return site;
	    else{
	        site=new StudySite();
	        site.setLocalName(request.getLocalName());
	        site.setContextPath(request.getContextPath());
	        site.setRealPath(request.getRealPath("/"));
	        site.setProtocol(request.getProtocol());
	        site.setLocalAddr(request.getLocalAddr());
	        site.setLocalPort(request.getLocalPort());
	        site.setLocalFront("zh_CN");
	        setSite(request, site);
	    }
	    
	    return site;
	}
}
