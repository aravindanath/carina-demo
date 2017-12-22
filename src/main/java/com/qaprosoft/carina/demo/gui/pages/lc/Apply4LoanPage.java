package com.qaprosoft.carina.demo.gui.pages.lc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class Apply4LoanPage  extends AbstractPage
{
	@FindBy(id="loanAmount")
	private ExtendedWebElement loanAmountTextField;
	
	@FindBy(id="loanPurpose")
	private ExtendedWebElement loanPurposeSelect;
	
	@FindBy(id="creditScore")
	private ExtendedWebElement creditScopeSelect;
	
	@FindBy(id="master_getPersonalInfo")
	private ExtendedWebElement checkRateButton;

	public Apply4LoanPage(WebDriver driver)
	{
		super(driver);
		setPageAbsoluteURL("https://www-stage.tlcinternal.com/borrowerc/applyForALoan.action");
	}
	
	public SQAATPage checkYourRate(int amount, String purpose, String scope)
	{
		loanAmountTextField.type(String.valueOf(amount));
		loanPurposeSelect.select(purpose);
		creditScopeSelect.select(scope);
		checkRateButton.click();
		return new SQAATPage(driver);
	}
}
