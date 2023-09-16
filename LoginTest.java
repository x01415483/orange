package orange;
    import org.testng.Assert;
	import org.testng.annotations.Ignore;
	import org.testng.annotations.Test;

	public class LoginTest extends BaseClass{
		

		//To verify LoginPage with valid credentials	
	  @Test(priority = 1)
	  public void loginPageTest() throws Exception {
		  loginpage=new LoginPage(driver);
		  loginpage.login("Admin", "admin123");
		  String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		  String actualURL=driver.getCurrentUrl();
		  Assert.assertEquals(actualURL, expectedURL);
		  }
	 
	  //To verify LoginPage with Invalid Username
	 @Test(priority=2)
	  public void verifyWithInvadidUsername() {
		  loginpage=new LoginPage(driver);
		  loginpage.login("Adm", "admin123");
		  String expected_Error="Invalid credentials";
		  String actual_Error=loginpage.invalidCrendentials();
		  Assert.assertEquals(actual_Error,expected_Error);
	  }
	 //To verify the Login page with blank Username
	 @Test(priority = 3)
	 public void verifyWithBlankUsername() {
		  loginpage=new LoginPage(driver);
		  loginpage.login("", "Admin123");
		  String expected_Error="Required";
		  String actual_Error=loginpage.blankUsername.getText();
		  Assert.assertEquals(actual_Error,expected_Error);
	 }
	 //To verify the Login page with blank Password
	 @Test(priority = 4)
	 public void verifyWithBlankPassword() {
		 loginpage=new LoginPage(driver);
		 loginpage.login("Admin", "");
		 String expected_Error="Required";
		 String actual_Error=loginpage.blankPassword.getText();
		 Assert.assertEquals(actual_Error,expected_Error);
	 }
	 
	 //To verify Login page with Invalid Password
	 @Test(priority = 5)
	 public void verifyWithInvalidPassword() {
		  loginpage=new LoginPage(driver);
		  loginpage.login("Admin", "adm12");
		  String expected_Error="Invalid credentials";
		  String actual_Error=loginpage.invalidCrendentials();
		  Assert.assertEquals(actual_Error,expected_Error);
	 }
	 
	 //To verify the Login page with InvalidCredentials
	 @Test(priority = 6)
	 public void verifyLoginWithInvalidCredentials() {
		 	  loginpage=new LoginPage(driver);
			  loginpage.login("Adm", "admin12");
			  String expected_Error="Invalid credentials";
			  String actual_Error=loginpage.invalidCrendentials();
			  Assert.assertEquals(actual_Error,expected_Error);
	}
	 
	 //To verify the login page with blank Username and Password
	 @Test(priority = 7)
	 public void verifyLoginWithBlankCredentials() {
		 loginpage=new LoginPage(driver);
		 loginpage.login("", "");
		 String expected_Error="Required";
		 String actual_error1=loginpage.blankUsername.getText();
		 String actual_Error=loginpage.blankPassword.getText();
		 Assert.assertEquals(actual_Error,expected_Error);
		 Assert.assertEquals(actual_error1, expected_Error);
	 }
	 
	 
	}
