package com.xinglongjian.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinglongjian.spring.Product;
import com.xinglongjian.spring.di.IProductFactory;
import com.xinglongjian.spring.di.ProductFactory;

public class ConfigMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext();
		ctx.register(ApplicationConfig.class);
		ctx.refresh();
		
		IProductFactory pf=ctx.getBean(ProductFactory.class);
		Product p=pf.produce();
		System.out.println(p.getName());
	}

}
