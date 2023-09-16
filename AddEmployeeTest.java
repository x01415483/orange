package orange;
    import org.testng.Assert;
	import org.testng.annotations.Test;

	public class AddEmployeeTest extends BaseClass {
		Home homepage;
		AddEmployee add_emp1;
		
	//To verify Add Employee with all valid credentials	
	 @Test(priority = 9)
	  public void verifyAddEmployeepage() throws Exception {
			homepage=new Home(driver);
			loginpage=new LoginPage(driver);
			add_emp1=new AddEmployee(driver);
			loginpage.login("Admin", "admin123");
			homepage.clickOnPIM();
		  
			
				add_emp1.addEmployeeTab();
				add_emp1.typeFirstname("Pranjal");
				add_emp1.typeMiddlename("Akshay");
				add_emp1.typeLastname("Narkhede");
				add_emp1.typeEmployeeID("783526");
				add_emp1.addPhoto("C:\\Users\\p.a.dnyandeo.kolte\\Pictures\\p.a.dnyandeo.kolte.jpg");
				add_emp1.save();
				String expected="Personal Details";
				String actual=add_emp1.personalDetails.getText();
				Assert.assertEquals(actual, expected);
		
		  }
	 
	  //To verify the CreateLoginDetails with valid credentials
	@Test(priority = 10)
		public void verifyCreateLoginDetails() throws Exception {
			homepage=new Home(driver);
			loginpage=new LoginPage(driver);
			add_emp1=new AddEmployee(driver);
			loginpage.login("Admin", "admin123");
			homepage.clickOnPIM();
			
		
				add_emp1.addEmployeeTab();
				add_emp1.typeFirstname("Pranjal");
				add_emp1.typeMiddlename("Akshay");
				add_emp1.typeLastname("Narkhede");
				add_emp1.typeEmployeeID("783526");
				add_emp1.addPhoto("C:\\Users\\p.a.dnyandeo.kolte\\Pictures\\p.a.dnyandeo.kolte.jpg");
				add_emp1.createLoginDeatails();
				add_emp1.typeUsername("Pranzz");
				add_emp1.typePassword("Pp1Rr2Aa3$%^");
				add_emp1.typeConfirmPassword("Pp1Rr2Aa3$%^");
				add_emp1.selectStatus();
				add_emp1.save();
				Thread.sleep(2000);
				String expected="Personal Details";
				String actual=add_emp1.personalDetails.getText();
				Assert.assertEquals(actual, expected);
				  }

	//To verify Add Employee with Firstname and Lastname
	@Test(priority=11)
	public void verifyWithfnameAndlname() throws Exception {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		add_emp1.addEmployeeTab();
		
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeLastname("Narkhede");
		add_emp1.save();
		Thread.sleep(2000);
		String expected_page="Personal Details";
		String actual_page=add_emp1.personalDetails.getText();
		Assert.assertEquals(actual_page, expected_page);
	}

	//To verify Add Employee page with Employee ID
	@Test(priority = 12)
	public void verifyWithEmployeeID() {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeLastname("Narkhede");
		add_emp1.typeEmployeeID("783526");
		add_emp1.save();
		String expected_result="Personal Details";
		String actual_result=add_emp1.personalDetails.getText();
		Assert.assertEquals(actual_result, expected_result);
	}

	//To validate the Cancel button
	@Test(priority = 13)
	public void verifyCancelButton() throws Exception {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeLastname("Narkhede");
		add_emp1.typeEmployeeID("783526");
		add_emp1.cancel();
		Thread.sleep(2000);
		String expected_result="Employee Information";
		String actual_result=add_emp1.EmpInformation.getText();
		Assert.assertEquals(actual_result, expected_result);
	}

	//To verify with blank Firstname and Lastname
	@Test(priority=14)
	public void verifyWithBlankFnameandLname() {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("");
		add_emp1.typeLastname("");
		add_emp1.typeEmployeeID("783526");
		add_emp1.save();
		String expected_error="Required";
		String actual_error=add_emp1.errormsg.getText();
		Assert.assertEquals(actual_error, expected_error);
	}

	//To verify CreateLoginCredentials with Invalid Username
	@Test(priority = 15)
	public void verifyWithInvalidUsername() throws Exception {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeMiddlename("Akshay");
		add_emp1.typeLastname("narkhede");
		add_emp1.typeEmployeeID("783526");
		add_emp1.addPhoto("C:\\Users\\p.a.dnyandeo.kolte\\Pictures\\p.a.dnyandeo.kolte.jpg");
		add_emp1.createLoginDeatails();
		add_emp1.typeUsername("Prajal");
		add_emp1.typePassword("pass123");
		add_emp1.typeConfirmPassword("pass123");
		add_emp1.selectStatus();
		add_emp1.save();
		
		String expected_errmsg="Should be at least 5 characters";
		String actual_errmsg=add_emp1.invalidUsername.getText();
		Assert.assertEquals(actual_errmsg, expected_errmsg);
	}

	//To verify CreateLoginCredentials with Invalid Password
	@Test(priority = 16)
	public void verifyWithInvalidPassword() throws Exception {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeMiddlename("Akshay");
		add_emp1.typeLastname("Narkhede");
		add_emp1.typeEmployeeID("");
		add_emp1.addPhoto("C:\\Users\\p.a.dnyandeo.kolte\\Pictures\\p.a.dnyandeo.kolte.jpg");
		add_emp1.createLoginDeatails();
		add_emp1.typeUsername("Pranjal");
		add_emp1.typePassword("pass123");
		add_emp1.typeConfirmPassword("pass123");
		add_emp1.selectStatus();
		add_emp1.save();
		
		String expected_errmsg="Should have at least 7 characters";
		String actual_errmsg=add_emp1.invalidPassword.getText();
		Assert.assertEquals(actual_errmsg, expected_errmsg);
	}

	//To verify CreateLoginDetails with MismatchPassword
	@Test(priority = 17)
	public void verifyConfirmPasswordErrmsg() throws Exception {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeMiddlename("Akshay");
		add_emp1.typeLastname("Narkhede");
		add_emp1.typeEmployeeID("783526");
		add_emp1.addPhoto("C:\\Users\\HP\\Desktop\\p.a.dnyandeo.kolte.jpg");
		add_emp1.createLoginDeatails();
		add_emp1.typeUsername("Pranjal");
		add_emp1.typePassword("pass123");
		add_emp1.typeConfirmPassword("Pp1Rr2Aa3675");
		add_emp1.selectStatus();
		add_emp1.save();
		String expected_errormsg="Passwords do not match";
		String actual_errormsg=add_emp1.mismatchPassword.getText();
		Assert.assertEquals(actual_errormsg, expected_errormsg);
	}

	//To verify Upload photo with invalid format
	@Test(priority = 18)
	public void verifyWithInvalidFormat() throws Exception {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("abhilash");
		add_emp1.typeMiddlename("a");
		add_emp1.typeLastname("sagar");
		add_emp1.typeEmployeeID("023478");
		add_emp1.addPhoto("C:\\Users\\Desktop\\Pranjal.txt");
		String expected_errormsg="File type not allowed";
		String actual_errormsg=add_emp1.invalidFiletype.getText();
		Assert.assertEquals(actual_errormsg, expected_errormsg);
	}

	//To verify the employeeID with more than 10 characters
	@Test(priority=19)
		public void verifyWithInvalidEmployeeID()  {
		homepage=new Home(driver);
		loginpage=new LoginPage(driver);
		add_emp1=new AddEmployee(driver);
		loginpage.login("Admin", "admin123");
		homepage.clickOnPIM();
		add_emp1.addEmployeeTab();
		add_emp1.typeFirstname("Pranjal");
		add_emp1.typeMiddlename("Akshay");
		add_emp1.typeLastname("Narkhede");
		add_emp1.typeEmployeeID("5402543456835691");
		
		String expected_errmsg="Should not exceed 10 characters";
		String actual_errmsg=add_emp1.invalidEmployeeID.getText();
		Assert.assertEquals(expected_errmsg, actual_errmsg);
		}
	}
