package com.source.createRFQ;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RFQ {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public RFQ(Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }
    public void Selectquoatationphase() throws InterruptedException {
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

        WebElement Readyforevalutation =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnReadyForEvalution")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
        Readyforevalutation.click();

        WebElement yesbutton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'bootbox-accept') and (text())='Yes']")));
        Thread.sleep(500);
        yesbutton.click();
        logout.logout();
    }
    public void Technicalevaluation() throws InterruptedException {
        login.login("manoj.yavagal@yokogawa.com","Admin@123");

        WebElement rfqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("ni-request-for-quotations")));
        rfqTab.click();

        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                       By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));


        WebElement freshFirstTransaction = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")
                ));
        freshFirstTransaction.click();

        WebElement createTE =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateTE")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800)");
        createTE.click();

        WebElement vendorOption = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='vendor-1771']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vendorOption);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(vendorOption)).click();


        WebElement Evaluate = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreate")));
        Evaluate.click();
        WebElement submitbtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
        submitbtn.click();
        logout.logout();

    }
}
