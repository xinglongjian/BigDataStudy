package com.xinglongjian.remoting.rmi.client;

import com.xinglongjian.remoting.rmi.server.IRmiService;

public class RmiSpringClient {
	private IRmiService rmiService;

	public void setRmiService(IRmiService rmiService) {
		this.rmiService = rmiService;
	}
	
	public String getValues()
	{
		return rmiService.getValues();
	}

}
