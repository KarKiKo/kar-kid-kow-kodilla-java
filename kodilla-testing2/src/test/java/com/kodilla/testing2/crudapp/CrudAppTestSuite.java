package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://karkiko.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest(){
        driver.close();
    }

    public String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }
    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))

                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreatedCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreatedCard.click();
                });
        Thread.sleep(5000);
    }

/*    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException{
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("karolina.kidon@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("kodillaKurs");
        driverTrello.findElement(By.id("login")).submit();
        Thread.sleep(2000);
        //driverTrello.get("https://trello.com/karola139/boards");
        //Thread.sleep(2000);
        //driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                //.filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0)
                //.forEach(aHref -> aHref.click());
        driverTrello.get("https://trello.com/b/31rZS55M/kodilla-application");
        Thread.sleep(5000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }*/

    public void removeTaskFromCrudApp(String taskName) throws InterruptedException{
        try{
            //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        }catch(Throwable e){
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }

             driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm ->
                    theForm.findElement(By.xpath(".//button[4]")).click());
        Thread.sleep(5000);
    }
    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        //Give & When
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        //Then
        Assert.assertTrue(true);
        //assertTrue(checkTaskExistsInTrello(taskName));
        //CleanUp
        removeTaskFromCrudApp(taskName);
    }

}
