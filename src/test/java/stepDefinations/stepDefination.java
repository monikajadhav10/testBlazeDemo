package stepDefinations;



import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import resources.Base;
import resources.Browser;

@RunWith(Cucumber.class)
public class stepDefination extends Base {

    @Given("^I successfully launch blazedemo \"([^\"]*)\"$")
    public void launchBlazedemo(String strArg1) throws Throwable {
    	driver = initializeDriver();
    	driver.get(prop.getProperty("url"));
    	
    }

    @When("^I click \"([^\"]*)\" button$")
    public void clickButton(String strArg1) throws Throwable {
    	By button =By.xpath("//input[@value='"+strArg1+"']");
		 driver.findElement(button).click();
    }

    @Then("^I fill \"([^\"]*)\" as \"([^\"]*)\"$")
    public void fillCustomerInfo(String strArg1, String strArg2) throws Throwable {
       
    	By field = By.xpath("//input[@name='"+strArg1+"']");
    	WebElement findfield = driver.findElement(field);
    	findfield.sendKeys(strArg2);
    	
    }

    @And("^I select departure city as \"([^\"]*)\"$")
    public void selectFrom(String strArg1) throws Throwable {
       Select departureCity = new Select(driver.findElement(By.name("fromPort")));
       departureCity.selectByVisibleText(strArg1);
    }
    
    @And("^I select destination city as \"([^\"]*)\"$")
    public void selectTo(String strArg1) throws Throwable {
    	Select destinationCity = new Select(driver.findElement(By.name("toPort")));
    	destinationCity.selectByVisibleText(strArg1);
     }
    

    @And("^I verify confirmation message as \"([^\"]*)\"$")
    public void i_verify_confirmation_message_as_something(String strArg1) throws Throwable {
    	By text = By.xpath("//*[contains(text(),'"+strArg1+"')]");
    	WebElement confirmationText = driver.findElement(text);
    	confirmationText.getText().contains(strArg1);
    	Browser.teardown();
    	
    }

}
