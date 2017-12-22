package com.qaprosoft.carina.demo.gui.pages.lc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.ai.FindByAI;
import com.qaprosoft.carina.core.foundation.webdriver.ai.Label;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CheckRatePage  extends AbstractPage
{
	@FindByAI(label=Label.TEXT_FIELD, caption="First Name")
	private ExtendedWebElement firstNameTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Last Name")
	private ExtendedWebElement lastNameTextField;
	
	@FindBy(name="streetAddress")
	private ExtendedWebElement streetAddressTextField;
	
	@FindBy(name="city")
	private ExtendedWebElement cityTextField;
	
	@FindByAI(label=Label.SELECT, caption="State")
	private ExtendedWebElement stateSelect;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Zip Code")
	private ExtendedWebElement zipTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Date of Birth")
	private ExtendedWebElement monthTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="DD")
	private ExtendedWebElement dayTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="YYYY")
	private ExtendedWebElement yearTextField;
	
	@FindBy(name="email")
	private ExtendedWebElement emailTextField;
	
	@FindBy(name="password")
	private ExtendedWebElement passwordTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Yearly Individual Income")
	private ExtendedWebElement incomeTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="(Optional)")
	private ExtendedWebElement incomeAdditionalTextField;
	
	@FindByAI(label=Label.CHECKBOX, caption="")
	private ExtendedWebElement agreementCheckbox;
	
	@FindBy(name="submit-button")
	private ExtendedWebElement submitButton;
	
	public CheckRatePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void fillFirstLastName(String firstName, String lastName)
	{
		streetAddressTextField.type(" ");
		firstNameTextField.type(firstName);
		lastNameTextField.type(lastName);
	}
	
	public void fillAddress(String address, String city, String state, String zip)
	{
		streetAddressTextField.type(address);
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