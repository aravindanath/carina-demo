package com.qaprosoft.carina.demo.gui.pages.lc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.ai.FindByAI;
import com.qaprosoft.carina.core.foundation.webdriver.ai.Label;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class SQAATPage  extends AbstractPage
{
	@FindBy(xpath="//label[@for='individual']")
	private ExtendedWebElement justMeButton;
	
	@FindBy(xpath="//label[@for='joint']")
	private ExtendedWebElement twoOfUsButton;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="First Name")
	private ExtendedWebElement firstNameTextField;
	
	@FindBy(name="lastName")
	private ExtendedWebElement lastNameTextField;
	
	@FindBy(xpath="//button[text()='Next']")
	private ExtendedWebElement nextButton;
	
	@FindBy(name="streetAddress")
	private ExtendedWebElement streetAddressTextField;
	
	@FindBy(name="city")
	private ExtendedWebElement cityTextField;
	
	@FindBy(name="state")
	private ExtendedWebElement stateTextField;
	
	@FindByAI(label=Label.TEXT_FIELD, caption="Zip")
	private ExtendedWebElement zipTextField;
	
	public SQAATPage(WebDriver driver)
	{
		super(driver);
		setPageAbsoluteURL("https://www-stage.tlcinternal.com/borrowerc/applyForALoan.action");
	}
	
	public void clickJustMe()
	{
		justMeButton.click();
		nextButton.click();
	}
	
	public void clickTwoOfUs()
	{
		twoOfUsButton.click();
		nextButton.click();
	}
	
	public void fillFirstLastName(String firstName, String lastName)
	{
		firstNameTextField.getElement().sendKeys(firstName);
		lastNameTextField.getElement().sendKeys(lastName);
		nextButton.click();
	}
	
	public void fillAddress(String street, String city, String state, String zip)
	{
		streetAddressTextField.type(street);
		zipTextField.getElement().sendKeys(zip);
		cityTextField.type(city);
		stateTextField.type(state);
		nextButton.click();
	}
	
}
