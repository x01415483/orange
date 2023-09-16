package orange;
    import java.util.concurrent.TimeUnit;
    import org.testng.Assert;
	import org.testng.annotations.Ignore;
	import org.testng.annotations.Test;

	public class HomeTest extends BaseClass{
		Home homepage;
		
		@Test(priority = 8)
	    public void pim()   {
			Home home = new Home(driver);
			loginpage=new LoginPage(driver);
			loginpage.login("Admin", "admin123");
			home.clickOnPIM();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
			String actualURL=driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
	  }
	}

