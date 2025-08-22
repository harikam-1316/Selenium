package com.source.createPOR;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class CreatePORnoncatalog {
    private Properties properties;
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public CreatePORnoncatalog(WebDriver driver, WebDriverWait webDriverWait, Login login, Logout logout, Properties properties) {
        this.login = login;
        this.driver = driver;
        this.properties = properties;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
    }

    public void loginButton() throws InterruptedException {
        login.login("chandrashekar.hegde@yokogawa.com","Admin@123");

        WebElement rfqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("ni-request-for-quotations")));
        rfqTab.click();

        List<WebElement> transactions = webDriverWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));


        WebElement freshFirstTransaction = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")
                ));
        freshFirstTransaction.click();

        WebElement  createPOR =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quotations-container\"]/tr/td[8]/a[3]")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800)");
        createPOR.click();

        WebElement preselectedYes = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.id("preselectedYes")));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", preselectedYes);
        preselectedYes.click();

        WebElement create =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreate")));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        create.click();

        WebElement yesbtn =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'bootbox-accept') and(text())='Yes']")));
        yesbtn.click();
        logout.logout();



    }
}
