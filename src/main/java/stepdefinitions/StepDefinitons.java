package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobject.HomePage;
import static stepdefinitions.Hooks.driver;


public class StepDefinitons {

    HomePage homePage;

    @Given("^I visit developer here website$")
    public void iVisitWebsite(){
        driver.get("https://developer.here.com/documentation");
        homePage = new HomePage(driver);
    }

    @And("^I Navigate to all the links via Service and check response code is (\\d+)$")
    public void iCollectAllTheLinksAndNavigateViaService(int responseCode){
        homePage.getAllHref().stream().forEach(a -> {
            Assert.assertEquals(RestAssured.get(a).getStatusCode(), responseCode);
            System.out.println("Response Code is 200 for link : " + a);
        });
    }

    @And("^I Navigate to all the links via UI and check UI elements are rendered properly$")
    public void iCollectAllTheLinksAndNavigateViaUI(){
        homePage.getAllHref().forEach(a -> {
            try {
                driver.findElement(By.xpath("//a[contains(@href, '" + a.split("here.com/")[1] + "')]")).click();
            }
            catch (NoSuchElementException e){
                driver.findElement(By.xpath("//a[contains(@href, '" + a.split("documentation")[1] + "')]")).click();
            }
            Utility.waitForPageLoad();
            Assert.assertEquals(true, driver.findElement(By.xpath("//li[@class='top-level']/a[text()='Sign in']")).isDisplayed());
            System.out.println("Navigated to the page : " + a);
            driver.get("https://developer.here.com/documentation");
            Utility.waitForPageLoad();
        });
    }
}