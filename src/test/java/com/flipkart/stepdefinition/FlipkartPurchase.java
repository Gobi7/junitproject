package com.flipkart.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class FlipkartPurchase {
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
	public void method2() {
		WebElement srch= driver.findElement(By.xpath("//input[@name='q']"));
		srch.sendKeys("samsung s23 ultra");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement text = driver.findElement(By.xpath("(//div[contains(text(),'SAMSUNG Galaxy')])[1]"));
		name=text.getText();
		System.out.println(name);
	}
	@Test
	public void method3() {
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();	
	}
	@Test
	public void method4() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String x: child) {
			if(!x.equals(parent)) {
				driver.switchTo().window(x);
				System.out.println("Window Switched to child");
			}
		}
	}
	@Test
	public void method5() {
		WebElement buybtn=driver.findElement(By.xpath("//button[text()='Buy Now']"));
		Assert.assertTrue(buybtn.isDisplayed());
//		System.out.println(bt);
		
		WebElement text = driver.findElement(By.xpath("//span[contains(text(),'SAMSUNG Galaxy ')]"));
		String nam=text.getText();
		System.out.println(nam);
		
//		boolean result=name.equals(nam);
//		System.out.println(result);
		
		Assert.assertEquals(nam,name);
	}
	@Test
	@Ignore
	public void method6() throws IOException {
		TakesScreenshot tk =(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//target//report.jpg");
		FileUtils.copyFile(src, dest);
	}
}




















