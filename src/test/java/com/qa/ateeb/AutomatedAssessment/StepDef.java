package com.qa.ateeb.AutomatedAssessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.ateeb.AutomatedAssessment.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.ScreenshotMethod;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDef {
	
	WebDriver driver;
	
	public static ExtentReports report; //REPORTING
	public ExtentTest test; //REPORTING
	public ExtentTest test2; //REPORTING
	public ExtentTest test3; //REPORTING
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriverRoot);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(Constants.websiteURL);
		
		test = TestRunner.report.startTest("Task One Test"); //REPORTING
		
		test.log(LogStatus.INFO, "Testing Create User Page ..."); //REPORTING
		
		JenkinsHomePage homePage = PageFactory.initElements(driver, JenkinsHomePage.class);
		homePage.loginInput();
		homePage.navToUsers();
		homePage.createUserLink();
		
		if (driver.getTitle().equals("Create User [Jenkins]")) { //REPORTING
			
			test.log(LogStatus.PASS, "Successful Create User Page Was Found");
			
		}
		
		else { //REPORTING
			
			test.log(LogStatus.FAIL, "Unsuccessful! Create User Page Was NOT Correct");
			
		}
		
		assertEquals("Navigated to incorrect page", "Create User [Jenkins]", driver.getTitle());
		
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test.log(LogStatus.INFO, "Inputting New User Information ..."); //REPORTING
		
		JenkinsUserPage createUserPage = PageFactory.initElements(driver, JenkinsUserPage.class);
		createUserPage.fillForm();
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		ScreenshotMethod.screenshot(driver);
		
		JenkinsUserPage createUserPage = PageFactory.initElements(driver, JenkinsUserPage.class);
		createUserPage.clickCreateUser();
		
		test.log(LogStatus.INFO, "Checking Correct Page Status ..."); //REPORTING
		
		if (driver.getTitle().equals("Users [Jenkins]")) { //REPORTING
			
			test.log(LogStatus.PASS, "Successful Users Page Was Found");
			
		}
		
		else { //REPORTING
			
			test.log(LogStatus.FAIL, "Unsuccessful! Users Page Was NOT Correct");
			
		}
		
		assertEquals("Navigated to incorrect page", "Users [Jenkins]", driver.getTitle());
		
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test.log(LogStatus.INFO, "Checking To See If User Has Been Created ..."); //REPORTING
		
		JenkinsUserCreatedPage userCreatedPage = PageFactory.initElements(driver, JenkinsUserCreatedPage.class);
		
		userCreatedPage.findUser();
		
		if (userCreatedPage.findUser()) { //REPORTING
			
			test.log(LogStatus.PASS, "Successful User 'donkey' Was Found");
			
		}
		
		else { //REPORTING
			
			test.log(LogStatus.FAIL, "Unsuccessful! User 'donkey' was NOT Found");
			
		}
		
		TestRunner.report.endTest(test);
		
		ScreenshotMethod.screenshot(driver);
		
		Thread.sleep(1000);
		
		Assert.assertTrue(userCreatedPage.findUser());
			
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test2 = TestRunner.report.startTest("Task Two Test"); //REPORTING
		
		test2.log(LogStatus.INFO, "Sending Through Each User To Be Created ..."); //REPORTING
		
		JenkinsUserPage createUserPage = PageFactory.initElements(driver, JenkinsUserPage.class);
		createUserPage.sendKeysToSearch(arg1, arg2, arg3, arg4, arg5);
		
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		test2.log(LogStatus.INFO, "Checking For The User ..."); //REPORTING
		
		JenkinsUserCreatedPage userCreatedPage = PageFactory.initElements(driver, JenkinsUserCreatedPage.class);
		
		userCreatedPage.findUser();
		
		if (userCreatedPage.findUser()) { //REPORTING
			
			test2.log(LogStatus.PASS, "Successful User Was Found");
			
		}
		
		else { //REPORTING
			
			test2.log(LogStatus.FAIL, "Unsuccessful! User was NOT Found");
			
		}
		
		ScreenshotMethod.screenshot(driver);
		
		TestRunner.report.endTest(test2);
		
		Thread.sleep(1000);
		
		Assert.assertTrue(userCreatedPage.findUser());
		
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(Constants.websiteURL);
		
		test3 = TestRunner.report.startTest("Task Three Test"); //REPORTING
		
		JenkinsHomePage homePage = PageFactory.initElements(driver, JenkinsHomePage.class);
		homePage.loginInput();
		homePage.navToUsers();
		
		test3.log(LogStatus.INFO, "Testing View User Page ..."); //REPORTING
		
		homePage.findUser();
		
		if (homePage.findUser()) { //REPORTING
			
			test3.log(LogStatus.PASS, "Successful User Was Found");
			
		}
		
		else { //REPORTING
			
			test3.log(LogStatus.FAIL, "Unsuccessful! User was NOT Found");
			
		}
		
		Assert.assertTrue(homePage.findUser());
		
		assertEquals("Navigated to incorrect page", "Users [Jenkins]", driver.getTitle());
		
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		JenkinsUserCreatedPage userCreatedPage = PageFactory.initElements(driver, JenkinsUserCreatedPage.class);
		
		test3.log(LogStatus.INFO, "Checking User Page ..."); //REPORTING
		
		userCreatedPage.findUser();
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		JenkinsUserCreatedPage userCreatedPage = PageFactory.initElements(driver, JenkinsUserCreatedPage.class);
		
		userCreatedPage.clickUser();
		
		test3.log(LogStatus.INFO, "Clicked On Specific User Page ..."); //REPORTING
		
		TestRunner.report.endTest(test3);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		TestRunner.report.flush();
		Thread.sleep(2000);
		driver.quit();
		
	}

}
