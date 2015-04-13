package com.xinglongjian.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

public class HibernateTest {

	SessionFactory sf;
	Transaction t;
	TransactionProxyFactoryBean tpb;
	TransactionStatus ds;
	HibernateTransactionManager d;
	TransactionInterceptor ti;
	TransactionAttribute ta;
	
}
