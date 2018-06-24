package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_DAY = "//span[@class='_5k_4']/span/select[2]";
    public static final String XPATH_SELECT_MONTH = "//span[@class='_5k_4']/span/select[1]";
    public static final String XPATH_SELECT_YEAR = "//span[@class='_5k_4']/span/select[3]";

    public static void main (String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectDayCombo = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select birthDay = new Select(selectDayCombo);
        birthDay.selectByIndex(1);

        WebElement selectMonthCombo = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select birthMonth = new Select(selectMonthCombo);
        birthMonth.selectByVisibleText("Feb");


        WebElement selectYearCombo = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select birthYear = new Select(selectYearCombo);
        birthYear.selectByIndex(25);
    }
}
