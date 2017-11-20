/*
 * Copyright 2013-2017 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.lc.Apply4LoanPage;
import com.qaprosoft.carina.demo.gui.pages.lc.CheckRatePage;
import com.qaprosoft.carina.demo.gui.pages.lc.SQAATPage;

/**
 * This sample shows how to use Alice AI to find UI elements.
 * 
 * @author akhursevich
 */
public class AISampleTest extends AbstractTest
{	
	@Test(description = "JIRA#AUTO-0011")
	@MethodOwner(owner = "akhursevich")
	public void testApply4LoanNew()
	{
		Apply4LoanPage apply4LoanPage = new Apply4LoanPage(getDriver());
		apply4LoanPage.open();
		getDriver().manage().addCookie(new Cookie("xp", "PL_PI1_QAAT_v4.C"));
		
		SQAATPage sqaat = apply4LoanPage.checkYourRate(10000, "Business", "Good (660-720)");
		sqaat.clickTwoOfUs();
		sqaat.fillFirstLastName("John", "Doe");
		sqaat.fillAddress("Test", "New York", "NY", "99000");
	}
	
	@Test(description = "JIRA#AUTO-0012")
	@MethodOwner(owner = "akhursevich")
	public void testApply4LoanOld()
	{
		Apply4LoanPage apply4LoanPage = new Apply4LoanPage(getDriver());
		apply4LoanPage.open();
		getDriver().manage().addCookie(new Cookie("xp", "PL_PI1_QAAT_v4.Console"));
		apply4LoanPage.checkYourRate(10000, "Business", "Good (660-720)");
		
		CheckRatePage checkRatePage = new CheckRatePage(getDriver());
		checkRatePage.fillFirstLastName("John", "Doe");
		checkRatePage.fillAddress("Green", "San Francisco", "California", "94015");
		checkRatePage.fillBirthDate(12, 3, 1982);
		checkRatePage.fillCredentials(StringGenerator.generateEmail(), StringGenerator.generateNumeric(8) + "Az!");
		checkRatePage.fillIncome(300000, 50000);
		checkRatePage.submit();
	}
}