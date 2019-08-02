package stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;

import static stepdefinitions.Hooks.driver;

public class Utility {

    public static void waitForPageLoad(){
        while(!((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
