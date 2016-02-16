package lazer.SecondTestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test

  public void testGoogle() {
	   String path ="C:\\Users\\Lazer\\workspace\\home\\Resources\\chromedriver.exe";
	   
	  System.setProperty("webdriver.chrome.driver",path);
	  WebDriver driver = new ChromeDriver();
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  driver.manage().window().maximize();
	  driver.navigate().to("https://travel.americanexpress.com/home");
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='iNavLastElement iNavNGI_linkDefault']")));
	  js.executeScript("window.scrollBy(0,250)", "");
	  boolean isPresent = driver.findElement(By.cssSelector("rh-floating-login-menu[class='loginArrowContainer']")).isDisplayed();
	  //boolean isPresent = driver.findElement(By.name("btnK")).isDisplayed();
	  if(isPresent==true){
		  System.out.println("Button is displayed");
	  }
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String element = driver.findElement(By.xpath("//button[@class='hpFlightBtn flightSearchButton primary-button']")).getAttribute("tabindex");
	  System.out.println(element);
	  driver.findElement(By.xpath("//li/a[@title='Click for Cruises']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  boolean a = driver.findElement(By.xpath("//div/button[@ng-click='submitCruiseForm()']")).isDisplayed();
	  System.out.println(a);
	  Select durationdrop = new Select(driver.findElement(By.name("selectedDuration")));
	  durationdrop.selectByValue("1");
	  String elementdropdown = durationdrop.getFirstSelectedOption().getText();
	  System.out.println(elementdropdown);
	
	  String b = driver.findElement(By.xpath("//div/button[@class ='primary-button rhCtaButtonSingle']")).getAttribute("class");
	  System.out.println(b);
	  Assert.assertTrue(b.contains("primary"));;
	  //Assert.assertTrue(b.startsWith(""));;
	  //Assert.assertTrue(b.endsWith(""));;
	  System.out.println("Success");
	  driver.quit();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before test");
	
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After test");
  }

}
