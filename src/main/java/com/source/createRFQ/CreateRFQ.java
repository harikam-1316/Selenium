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
import java.util.Properties;

import static com.constants.requisitions.create.PRCreate.*;
import static com.constants.requisitions.create.PRCreate.getVendor;


public class CreateRFQ {
    private Properties properties;
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public CreateRFQ(WebDriver driver, WebDriverWait webDriverWait, Login login, Logout logout, Properties properties) {
        this.login = login;
        this.driver = driver;
        this.properties = properties;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
    }

    public void loginButton() throws InterruptedException {
        login.login("chandrashekar.hegde@yokogawa.com", "Admin@123");

        WebElement rfqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(REQUEST_FOR_QUOTATION_ID)));
        rfqTab.click();
        List<WebElement> transactions = webDriverWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));


        WebElement freshFirstTransaction = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")
                ));
        freshFirstTransaction.click();

        WebElement invitevendor = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addRequestForQuotationVendors")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200);");
        invitevendor.click();
    }
    public void Selectvendor(){
           try {
        String vendorName = properties.getProperty("vendorName");
        WebElement vendorDropdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(VENDORNAME_DROPDOWN_XPATH)));
        vendorDropdown.click();

        WebElement vendorSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(VENDORNAME_SEARCH_BOX_XPATH)));
        vendorSearchBox.sendKeys(vendorName);

        Thread.sleep(3000);
        String vendor = getVendorName(vendorName);
        WebElement correctVendorOption = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(vendor)));
        correctVendorOption.click();
        System.out.println("✅ Vendor 'NANDI' selected successfully.");

    } catch (Exception e) {

        System.out.println("❌ Error selecting vendor: " + e.getMessage());

           }
       WebElement addbutton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveRequestForQuotationVendor")));
           addbutton.click();

       WebElement submitbutton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("vendorSendMailBtnId")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitbutton);
        submitbutton.click();
        logout.logout();
    }

}
