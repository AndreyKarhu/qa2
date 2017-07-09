package CucumberStepDefinitions;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import services.RestConnectionService;


import java.util.List;

public class Score {

    PageObjects pageObjects;
    AbtPageDef abtPageDef;
    WebDriver driver;
   // RestConnectionService restConnectionService;


    public Score() {
        abtPageDef = new AbtPageDef();
        driver = abtPageDef.getDriver();
        pageObjects = new PageObjects();
       // restConnectionService = new RestConnectionService();
    }


    @Given("^Open page$")
    public void open_page() throws Throwable {
        driver.get("http://qaguru.lv:8080/qa2/addScore/22");
    }


    @When("^Fill score field$")
    public void Fill_score_field(DataTable arg2) throws Throwable {
        List<List<String>> chlrn = arg2.raw();
        pageObjects.ageField(driver).sendKeys(chlrn.get(1).get(1));
        pageObjects.cityField(driver).sendKeys(chlrn.get(2).get(1));
        pageObjects.countryFirld(driver).sendKeys(chlrn.get(3).get(1));
        pageObjects.childCountField(driver).sendKeys(chlrn.get(4).get(1));
        pageObjects.scoreCountSubmit(driver).click();
    }


    @Then("^Assert if possible create acc$")
    public void Assert_if_possible_create_acc() throws Throwable {

        Thread.sleep(2000);
        boolean letterAccount = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
            if (letterAccount) {
            System.out.println("Page created");
            } else {
            System.out.println("Registration failed");
            driver.quit();
        }
    }
/*
    @Then("^Assert age could be less then minimum$")
    public void Assert_age_could_be_less_then_minimum() throws Throwable {
        Thread.sleep(2000);
            boolean young = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
            if (young) {
            System.out.println("Young age registered");
            } else {
            System.out.println("Can't register- to young");
            driver.quit();
    }}


    @Then("^Assert age could be more then maximum$")
    public void Assert_age_could_be_more_then_maximum() throws Throwable {
        Thread.sleep(2000);
            boolean old = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
            if (old) {
                System.out.println("Old age registered");
            } else {
                System.out.println("Can't register- to old");
                driver.quit();
    }}


    @Then("^Assert that city can contain unusual simbols$")
    public void Assert_that_city_can_contain_unusual_simbols () throws Throwable {
         Thread.sleep(2000);
            boolean citySym = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
            if (citySym) {
                    System.out.println("Field city registered with irregular symbols");
            } else {
                System.out.println("Can't register city");
                driver.quit();
                }}


    @Then("^Assert that country can contain unusual simbols$")
    public void Assert_that_country_can_contain_unusual_simbols() throws Throwable {
        Thread.sleep(2000);
            boolean countrySym = driver.getCurrentUrl().equals("http://qaguru.lv:8080/qa2/");
            if (countrySym) {
                    System.out.println("Field country registered with irregular symbols");
            } else {
                    System.out.println("Can't register country");
                    driver.quit();
                }}*/
}