package com.source.vendor.inspectionlogin;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Vendorloginnoncatalog {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public Vendorloginnoncatalog(Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }

    public void selectVendorLogin() throws InterruptedException {
        login.login("sales@nandipowertronics.com", "Admin@123");

        Thread.sleep(2000);
        WebElement poTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navbarVerticalMenu']//div[3]/a/span")));
        poTab.click();
        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();

        WebElement createOrderScheduleBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateOR")));
        createOrderScheduleBtn.click();

        WebElement scheduleDateInput = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='OrderShedule']//div[2]/div[1]/input[2]")));
        Thread.sleep(1000);
        scheduleDateInput.click();
        String dayXpath = "//span[@class='flatpickr-day today']";
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath))).click();

        WebElement submitButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreate")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        submitButton.click();


        WebElement yesButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div[2]/button[1]")));
        yesButton.click();
        logout.logout();

    }
}


