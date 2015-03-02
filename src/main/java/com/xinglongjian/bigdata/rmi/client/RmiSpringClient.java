package com.xinglongjian.bigdata.rmi.client;

import com.xinglongjian.bigdata.rmi.server.IRmiService;

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
