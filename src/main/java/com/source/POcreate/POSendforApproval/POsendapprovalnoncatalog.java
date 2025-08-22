package com.source.POcreate.POSendforApproval;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class POsendapprovalnoncatalog {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public  POsendapprovalnoncatalog (Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }


    public void selectSendForApproval() throws InterruptedException {
        login.login("manoj.yavagal@yokogawa.com", "Admin@123");

        Thread.sleep(2000);

        WebElement poTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("ni-purchase-orders")));
        poTab.click();
        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();
        WebElement sendforApproval = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendPO")));
        sendforApproval.click();

        WebElement submitButton = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("vendorSendMailBtnId")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", submitButton);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", submitButton);
        Thread.sleep(500);
        submitButton.click();
        Thread.sleep(1000);
        logout.logout();
    }
}


