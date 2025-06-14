
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Pass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name="rahul"; 
		WebDriver Sam = new EdgeDriver();
		String PassWord = GetPassword(Sam); 
		Sam.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); 
		Sam.get("https://rahulshettyacademy.com/locatorspractice/");
		Sam.findElement(By.id("inputUsername")).sendKeys(name);
		Sam.findElement(By.name("inputPassword")).sendKeys(PassWord);
		Sam.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(Sam.findElement(By.tagName("p")).getText()); 
		Assert.assertEquals(Sam.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Thread.sleep(2000);
		Assert.assertEquals(Sam.findElement(By.xpath("//div/h2")).getText(),"Hello "+name+",");
		Thread.sleep(2000);
		Sam.findElement(By.xpath("//button[text()='Log Out'] ")).click(); 
		Thread.sleep(4000);
		Sam.quit(); 

	}
	//GitHub Push and commit from Eclipse 
	public static String  GetPassword(WebDriver Sam) throws InterruptedException{
		Sam.get("https://rahulshettyacademy.com/locatorspractice/");
		Sam.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000); 
		Sam.findElement(By.className("reset-pwd-btn")).click();
		String parser = Sam.findElement(By.className("infoMsg")).getText(); 
		String [] parser2 = parser.split("'");
		//String[] parser3 = parser2[1].split("'"); 
		String password = parser2[1].split("'")[0]; 
		return password; 
		}
}

