package com.qa.ateeb.AutomatedAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsHomePage {
	
	@FindBy(id = "j_username")
	private WebElement usernameFieldWrite;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordFieldWrite;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkinsClick;
	
	@FindBy(xpath = "//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")
	private WebElement manageUsersClick;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserClick;
	
	@FindBy(id = "people")
	private WebElement userFound;
	
	
	public void loginInput() {
		
		usernameFieldWrite.sendKeys("admin");
		passwordFieldWrite.sendKeys("42462751d9da47bb84e3c318b9fa389c");
		loginButton.click();
		
	}

	public void navToUsers() {
		
		manageJenkinsClick.click();
		manageUsersClick.click();
		
	}
	
	public void createUserLink() {
		
		createUserClick.click();
		
	}
	
	public boolean findUser() {
		
		if ((userFound.getText().contains("donkey")) 
				|| (userFound.getText().contains("Chris95")) 
				|| (userFound.getText().contains("M4TT")) 
				|| (userFound.getText().contains("DEv"))
				|| (userFound.getText().contains("matthewhunt"))) {
			
			return true;
		}
		
		else {
			
			return false;
			
		}
	
	}
}
