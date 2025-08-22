package com.source.vendor.inspection;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Inspectionnoncatalog {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public Inspectionnoncatalog(Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }

    public void selectVendorLogin() throws InterruptedException {
        login.login("sales@nandipowertronics.com", "Admin@123");
        WebElement OrderSchedules = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarVerticalMenu\"]/div/div/div[4]/a/span")));
        OrderSchedules.click();
        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();
        WebElement sendInspection = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendForInspection")));
        sendInspection.click();
        WebElement Attackfile = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("formFilePreupload1")));
        Attackfile.sendKeys("C:\\Users\\Harika\\Downloads\\sample-1.pdf");
//        Attackfile.click();
        WebElement yesButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveSendInspection")));
        yesButton.click();

        logout.logout();

    }


}

