package com.sue.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(
    			new String[]{"classpath:spring-application.xml", "classpath:spring-quartz.xml"});
    
    	SetCronExpression setCronExpression = (SetCronExpression) ctx.getBean("setCronExpression");
    
    	setCronExpression.setCronException();
    }
}
