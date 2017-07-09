package CucumberStepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class PageObjects {

    public WebElement nameField(WebDriver driver) {
        return driver.findElement(By.name("name"));
    }

    public WebElement surnameField(WebDriver driver) {
        return driver.findElement(By.name("surname"));
    }

    public WebElement phoneField(WebDriver driver) {
        return driver.findElement(By.name("phone"));
    }

    public WebElement emailField(WebDriver driver) {
        return driver.findElement(By.name("email"));
    }

    public WebElement personIdField(WebDriver driver) {
        return driver.findElement(By.name("personId"));
    }

    public WebElement addUserSubmit(WebDriver driver) {
        return driver.findElement(By.cssSelector("body > div.form > form > div:nth-child(7) > input[type=\"submit\"]"));
    }

    public WebElement ageField(WebDriver driver) {return driver.findElement(By.name("age"));}

    public WebElement cityField(WebDriver driver) {
        return driver.findElement(By.name("city"));
    }

    public WebElement countryFirld(WebDriver driver) {
        return driver.findElement(By.name("country"));
    }

    public WebElement childCountField(WebDriver driver) {
        return driver.findElement(By.name("childCount"));
    }

    public WebElement scoreCountSubmit(WebDriver driver) {
        return driver.findElement(By.cssSelector("body > div > form > div:nth-child(6) > input[type=\"submit\"]"));
    }

    // TODO: How to write proper selector
    public WebElement addScore(WebDriver driver, int id) {
        return driver.findElement(By.cssSelector("div.userList > div.userEntry:last-child > div.score > a"));
    }
    public WebElement scoreResult(WebDriver driver){
        return driver.findElement(By.cssSelector("div.userEntry:nth-child(130) > div:nth-child(7)"));
    }

}

