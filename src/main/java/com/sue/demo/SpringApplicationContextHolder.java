/**
 * 
 */
package com.sue.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author sue
 * 
 * spring的applicationContext上下文.
 */
public class SpringApplicationContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringApplicationContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 获取applicationContext对象
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 根据beanid获取spring中的bean对象
	 * 
	 * @param beanId
	 * @return
	 */
	public static Object getBean(String beanId) {
		return  applicationContext.getBean(beanId);
	}
}
