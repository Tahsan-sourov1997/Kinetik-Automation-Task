package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.driverSetup;

public class TestCase2 extends driverSetup {
    HomePage homePage = new HomePage();
    @Test
    public void testCase2() throws InterruptedException {
        homePage.loadAnWebPage(homePage.home_url);
        // verify homepage is visible
        WebElement logo = homePage.getElement(homePage.home_logo);
        if (logo.isDisplayed()) {
            System.out.println("Home page is visible successfully.");
        } else {
            System.out.println("Home page is not visible.");
        }
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(homePage.getElement(homePage.view_product)).build().perform();
        homePage.clickElement(homePage.view_product);
//        verify product details visible successfully
        WebElement details1 = homePage.getElement(homePage.products_detail1);
        if (details1.isDisplayed()) {
            System.out.println("product detail visible successfully.");
        } else {
            System.out.println("product detail is not visible.");
        }
//        Increase quantity to 4
        WebElement quantity_box = homePage.getElement(homePage.quantity);
        quantity_box.clear();
        quantity_box.sendKeys("4");
//        Click add card button
        homePage.clickElement(homePage.add_card_btn);
//        view cart button
        homePage.clickElement(homePage.view_card_btn);
        WebElement quantity = homePage.getElement(homePage.quantity_number);
//        Verify product is displayed card button with exact number
        String actual_quantity = quantity.getText();
        String expected_quantity = "4";
        Assert.assertEquals(expected_quantity, actual_quantity, "Product name mismatch in cart!");
        System.out.println("Product '" + actual_quantity + "' is displayed in the cart.");
        Thread.sleep(3000);



    }
}
