package com.zemoso.aopdemo;

import com.zemoso.aopdemo.dao.AccountDAO;
import com.zemoso.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService
				= context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain program: AroundDemoApp");
		System.out.println("Calling getFortune");
		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");

		// close the context
		context.close();
	}

}










