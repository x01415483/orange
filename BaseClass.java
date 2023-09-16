package orange;
    import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;


	public class BaseClass {
	 WebDriver driver;
	 LoginPage loginpage;
	 
	 
	@BeforeMethod
	  public void launchApp()  {
		
			System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	  }

