package orange;
    import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Home extends BaseClass{

		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")WebElement pimTab;
		
		Home(WebDriver d){
			driver=d;
			PageFactory.initElements(driver, this);
		}
		public void clickOnPIM() {
			pimTab.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
