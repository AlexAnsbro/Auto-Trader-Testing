package consulting.autotradertests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	@FindBy (css="#postcode")
	WebElement postCodeEntry;
	@FindBy (css="#searchVehiclesMake > option:nth-child(64)")
	WebElement carMake;
	
	@FindBy (css="#searchVehiclesPriceFrom > option:nth-child(2)")
	WebElement carMinPrice;
	@FindBy (xpath="//*[@id=\"searchVehiclesPriceTo\"]/option[10]")
	WebElement carMaxPrice;
	
	@FindBy(css="#js-search-button")
	WebElement searchBttn;
	
	
	public void enterPostCode (String postcode) {
		postCodeEntry.sendKeys(postcode);
	}
	
	public void enterCarMake (String make, WebDriver webDriver) {
		//new Select(webDriver.findElement(By.id("#searchVehiclesMake"))).selectByVisibleText("make");
		carMake.click();
	}
	
	public void setCarMinPrice() {
		carMinPrice.click();
	}
	public void setCarMaxPrice() {
		 carMaxPrice.click();
	}
	
	public void clickSearch() {
		searchBttn.click();
	}
}
