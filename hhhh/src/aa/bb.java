package aa;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class bb {
	//全局变量
		String url;
		WebDriver driver;
	//相当于预置条件
		@BeforeClass
		public void afterClass1() {
			System.setProperty("webdriver.chrome.driver", "./tools/chromedriver.exe");
			driver=new ChromeDriver();
			url="http://localhost:8080/examsys/login.thtml";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void open() throws InterruptedException {
	//跳转并输入	
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("hujianming");
		driver.findElement(By.name("userpass")).sendKeys("hujianming123");
	//下拉框	
		WebElement a=driver.findElement(By.name("usertype"));
		Select s=new Select(a);
		s.selectByIndex(2);
		Thread.sleep(6000);
		driver.findElement(By.className("tm_btn")).click();
		Thread.sleep(1000);
	//定位到该框架
		driver.switchTo().frame("main");
		/*WebElement g=driver.findElement(By.xpath("/html/body/div/div[1]/ul/li"));
		System.out.print(g.getText());*/
//		获取并打印
		String text1 = driver.findElement(By.xpath("/html/body/div/div[1]/ul/li")).getText();
		System.out.println(text1);
	//判断字符是否是一样	
		if(text1.equals("首页")) {
			System.out.println("登录成功");
		}
		else{
			System.out.println("登录失败");
		}
		
		/*if(text1!="null") {
			System.out.print("登录成功");
		}
		else{
			System.out.print("登录失败");
		}*/
		}
		
		
		@AfterClass
		public void thr() {
			driver.close();
		
	}


}
