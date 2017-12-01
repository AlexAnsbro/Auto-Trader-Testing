package consulting.autotradertests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchingPage {

	@FindBy (css= "#\\32 01711271617083 > article > section.content-column > figure > a > img")
	WebElement carLink;
	
	
	
	
	public void clickLink() {
		carLink.click();
	}
}
