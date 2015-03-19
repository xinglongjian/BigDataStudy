package com.xinglongjian.spring.di;

import com.xinglongjian.spring.IProductMechine;
import com.xinglongjian.spring.Product;

public class ProductFactory implements IProductFactory{

	private IProductMechine productMechine;
	
	public void setProductMechine(IProductMechine productMechine) {
		this.productMechine = productMechine;
	}

	@Override
	public Product produce() {
		// TODO Auto-generated method stub
		return productMechine.produce();
	}

}
