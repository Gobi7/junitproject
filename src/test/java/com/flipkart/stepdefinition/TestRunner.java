package com.flipkart.stepdefinition;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runner.Result;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({FlipkartPurchase.class,LaptopPurchase.class})

public class TestRunner {
	
	public static void main(String[] args) {
		Result r = JUnitCore.runClasses(FlipkartPurchase.class,LaptopPurchase.class);
		
		System.out.println("Total run count"+r.getRunCount());
		System.out.println("Total failure count"+r.getFailureCount());
		System.out.println("Total ignore count"+r.getIgnoreCount());
		System.out.println("Total run count"+r.getRunTime());
		
		List<Failure> l =r.getFailures();
		
		for (Failure failure : l) {
			System.out.println(failure);
			System.out.println(failure.getTrace());
		}
	}
}
