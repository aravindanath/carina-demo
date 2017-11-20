package com.qaprosoft.carina.demo.gui.pages.lc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.ai.FindByAI;
import com.qaprosoft.carina.core.foundation.webdriver.ai.Label;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CheckRatePage  extends AbstractPage
{
	@FindBy(name="firstName")
	private ExtendedWebElement firstNameTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Last Name")
	private ExtendedWebElement lastNameTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Street Address")
	private ExtendedWebElement streetAddressTextField;
	
	@FindBy(name="city")
	private ExtendedWebElement cityTextField;
	
	@FindBy(name="state")
	private ExtendedWebElement stateSelect;
	
	@FindBy(name="zip")
	private ExtendedWebElement zipTextField;
	
	@FindBy(id="monthBirth")
	private ExtendedWebElement monthTextField;
	
	@FindBy(id="dayBirth")
	private ExtendedWebElement dayTextField;
	
	@FindBy(id="yearBirth")
	private ExtendedWebElement yearTextField;
	
	@FindBy(name="email")
	private ExtendedWebElement emailTextField;
	
	@FindBy(name="password")
	private ExtendedWebElement passwordTextField;
	
	@FindBy(name="income")
	private ExtendedWebElement incomeTextField;
	
	@FindBy(name="incomeAdditional")
	private ExtendedWebElement incomeAdditionalTextField;
	
	@FindBy(name="agreements")
	private ExtendedWebElement agreementCheckbox;
	
	@FindBy(name="submitButton")
	private ExtendedWebElement submitButton;
	
	public CheckRatePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void fillFirstLastName(String firstName, String lastName)
	{
		lastNameTextField.getElement().sendKeys(lastName);
		firstNameTextField.type(firstName);
	}
	
	public void fillAddress(String address, String city, String state, String zip)
	{
		streetAddressTextField.getElement().sendKeys(address);
		cityTextField.type(city);
		stateSelect.select(state);
		zipTextField.type(zip);
	}
	
	public void fillBirthDate(int month, int day, int year)
	{
		monthTextField.type(String.valueOf(month));
		dayTextField.type(String.valueOf(day));
		yearTextField.type(String.valueOf(year));
	}
	
	public void fillCredentials(String email, String password)
	{
		emailTextField.type(email);
		passwordTextField.type(password);
	}
	
	public void fillIncome(int income, int additional)
	{
		incomeTextField.type(String.valueOf(income));
		incomeAdditionalTextField.type(String.valueOf(additional));
	}
	
	public void submit()
	{
		agreementCheckbox.check();
		submitButton.click();
	}
}