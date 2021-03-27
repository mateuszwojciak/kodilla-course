package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]";
    public static final String XPATH_CREATE_ACCOUNT = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a";
    public static final String XPATH_SET_NAME = "//*[@id=\"u_4_b_+5\"]";
    public static final String XPATH_SET_SURNAME = "//*//*[@id=\"u_4_d_St\"]";
    public static final String XPATH_SET_PHONE_NUMBER = "//*[@id=\"u_4_g_MN\"]";
    public static final String XPATH_SET_PASSWORD = "//*[@id=\"password_step_input\"]";
    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_4\")]/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_4\")]/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"_5k_4\")]/select[3]";
    public static final String XPATH_SELECT_SEX = "//*[@id=\"u_4_o_m0\"]/span[2]/label";
    public static final String XPATH_SET_ACCOUNT = "//*[@id=\"u_4_s_cl\"]";


    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement searchField = driver.findElement(By.xpath(XPATH_COOKIES));
        searchField.click();

        WebElement searchField2 = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        searchField2.click();

        while (!driver.findElement(By.xpath(XPATH_SET_NAME)).isDisplayed());

        WebElement searchField3 = driver.findElement(By.xpath(XPATH_SET_NAME));
        searchField3.sendKeys("Name");

        WebElement searchField4 = driver.findElement(By.xpath(XPATH_SET_SURNAME));
        searchField4.sendKeys("Surname");

        WebElement searchField5 = driver.findElement(By.xpath(XPATH_SET_PHONE_NUMBER));
        searchField5.sendKeys("123456789");

        WebElement searchField6 = driver.findElement(By.xpath(XPATH_SET_PASSWORD));
        searchField6.sendKeys("Password");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selector1 = new Select(selectDay);
        selector1.selectByIndex(1);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selector2 = new Select(selectMonth);
        selector2.selectByIndex(1);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selector3 = new Select(selectYear);
        selector3.selectByIndex(1);

        WebElement selectSex = driver.findElement(By.xpath(XPATH_SELECT_SEX));
        selectSex.click();

        WebElement setAccount = driver.findElement(By.xpath(XPATH_SET_ACCOUNT));
        setAccount.click();

    }
}