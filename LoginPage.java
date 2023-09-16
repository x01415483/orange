package orange;
    import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage extends BaseClass{
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")WebElement userName;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")WebElement passWord;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")WebElement loginButton;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")WebElement invalidData;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")WebElement blankUsername;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")WebElement blankPassword;
		@FindBy(xpath="//*[text()=\"Forgot your password? \"]")WebElement forgotpassword;
		@FindBy(xpath = "//*[text()=\"Reset Password\"]")WebElement resetPassword;
		
		LoginPage(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
		}
		public void login(String uname,String pwd) {
			userName.clear();
			userName.sendKeys(uname);
			passWord.clear();
			passWord.sendKeys(pwd);
			loginButton.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		public String invalidCrendentials() {
			String actual_error=invalidData.getText();
			return actual_error;
		}
}
