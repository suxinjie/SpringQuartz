/**
 * 
 */
package com.sue.demo;

import java.text.ParseException;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.CronTriggerBean;

/**
 * @author sue
 * 
 */
public class SetCronExpressionImpl implements SetCronExpression {

	private Scheduler scheduler;

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public void setCronException() {

		String cronExpression = "0/3 * * * * ?";

		if (scheduler == null) {
			scheduler = (Scheduler) SpringApplicationContextHolder.getBean("strQuartz");
		}
		
		try {
			CronTriggerBean trigger = (CronTriggerBean) scheduler.getTrigger("timerTrigger", Scheduler.DEFAULT_GROUP);
			trigger.setCronExpression(cronExpression);
			scheduler.rescheduleJob("timerTrigger", Scheduler.DEFAULT_GROUP, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
