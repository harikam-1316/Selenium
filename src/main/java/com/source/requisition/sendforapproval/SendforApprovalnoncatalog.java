package com.source.requisition.sendforapproval;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.constants.requisitions.create.PRCreate.REQUISITION_NAVIGATION_BAR;

public class SendforApprovalnoncatalog {

    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;

    public SendforApprovalnoncatalog(Login login, Logout logout, WebDriverWait webDriverWait) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
    }

    public void SelectSendApproval() throws InterruptedException {

        login.login("manoj.yavagal@yokogawa.com", "Admin@123");

        Thread.sleep(2000);

        WebElement reqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(REQUISITION_NAVIGATION_BAR)));
        reqTab.click();

        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();

        WebElement sendforApproval = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendApproval")));
        sendforApproval.click();

        WebElement yesButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'bootbox-accept') and normalize-space(text())='Yes']")));
        yesButton.click();

        Thread.sleep(1000);
        logout.logout();
    }
}


