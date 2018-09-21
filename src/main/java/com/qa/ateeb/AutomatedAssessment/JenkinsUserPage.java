package com.qa.ateeb.AutomatedAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsUserPage {
	
	@FindBy(id = "username")
	private WebElement usernameWrite;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordWrite;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement password2Write;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullNameWrite;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement emailWrite;
	
	
	@FindBy(xpath = "//*[@id=\"yui-gen3-button\"]")
	private WebElement createUserButton;
	
	
	public void fillForm() {
		
		usernameWrite.sendKeys("donkey");
		passwordWrite.sendKeys("foxxy");
		password2Write.sendKeys("foxxy");
		fullNameWrite.sendKeys("Donkey Kong");
		emailWrite.sendKeys("dddkkk@hotmail.co.uk");
		
	}
	
	public void clickCreateUser() {
		
		createUserButton.click();
		
	}
	
	public void sendKeysToSearch(String arg1, String arg2, String arg3, String arg4, String arg5) {
		
		usernameWrite.sendKeys(arg1);
		passwordWrite.sendKeys(arg2);
		password2Write.sendKeys(arg3);
		fullNameWrite.sendKeys(arg4);
		emailWrite.sendKeys(arg5);
		
	}
	
}
