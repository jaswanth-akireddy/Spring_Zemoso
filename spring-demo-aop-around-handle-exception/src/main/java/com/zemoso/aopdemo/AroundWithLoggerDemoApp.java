package com.zemoso.aopdemo;

import com.zemoso.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundWithLoggerDemoApp {
	private static Logger myLogger =
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {


		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService
				= context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain program: AroundDemoApp");
		myLogger.info("Calling getFortune");
		String data = theTrafficFortuneService.getFortune();

		myLogger.info("\nMy fortune is: "+data);

		myLogger.info("Finished");

		// close the context
		context.close();
	}

}










