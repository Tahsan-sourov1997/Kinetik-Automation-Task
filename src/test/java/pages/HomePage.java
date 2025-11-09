package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public String home_url = "https://automationexercise.com/";
    public By home_logo = By.xpath("//a[normalize-space()='Home']");
    public By products_btn = By.xpath("//a[@href='/products']");
    public By search_field = By.xpath("//input[@id='search_product']");
    public By search_btn = By.xpath("//i[@class='fa fa-search']");


}
