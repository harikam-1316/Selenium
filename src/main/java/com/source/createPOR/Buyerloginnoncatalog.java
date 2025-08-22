package com.source.createPOR;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

import static com.constants.requisitions.create.PRCreate.*;
import static com.constants.requisitions.create.PRCreate.getassignbuyer;

public class Buyerloginnoncatalog {
    private Properties properties;
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public Buyerloginnoncatalog(WebDriver driver, WebDriverWait webDriverWait, Login login, Logout logout, Properties properties) {
        this.login = login;
        this.driver = driver;
        this.properties = properties;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
    }

    public void loginButton() throws InterruptedException {
        login.login("chandrashekar.hegde@yokogawa.com", "Admin@123");

        WebElement reqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(REQUISITION_NAVIGATION_BAR)));
        reqTab.click();
        List<WebElement> transactions = webDriverWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));


        WebElement freshFirstTransaction = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")
                )
        );
        freshFirstTransaction.click();


        WebElement assignBuyerButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnAssignUser")));  // Replace with actual locator
        assignBuyerButton.click();
    }
    public void selectBuyerAndAssign() throws InterruptedException {
        String buyerName = properties.getProperty("buyerName");

        WebElement buyerNamedropdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ASSIGN_BUYER_DROPDOWN_XPATH)));
        buyerNamedropdown.click();
        System.out.println("Clicked on buyer dropdown");

        WebElement buyerNamesearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ASSIGN_BUYER_SEARCH_XPATH)));
        buyerNamesearchBox.sendKeys(buyerName);
        Thread.sleep(1000);

        String assignbuyerXpath = getassignbuyer(buyerName);
        WebElement correctassignbuyerOption = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(assignbuyerXpath)));
        correctassignbuyerOption.click();
        System.out.println("Selected buyer:'chandrashekar.hegde@yokogawa.com' " + buyerName);

        WebElement assignButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(("saveBGAssign"))));
        assignButton.click();
        System.out.println("Clicked Assign button");
        Thread.sleep(2000);

        WebElement createRFQButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateRFQ")));
        createRFQButton.click();
        System.out.println("Clicked on Create RFQ button");

        WebElement createBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreate")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        Thread.sleep(1000);
        createBtn.click();

        System.out.println("Scrolled down and clicked Create button");

        WebElement yesButton = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div/div/div[2]/button[1]")));
        yesButton.click();

        logout.logout();
    }


}




