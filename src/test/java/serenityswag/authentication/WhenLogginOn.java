package serenitySwag.authentication;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLogginOn {

    @Managed()
    WebDriver driver;

    @Test
    public void userCanLongOnViaTheHomePage(){
        driver.get("https://www.saucedemo.com");

        //Login
        driver.findElement(By.cssSelector("input[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[data-test=\"login-button\"]")).click();

        //should see product catalog
        assertThat( driver.findElement(By.cssSelector(".title")).getText())
                .isEqualToIgnoringCase("Products");
    }

}
