package CucumberStepDefinitions;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import json.Client;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import services.RestConnectionService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScoreCount {

    PageObjects pageObjects;
    AbtPageDef abtPageDef;
    WebDriver driver;
    RestConnectionService restConnectionService;

    public ScoreCount() {
        abtPageDef = new AbtPageDef();
        driver = abtPageDef.getDriver();
        pageObjects = new PageObjects();
        restConnectionService = new RestConnectionService();
    }


    @Given("^Open the registration page$")
    public void Open_the_registration_page() throws Throwable {
        driver.get("http://qaguru.lv:8080/qa2/addUser");
    }

    @When("^We create new account$")
    public void We_create_new_account(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        pageObjects.nameField(driver).sendKeys(data.get(1).get(1));
        pageObjects.surnameField(driver).sendKeys(data.get(2).get(1));
        pageObjects.phoneField(driver).sendKeys(data.get(3).get(1));
        pageObjects.emailField(driver).sendKeys(data.get(4).get(1));
        pageObjects.personIdField(driver).sendKeys(data.get(6).get(1));
        pageObjects.addUserSubmit(driver).click();
    }

    @Then("^Press Add score$")
    public void Press_Add_score() throws Throwable {
        String clientJson = restConnectionService.httpGetRequest("http://qaguru.lv:8080/qa2/getClients");

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Client>>() {
        }.getType();
        ArrayList<Client> clients = gson.fromJson(clientJson, listType);

        int id = clients.size();

        WebElement addScoreButton = pageObjects.addScore(driver, id);
        addScoreButton.click();
    }


    @Then("^Filling the form$")
    public void Filling_the_form(DataTable score) throws Throwable {
        List<List<String>> data = score.raw();
        pageObjects.ageField(driver).sendKeys(data.get(1).get(1));
        pageObjects.cityField(driver).sendKeys(data.get(2).get(1));
        pageObjects.countryFirld(driver).sendKeys(data.get(3).get(1));
        pageObjects.childCountField(driver).sendKeys(data.get(4).get(1));
        pageObjects.scoreCountSubmit(driver).click();
    }



    @Then("^Check if score is correct$")
    public void Check_if_score_is_correct(DataTable score) throws Throwable {
        List<List<String>> dat = score.raw();
        int age = Integer.parseInt(dat.get(1).get(1));
        int childCount = Integer.parseInt(dat.get(4).get(1));
        boolean isRiga = Boolean.parseBoolean(dat.get(2).get(1));
        boolean isLatvia = Boolean.parseBoolean(dat.get(3).get(1));

        boolean scoreCheck = pageObjects.scoreResult(driver).getText().equals
                (calculateScore(age, childCount, isRiga, isLatvia));

        if (scoreCheck) {
            System.out.println("Score is correct");
        } else {
            System.out.println("Score is incorrect");
        }

        assert scoreCheck;


    }

    public int calculateScore(int age, int childCount, boolean isRiga, boolean isLatvia) {
        int result = 0;

        if (age <= 22) {
            result = result + 100;
        } else if (age > 22 && age < 36) {
            result = result + 300;
        } else if (age > 35 && age < 51) {
            result = result + 250;
        } else if (age > 50 && age < 61) {
            result = result + 200;
        } else if (age > 60 && age < 101) {
            result = result + 100;
        }

        if (childCount <= 0) {
            result = result + 300;
        } else if (childCount > 0 && childCount < 4) {
            result = result + 200;
        } else if (childCount > 3) {
            result = result + 100;
        }

        if (isRiga) {
            result = result + 300;
        } else {
            result = result + 100;
        }

        if (isLatvia) {
            result = result + 300;
        } else {
            result = result + 100;
        }

        return result;
    }
}





