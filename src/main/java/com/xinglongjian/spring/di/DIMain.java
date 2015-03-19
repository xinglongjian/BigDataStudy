package com.xinglongjian.spring.di;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinglongjian.spring.Product;

public class DIMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        @SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-test.xml");
        IProductFactory pf=(IProductFactory)context.getBean("productFactory");
        Product p=pf.produce();
        System.out.println(p.getName());
        
        BeanNameAware dl;
	}

}
