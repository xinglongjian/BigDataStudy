package com.xinglongjian.spring.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.xinglongjian.spring","com.xinglongjian.hibernate"})
public class CDPlayerConfig {

}
