package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public String home_url = "https://automationexercise.com/";
    public By home_logo = By.xpath("//a[normalize-space()='Home']");
    public By products_btn = By.xpath("//a[@href='/products']");
    public By search_field = By.xpath("//input[@id='search_product']");
    public By search_btn = By.xpath("//i[@class='fa fa-search']");
    public By search_products = By.xpath("//h2[normalize-space()='Searched Products']");
    public By view_product = By.xpath("//a[normalize-space()='View Product']");
    public By products_detail1 = By.xpath("//b[normalize-space()='Availability:']");
    public By products_detail2 = By.xpath("//b[normalize-space()='Condition:']");
    public By quantity = By.xpath("//input[@id='quantity']");
    public By add_card_btn = By.xpath("//button[normalize-space()='Add to cart']");
    public By view_card_btn = By.xpath("//u[normalize-space()='View Cart']");
    public By quantity_number = By.xpath("//button[normalize-space()='4']");



}
