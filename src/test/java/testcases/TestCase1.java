package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.driverSetup;

import java.util.List;

public class TestCase1 extends driverSetup {
    HomePage homePage = new HomePage();
    @Test
    public void testCase1() throws InterruptedException {
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
//        Verify all the products related to search is visible
        List<WebElement> searchedProducts = getDriver().findElements(By.xpath("//div[@class='productinfo text-center']"));

        if (searchedProducts.size() > 0) {
            System.out.println(searchedProducts.size() + " products are displayed in the search results.");
            for (WebElement product : searchedProducts) {
                Assert.assertTrue(product.isDisplayed(), "A product is not visible in the search results.");
            }
            System.out.println("All searched products are visible successfully.");
        } else {
            Assert.fail("No products found in search results!");
        }
        Thread.sleep(3000);



    }


}
