package com.flipkart.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaptopPurchase {
	static WebDriver driver;
	
	@BeforeClass
	public static void launch() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
	}
	@AfterClass
	public static void close() {
		driver.quit();
	}
	static long srt;
	@Before
	public void startTime() {
		srt=System.currentTimeMillis();	
	}
	@After
	public void endTime() {
		long end = System.currentTimeMillis();
		System.out.println("Time taken by a method : " +(end - srt) );	
	}
	@Test
	public void method1() {
		try {
		WebElement btn=driver.findElement((By.xpath("//button[@class='_2KpZ6l _2doB4z']")));
		Boolean value =btn.isDisplayed();
		System.out.println("Login :" +value);
		btn.click();
		}
		catch(Exception e) {
//			e.printStackTrace();
			System.out.println("Login Not Required");	
		}
	}
	static String name;
	@Test
	public void method2() throws InterruptedException {
		WebElement srch= driver.findElement(By.xpath("//input[@name='q']"));
		srch.sendKeys("lenovo laptops");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement text = driver.findElement(By.xpath("(//div[contains(text(),'Lenovo IdeaPad Slim')])[1]"));
		name=text.getText();
		System.out.println(name);
		Thread.sleep(2000);
	}
}
