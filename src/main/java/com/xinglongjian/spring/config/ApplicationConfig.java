package com.xinglongjian.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xinglongjian.spring.CarProductMechine;
import com.xinglongjian.spring.IProductMechine;
import com.xinglongjian.spring.di.IProductFactory;
import com.xinglongjian.spring.di.ProductFactory;

@Configuration
public class ApplicationConfig {
	
	public @Bean IProductFactory getProductFactory()
	{
		ProductFactory pf=new ProductFactory();
		pf.setProductMechine(getProductMechine());
		return pf;
	}
	
	public @Bean IProductMechine getProductMechine()
	{
		 return new CarProductMechine();
	}

}
