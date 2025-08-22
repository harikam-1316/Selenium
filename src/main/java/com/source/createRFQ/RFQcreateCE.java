package com.source.createRFQ;

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

public class RFQcreateCE {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public RFQcreateCE(Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }

    public void SelectvendorLogin() throws InterruptedException {
        login.login("chandrashekar.hegde@yokogawa.com", "Admin@123");

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
        WebElement createCE =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateCE")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800)");
        createCE.click();

        WebElement dropdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selectionStatus_2156\"]")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yes");

        WebElement submitbtn =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitCE")));
        submitbtn.click();


        WebElement submitButton1 = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'bootbox-accept')]")));
        submitButton1.click();
        System.out.println("clicked Submit button");
        Thread.sleep(2000);
        logout.logout();

    }
}