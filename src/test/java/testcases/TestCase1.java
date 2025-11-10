package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.driverSetup;

public class TestCase1 extends driverSetup {
    HomePage homePage = new HomePage();
    @Test
    public void testCase1(){
        homePage.loadAnWebPage(homePage.home_url);
        // verify homepage is visible
        WebElement logo = homePage.getElement(homePage.home_logo);
        if (logo.isDisplayed()) {
            System.out.println("Home page is visible successfully.");
        } else {
            System.out.println("Home page is not visible.");
        }
        homePage.clickElement(homePage.products_btn);
//        Verify user navigate to product page successfully
        String expectedUrl = "https://automationexercise.com/products";
        String actualUrl = getDriver().getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("User navigated to Products page successfully.");
        } else {
            System.out.println("Navigation failed. Current URL: " + actualUrl);
        }
        homePage.writeElement(homePage.search_field, "Tshirts");
        homePage.clickElement(homePage.search_btn);
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(homePage.getElement(homePage.view_product)).build().perform();
        WebElement visible_products = homePage.getElement(homePage.search_products);
        // verify visible search product successfully
        if (visible_products.isDisplayed()) {
            System.out.println("search product is visible successfully.");
        } else {
            System.out.println("search product is not visible.");
        }








    }


}
