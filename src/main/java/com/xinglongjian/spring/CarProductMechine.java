package com.xinglongjian.spring;

public class CarProductMechine implements IProductMechine {

	
	@Override
	public Product produce() {
		// TODO Auto-generated method stub
		return new CarProduct();
	}

}
