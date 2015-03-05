package com.xinglongjian.remoting.caucho.server;

import org.springframework.remoting.caucho.HessianProxyFactoryBean;

public class SplitService implements ISplitService {
	@Override
	public String getValues() {
		HessianProxyFactoryBean d;
		// TODO Auto-generated method stub
		return "This is my Hessian service";
	}

}
