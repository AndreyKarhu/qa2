package CucumberStepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.plugin.dom.html.HTMLSelectElement;
import sun.rmi.runtime.Log;

import java.util.List;


public class NewAccount {
    PageObjects pageObjects;
    AbtPageDef abtPageDef;
    WebDriver driver;

    public NewAccount() {
        abtPageDef = new AbtPageDef();
        driver = abtPageDef.getDriver();
        pageObjects = new PageObjects();
    }


    @Given("^Navigate to website$")
    public void Navigate_to_website() throws Throwable {
        driver.get("http://qaguru.lv:8080/qa2/addUser");
    }

    @When("^We create an account$")
    public void We_create_an_account(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        pageObjects.nameField(driver).sendKeys(data.get(1).get(1));
        pageObjects.surnameField(driver).sendKeys(data.get(2).get(1));
        pageObjects.phoneField(driver).sendKeys(data.get(3).get(1));
        pageObjects.emailField(driver).sendKeys(data.get(4).get(1));
        pageObjects.personIdField(driver).sendKeys(data.get(6).get(1));
        pageObjects.addUserSubmit(driver).click();
    }

    @Then("^Should navigate on main page$")
    public void Should_navigate_on_main_page() throws Throwable {
        Thread.sleep(1000);
      boolean mainPage = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
        if (mainPage){
            System.out.println("Registration sucsessful");}
        else {
            System.out.println("Registration failed");
        }
        assert mainPage;

    }



    @Then("^Registration failed$")
    public void Registration_failed() throws Throwable {
        Thread.sleep(1000);
        Boolean invalidEmail = pageObjects.nameField(driver).isDisplayed();
        if (invalidEmail) {
            System.out.println("Invalid Email");
        } else {
            System.out.println("Email is not invalid");
        }
            Thread.sleep(2000);
            Boolean errorEmail = driver.findElement(By.cssSelector("body > div:nth-child(1)")).isDisplayed();
            if (errorEmail) {
                System.out.println("Error shown");
            } else {
                System.out.println("Error is not displayed");
            }
        driver.quit();
        }




    @Then("^User is registered with short number$")
    public void User_firstname_is_registered_with_short_number() throws Throwable {
        Thread.sleep(4000);
     boolean shortNumber = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
        if (shortNumber) {
            System.out.println("Number could be registered ");}
        else {
            System.out.println("Number couldn't be registered ");
            }
        assert shortNumber;
        driver.quit();
    }



    @Then("^registration error should be shown$")
    public void registration_error_should_be_shown() throws Throwable {
        Thread.sleep(2000);

        boolean emptyField = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
        if (emptyField) {
            System.out.println("It is possible to register with empty fields");
        } else {
            System.out.println("It is not possible to register with empty fields");
        }
        assert emptyField;

        Thread.sleep(1000);
        boolean emptyError = driver.findElement(By.cssSelector("body > div:nth-child(1)")).isDisplayed();
        if (emptyError) {
            System.out.println("Error is visible");
        } else {
            System.out.println("Error is not visible");
        }
        driver.quit();
    }






















}











