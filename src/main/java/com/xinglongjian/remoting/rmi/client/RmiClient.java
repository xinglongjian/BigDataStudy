package com.xinglongjian.remoting.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.xinglongjian.rmi.ICall;

public class RmiClient {

	ICall rhello = null;

	public void init() {
		try {
			// 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
			rhello = (ICall) Naming.lookup("rmi://localhost:8888/ICall");
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public String print() {
		try {
			String p = rhello.callString();
			System.out.println(rhello);
			System.out.println(p);
			return p;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
