package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;
    By allLinks = By.xpath("//div[@class='uk-container uk-margin-large-bottom']//a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public List<String> getAllHref(){
        List<String> links =  driver.findElements(allLinks).stream()
                .filter(a -> !a.getText().equals(""))
                .distinct().collect(Collectors.toList())
                .stream().map(a -> a.getAttribute("href")).collect(Collectors.toList());
        links.removeAll(Collections.singleton(null));
        return links;
    }




}
