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
	//ȫ�ֱ���
		String url;
		WebDriver driver;
	//�൱��Ԥ������
		@BeforeClass
		public void afterClass1() {
			System.setProperty("webdriver.chrome.driver", "./tools/chromedriver.exe");
			driver=new ChromeDriver();
			url="http://localhost:8080/examsys/login.thtml";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void open() throws InterruptedException {
	//��ת������	
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("hujianming");
		driver.findElement(By.name("userpass")).sendKeys("hujianming123");
	//������	
		WebElement a=driver.findElement(By.name("usertype"));
		Select s=new Select(a);
		s.selectByIndex(2);
		Thread.sleep(6000);
		driver.findElement(By.className("tm_btn")).click();
		Thread.sleep(1000);
	//��λ���ÿ��
		driver.switchTo().frame("main");
		/*WebElement g=driver.findElement(By.xpath("/html/body/div/div[1]/ul/li"));
		System.out.print(g.getText());*/
//		��ȡ����ӡ
		String text1 = driver.findElement(By.xpath("/html/body/div/div[1]/ul/li")).getText();
		System.out.println(text1);
	//�ж��ַ��Ƿ���һ��	
		if(text1.equals("��ҳ")) {
			System.out.println("��¼�ɹ�");
		}
		else{
			System.out.println("��¼ʧ��");
		}
		
		/*if(text1!="null") {
			System.out.print("��¼�ɹ�");
		}
		else{
			System.out.print("��¼ʧ��");
		}*/
		}
		
		
		@AfterClass
		public void thr() {
			driver.close();
		
	}


}
