package orange;
    import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;

	public class AddEmployee extends BaseClass{

		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")WebElement addEmployee;
		@FindBy(xpath="//*[@name=\"firstName\"]")WebElement firstname;
		@FindBy(xpath="//*[@name=\"middleName\"]")WebElement middlename;
		@FindBy(xpath="//*[@name=\"lastName\"]")WebElement lastname;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")WebElement employeeID;
		@FindBy(xpath="//*[text()=\" Save \"]")WebElement saveButton;
		@FindBy(xpath="//*[text()=\" Cancel \"]")WebElement cancelButton;
		@FindBy(xpath="//*[text()=\"Create Login Details\"]")WebElement createLoginDetails;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")WebElement createLoginCheckbox;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")WebElement username;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")WebElement password;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")WebElement confirmPassword;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button/i")WebElement uploadPhoto;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label")WebElement status;
		@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6")WebElement personalDetails;
		@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")WebElement EmpInformation;
		@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/span")WebElement errormsg;
		@FindBy(xpath="//*[text()=\"Should be at least 5 characters\"]")WebElement invalidUsername;
		@FindBy(xpath = "//*[text()=\"Should have at least 7 characters\"]")WebElement invalidPassword;
		@FindBy(xpath="//*[text()=\"Passwords do not match\"]")WebElement mismatchPassword;
		@FindBy(xpath="//*[text()=\"File type not allowed\"]")WebElement invalidFiletype;
		@FindBy(xpath="//*[text()=\"Should not exceed 10 characters\"]")WebElement invalidEmployeeID;
		
		AddEmployee(WebDriver d){
			driver=d;
			PageFactory.initElements(driver, this);
		}
		public void addEmployeeTab() {
			addEmployee.click();
		}
		public void typeFirstname(String fname) {
			firstname.sendKeys(fname);
		}
		public void typeMiddlename(String mname) {
			middlename.sendKeys(mname);
		}
		public void typeLastname(String lname) {
			lastname.sendKeys(lname);
		}
		public void typeEmployeeID(String empID) {
			employeeID.sendKeys(empID);
		}
		public void createLoginDeatails() {
			createLoginCheckbox.click();
		}
		public void typeUsername(String uname) {
			username.sendKeys(uname);
		}
		public void typePassword(String pwd) {
			password.sendKeys(pwd);
		}
		public void typeConfirmPassword(String cpwd) {
			confirmPassword.sendKeys(cpwd);
		}
		public void addPhoto(String path) throws Exception {
			uploadPhoto.click();
			Robot rb=new Robot();
			rb.delay(2000);
			
			//put path to file in a clipboard
			StringSelection ss=new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			//CNTRL+V
			rb.keyPress(KeyEvent.VK_CONTROL);//Press the control key
			rb.keyPress(KeyEvent.VK_V);//Press V
			
			rb.keyRelease(KeyEvent.VK_CONTROL);//Release the control key
			rb.keyRelease(KeyEvent.VK_V);//Release V
			
			//Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		public void selectStatus() {
			//Select status1=new Select(status);
			//status1.selectByVisibleText(status_test);
			status.isSelected();
		}
		public void save() {
			saveButton.click();
		}
		public void cancel() {
			cancelButton.click();
		}
		
	}
