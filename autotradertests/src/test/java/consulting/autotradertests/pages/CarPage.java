package consulting.autotradertests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarPage {
	@FindBy (css="#main-content > div.fpa-header-container > header > h1 > span.pricetitle__advertTitle")
	WebElement carName;
	
	public String getCarName() {
		return carName.getText();
	}
}
