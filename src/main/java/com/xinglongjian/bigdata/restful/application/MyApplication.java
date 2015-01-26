package com.xinglongjian.bigdata.restful.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.xinglongjian.bigdata.restful.resource.OrderResource;

@ApplicationPath("webresource")
public class MyApplication extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(OrderResource.class);
        return resources;
    }
}
