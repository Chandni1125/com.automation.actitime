package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverScript;
import com.acti.utils.HelperLib;

public class TaskPage extends DriverScript {

	//****************************** Page Elements ******************************//
	
		@FindBy(xpath = "//div[@class='title ellipsis']") WebElement addNewButton;
		@FindBy(xpath = "//div[@class='item createNewCustomer']")WebElement itemNewCustomer;
		@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")WebElement customerNameTextbox;
		@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")WebElement customerDescriptionTextArea;
		@FindBy(xpath = "//div[text()='Create Customer']")WebElement crateCustomerButton;
		@FindBy(xpath = "//span[@class='innerHtml']")WebElement SuccessMsg;
		@FindBy(xpath = "(//input[@placeholder='Start typing name ...'])[1]")WebElement textboxStartTyping;
		@FindBy(xpath = "//div[@class='filteredContainer']//div[@class='title']")WebElement searchedCustomer;
        @FindBy(xpath = "//div[@class='titleEditButtonContainer']//div[@class='editButton']")WebElement buttonEdit;
		@FindBy(xpath = "//div[@class='editCustomerPanelHeader']//div[@class='action'][normalize-space()='ACTIONS']")WebElement buttonAction;
		@FindBy(xpath = "//div[@class='taskManagement_customerPanel']//div[@class='title'][normalize-space()='Delete']")WebElement buttonDelete;
		@FindBy(xpath = "//span[@class='submitTitle buttonTitle']")WebElement buttonDeletePermanently;
		
		
	//****************************** Page Initialization******************************//
			
		public TaskPage()
			{
				PageFactory.initElements(driver, this);
			}
			
	//****************************** Page Action Methods ******************************//

		public void clickDeletePermanently()
		{
			buttonDeletePermanently.click();
			HelperLib.sleep();
		}
		public void clickDeleteButton()
		{
			buttonDelete.click();
		}
		public void clickActionButton()
		{
			buttonAction.click();
		}
		public void clickEditButton()
		{
			buttonEdit.click();
			HelperLib.sleep();
		}
		public void clickSearchedCustomer()
		{
			searchedCustomer.click();
		}
		public void enterCustomerType(String customername)
		{
			textboxStartTyping.sendKeys(customername);
		}
		
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
