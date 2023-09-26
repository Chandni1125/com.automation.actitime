package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverScript;

public class TaskPage extends DriverScript {

	//****************************** Page Elements ******************************//
	
		@FindBy(xpath = "//div[@class='title ellipsis']") WebElement addNewButton;
		@FindBy(xpath = "//div[@class='item createNewCustomer']")WebElement itemNewCustomer;
		@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")WebElement customerNameTextbox;
		@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")WebElement customerDescriptionTextArea;
		@FindBy(xpath = "//div[text()='Create Customer']")WebElement crateCustomerButton;
		@FindBy(xpath = "//span[@class='innerHtml']")WebElement SuccessMsg;

	//****************************** Page Initialization******************************//
			
		public TaskPage()
			{
				PageFactory.initElements(driver, this);
			}
			
	//****************************** Page Action Methods ******************************//

		
		public String getSuccessMessageText()
		{
			return SuccessMsg.getText();
		}
		
		public void clickCustomerButton()
		{
			crateCustomerButton.click();
		}
		public void enterCustomerDescription(String customerDescription)
		{
			customerDescriptionTextArea.sendKeys(customerDescription);
		}
		public void enterCustomerName(String customerName)
		{
			customerNameTextbox.sendKeys(customerName);
		}
		
		public void clickItemNewCustomer()
		{
			itemNewCustomer.click();
		}
		
		public void clickAddNewButton()
		{
			addNewButton.click();
		}
}
