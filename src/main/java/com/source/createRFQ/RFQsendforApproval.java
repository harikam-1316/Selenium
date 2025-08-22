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

public class RFQsendforApproval {

    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public RFQsendforApproval(Login login, Logout logout, WebDriverWait webDriverWait,WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }

    public void SelectSendApproval() throws InterruptedException {
        login.login("manoj.yavagal@yokogawa.com", "Admin@123");

        WebElement rfqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("ni-request-for-quotations")));
        rfqTab.click();

        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));


        WebElement freshFirstTransaction = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")
                ));
        freshFirstTransaction.click();

        WebElement view = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"techEvalution-container\"]/tr/td[8]/a")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800)");
        Thread.sleep(500);
        view.click();

        WebElement sendforapproval =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendApproval")));
        sendforapproval.click();

        WebElement Assign =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveApproverAssign")));
        Assign.click();
        WebElement yesbtn =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'bootbox-accept') and (text())='Yes']")));
        yesbtn.click();
        logout.logout();
    }
}
