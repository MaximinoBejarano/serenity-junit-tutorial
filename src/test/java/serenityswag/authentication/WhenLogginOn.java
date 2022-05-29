package serenityswag.authentication;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static serenityswag.authentication.actions.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenLogginOn extends UIInteractionSteps {

    @Managed()
    WebDriver driver;

    @Steps
    LoginActions login;
    InventoryPage inventoryPage;

    @Test
    public void userCanLongOnViaTheHomePage(){

        login.as(STANDARD_USER);
        //Should see product catalog
        Serenity.reportThat("The inventary page should be displayed with the correct title",
        ()-> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
        );


    }

}
