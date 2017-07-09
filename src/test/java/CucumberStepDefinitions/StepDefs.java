package CucumberStepDefinitions;


import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.xml.internal.ws.api.FeatureConstructor;
import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.table.AbstractTableModel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


public class StepDefs {


    PageObjects pageObjects;
    AbtPageDef abtPageDef;
    WebDriver driver;

    public StepDefs() {
        abtPageDef = new AbtPageDef();
        driver = abtPageDef.getDriver();
        pageObjects = new PageObjects();


    }
/*
    @After
    public void shutDown() {
        driver.quit();
    }
    */


    @Given("^We open (.*) qaguru$")
    public void we_open_page_qaguru_lv_qa(String page) throws Throwable {
        driver.get("http://qaguru.lv:8080/qa2/");
    }

    @When("^We press on link (.*)$")
    public void We_press_on_link_AddUser(String addUser) throws Throwable {
        driver.findElement(By.linkText(addUser)).click();
    }

    @Then("^Field with (.*) should be empty$")
    public void field_with_name_should_be_empty(String fieldName) throws Throwable {
        driver.findElement(By.name(fieldName)).equals(null);
        driver.quit();
    }



    @When("^Navigate to add score form$")
    public void Navigate_to_add_score_form() throws Throwable {
        driver.get("http://qaguru.lv:8080/qa2/addScore/162");
    }
    @Then("^Field age is empty$")
        public void Field_age_is_empty() throws Throwable {
        pageObjects.ageField(driver).equals(null);
    }


    @Then("^Field city is empty$")
        public void Field_city_is_empty() throws Throwable {
        pageObjects.cityField(driver).equals(null);
    }

    @Then("^Field country is empty$")
        public void Field_country_is_emtty() throws Throwable {
            pageObjects.countryFirld(driver).equals(null);
            }

    @Then("^Field children count is empty$")
        public void Field_children_count_is_emtty() throws Throwable {
            pageObjects.childCountField(driver).equals(null);
    }





}







