package consulting.autotradertests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import consulting.autotradertests.pages.CarPage;
import consulting.autotradertests.pages.HomePage;
import consulting.autotradertests.pages.SearchingPage;
import junit.framework.Assert;

public class TraderTests {

	private String url = "https://www.autotrader.co.uk/";

	private WebDriver webDriver;
	private static ExtentReports report;
	
	@BeforeClass
	public static void init () {
		report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(url);;
	}
	
	//Test1
	@Test
	public void searchForCar() throws InterruptedException {
		HomePage page = PageFactory.initElements(webDriver, HomePage.class);
		SearchingPage searchPage = PageFactory.initElements(webDriver, SearchingPage.class);
		ExtentTest test = report.createTest("SearchForCar");
		
		String targetCar = "Lotus Eclat 2.2 2dr";
		test.log(Status.INFO, "Starting car search");
		test.log(Status.DEBUG, "Entering Postcode");
		page.enterPostCode("PR32TB");
		test.log(Status.DEBUG, "Entering Car Make");
		page.enterCarMake("Lotus", webDriver);
		Thread.sleep(1000);
		test.log(Status.DEBUG, "Setting Min Price");
		page.setCarMinPrice();
		Thread.sleep(1000);
		test.log(Status.DEBUG, "Setting Max Price");
		page.setCarMaxPrice();
		test.log(Status.DEBUG, "Searching");
		page.clickSearch();
		
		CarPage carPage = PageFactory.initElements(webDriver, CarPage.class);
		searchPage.clickLink();
		assertEquals("Not correct car", targetCar, carPage.getCarName());
	}
	//Test 2
	@Ignore
	@Test
	public void registerAccount () {
		
	}
	//Test 3 
	@Ignore
	@Test
	public void rapidNavigation() {
		
	}
	
	//Test 4
	@Ignore
	@Test
	public void sellCar() {
		String reg = "PKZ 9897";
		String mileage = "100";
		
		
	}
	
	//Test 5
	@Ignore
	@Test
	public void signIn() {
		
	}
	
	//Test 6
	@Ignore
	@Test
	public void validateCar() {
		
	}
	
	//Test 7
	@Ignore
	@Test
	public void haltRegistation() {
		
	}
	
	//Test 8
	@Ignore
	@Test
	public void writeOwnerReview() {
		
	}
	
	//Test 9
	@Ignore
	@Test
	public void viewNews() {
		
	}
	
	//Test 10
	@Ignore
	@Test
	public void getFinanceQuote() {
		
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	@AfterClass
	public static void destroy() {
		report.flush();
	}
}
