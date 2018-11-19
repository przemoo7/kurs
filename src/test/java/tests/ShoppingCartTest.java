package tests;

import static org.testng.Assert.assertEquals;

import page.objects.*;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();


        LoginPage loginPage = new LoginPage();
        loginPage
                .clickOnFishImageButton()
                .clickOnAngelfishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckout();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

}