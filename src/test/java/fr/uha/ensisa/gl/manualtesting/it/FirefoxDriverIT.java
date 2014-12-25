package fr.uha.ensisa.gl.manualtesting.it;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverIT {



		WebDriver driver = new FirefoxDriver();
	    private String baseUrl;
	    
	    @Before
	    public void setUp() throws Exception
	    {
	        String port = System.getProperty("servlet.port");
	        this.baseUrl = "http://localhost:9876/manual-testing/";
	        
	        
	    }
	    
	    public WebDriver getDriver()
	    {
	    	return this.driver;
	    }
	    
	    @Test
	    public void add() {
			driver.get(baseUrl);
			
			//essai ajout testcase
			WebElement input = driver.findElement(By.name("name"));
			input.sendKeys("case");
			WebElement checkcase = driver.findElement(By.id("newtestcase"));
			checkcase.click();
			
			WebElement editcase = driver.findElement(By.id("caseEdit"));
			editcase.click();
			WebElement changename = driver.findElement(By.name("name"));
			changename.sendKeys("case2");
			WebElement clickchange = driver.findElement(By.name("name-button"));
			clickchange.click();
			
			WebElement addStep = driver.findElement(By.name("newStepDescr"));
			addStep.sendKeys("Test etape");
			WebElement checkCase = driver.findElement(By.name("newStep"));
			checkCase.click();
			WebElement run = driver.findElement(By.linkText("run"));
			run.click();
			
			WebElement done = driver.findElement(By.linkText("done"));
			done.click();
			
			WebElement home = driver.findElement(By.linkText("Home"));
			home.click();
			
			WebElement editcase2 = driver.findElement(By.id("case2Edit"));
			editcase2.click();
			
			run = driver.findElement(By.linkText("run"));
			run.click();
			
			WebElement failure = driver.findElement(By.name("failure"));
			failure.sendKeys("Test failed");
			
			WebElement failed = driver.findElement(By.name("failed"));
			failed.click();
			
			home = driver.findElement(By.linkText("Home"));
			home.click();
			editcase2 = driver.findElement(By.id("case2Edit"));
			editcase2.click();
			
			addStep = driver.findElement(By.name("newStepDescr"));
			addStep.sendKeys("Test etape2");
			checkCase = driver.findElement(By.name("newStep"));
			checkCase.click();
			
			WebElement up = driver.findElement(By.id("1Up"));
			up.click();
			WebElement down = driver.findElement(By.id("0Down"));
			down.click();
			WebElement delete = driver.findElement(By.id("1Delete"));
			delete.click();
			
			down = driver.findElement(By.id("0Down"));
			down.click();
			up = driver.findElement(By.id("0Up"));
			up.click();
			
			//Retour accueil
			
			home = driver.findElement(By.linkText("Home"));
			home.click();
			
			
			//effacer le testcase
			WebElement deletetest = driver.findElement(By.id("case2Delete"));
			deletetest.click();
			
			
			//essai ajout testsite
			WebElement inputs = driver.findElement(By.name("name"));
			inputs.sendKeys("suite");
			WebElement checkcases = driver.findElement(By.id("newsuitetest"));
			checkcases.click();
			
			WebElement editcasesuite = driver.findElement(By.id("suiteEdit"));
			editcasesuite.click();
			
	    }
	    
	    @Test
		public void test() {
	    	driver.get(baseUrl);
		
		}
	    
	    @AfterClass
	    public static void exit()
	    {
	    	FirefoxDriverIT fr = new FirefoxDriverIT();
	    	fr.getDriver().quit();
	    }
	
	    
}