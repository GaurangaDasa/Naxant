/*package com.sample.mvc.daoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sample.mvc.model.EmployeeCommand;
import com.sample.mvc.service.EmployeeService;
import com.sample.mvc.service.EmployeeServiceImpl;

public class EmployeeDAOImplTest {
	
//	EmployeeCommand emp=new EmployeeCommand(105,"vikas","pune");
	EmployeeService emp1=new EmployeeServiceImpl();
	
	@Test
	public void addEmpTest()
	{
		String name="vikas" ,city="Ruchi";
		int code=100 ;
		EmployeeCommand employee=(EmployeeCommand) emp1.listContact();
		String name1=employee.getName(),city1=employee.getCity();
		int code1=employee.getCode();
		System.out.println(code1);
		assertEquals(name, name1);
		assertEquals(city, city1);
		assertEquals(code, code1);
	}
}


package com.sample.mvc.daoTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EmployeeDAOImplTest {
  private WebDriver driver;
  private String baseUrl;
 
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.redbus.in/Booking/SelectBus.aspx?fromCityId=130&toCityId=462_2&doj=13-Jan-2015&busType=Any&opId=0&doj1=16-Jan-2015";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCheck() throws Exception {
	  driver.get(baseUrl + "/search?q=redbus+booking&ie=utf-8&oe=utf-8&aq=t&rls=org.mozilla:en-US:official&client=firefox-a&channel=sb&gfe_rd=cr&ei=DYSzVNiAFM3M8gfvhYHADQ");
	    driver.findElement(By.id("vs0p1")).click();
	    driver.findElement(By.id("txtDestination")).click();
	    driver.findElement(By.id("txtDestination")).clear();
	    driver.findElement(By.id("txtDestination")).sendKeys("Mum");
	    driver.findElement(By.cssSelector("li.selected")).click();
	    driver.findElement(By.xpath("//div[@id='rbcal_txtOnwardCalendar']/table/tbody/tr[5]/td[2]")).click();
	    driver.findElement(By.xpath("//div[@id='rbcal_txtReturnCalendar']/table/tbody/tr[5]/td[5]")).click();
	    driver.findElement(By.id("searchBtn")).click();
	    driver.findElement(By.xpath("//div[@id='onwardTrip']/div[2]/ul/li[2]/li/div/div[9]/button")).click();
	    new Select(driver.findElement(By.cssSelector("select"))).selectByVisibleText("Swargate-Purple Tr Mitramandal Chowk Shraddha Lodge - 09:30 PM");
	    driver.findElement(By.cssSelector("button.continueBtn")).click();
//	    assertEquals("Please select at least 1 seat", closeAlertAndGetItsText());
	    driver.findElement(By.cssSelector("a.booked.seat")).click();
	    driver.findElement(By.xpath("//div[@id='onwardTrip']/div[2]/ul/li[2]/li/div/div[10]/div/div/div[2]/div/div/div[2]/div/div[2]/ul/li[7]/a")).click();
	    driver.findElement(By.cssSelector("button.continueBtn")).click();
	 
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();

  }

  
}
*/