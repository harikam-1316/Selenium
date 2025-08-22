package com.source.invoice.orderschedule;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderscheduleApprovenonctlog {
    private WebDriver driver;
    private WebDriverWait wait;
    private Login login;
    private Logout logout;

    public OrderscheduleApprovenonctlog (WebDriver driver, WebDriverWait wait, Login login, Logout logout) {

        this.driver = driver;
        this.wait = wait;
        this.login = login;
        this.logout = logout;
    }
    public void SelectapproveOrderschedule() throws InterruptedException {
        login.login(" chandrashekar.hegde@yokogawa.com", "Admin@123");
        WebElement myApprovalsTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("ni-my-approvals")));
        myApprovalsTab.click();
        System.out.println("Clicked on 'My Approvals' tab");
        Thread.sleep(2000);

        List<WebElement> transactions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();
        WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnApprove")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", approveButton);
        approveButton.click();
        System.out.println("Clicked Approve button successfully");

        WebElement submitButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'bootbox-accept')]")));
        submitButton1.click();
        System.out.println("clicked Submit button");
        Thread.sleep(2000);
        logout.logout();
        Thread.sleep(500);

    }
}

