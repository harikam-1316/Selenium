package com.source.nonCatalogcreate;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;



public class InviteGuestVendor {
   private WebDriver page;
   private Properties properties;
   private WebDriver webDriver;
   private Login login;
   private WebDriverWait wait;
   private Logout logout;
   private WebDriverWait webDriverWait;

    public InviteGuestVendor(WebDriver page,WebDriverWait wait,Login login,Logout logout,WebDriver webDriver,Properties properties) {
        this.page = page;
        this.webDriver = webDriver;
        this.login = login;
        this.properties = properties;
        this.wait = wait;
        this.logout = logout;
        this.webDriverWait = wait;

    }

    public void GuestVendorInvite() throws InterruptedException {
        try {
            String emailId = properties.getProperty("InviteGuestEmail");
            String password = properties.getProperty("password");

            login.login(emailId, password);
        } catch (Exception exception) {
            System.out.println("Error in Requester Login Function");
        }
        String guestEmail = "testvendor@mailinator.com";

        page.findElement(By.xpath("//span[contains(text(),'Request For Quotations')]")).click();Thread.sleep(2000);
        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();
        JavascriptExecutor js1 = (JavascriptExecutor) page;
        js1.executeScript("window.scrollBy(0, 1800)");Thread.sleep(1000);
        page.findElement(By.id("addRequestForQuotationGuestVendors")).click();Thread.sleep(1000);
        page.findElement(By.id("vendorName")).sendKeys("loho");Thread.sleep(1000);
        page.findElement(By.id("vendorEmail")).sendKeys("lohool@sharklasers.com");Thread.sleep(1000);
        page.findElement(By.id("saveRequestForQuotationGuestVendor")).click();Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) page;
        js.executeScript("window.scrollBy(0, 700)");Thread.sleep(1000);
        page.findElement(By.id("vendorSendMailBtnId")).click();Thread.sleep(3000);


        String mailinatorInbox = "https://www.mailinator.com/v3/#/#inboxpane?public_to=testvendor";
        ((JavascriptExecutor) page).executeScript("window.open(arguments[0], '_blank');", mailinatorInbox);

        // Switch to Mailinator tab
        Set<String> allWindows = page.getWindowHandles();
        for (String windowHandle : allWindows) {
            page.switchTo().window(windowHandle);
        }

        // Wait for email to appear
        WebElement emailRow = null;
        int attempts = 0;
        while(attempts < 20) { // try for up to 20*2 = 40 seconds
            try {
                emailRow = page.findElement(By.xpath("//td[contains(text(),'Vendor Invitation')]"));
                if(emailRow.isDisplayed() && emailRow.isEnabled()) {
                    break;
                }
            } catch(Exception e) {
                Thread.sleep(2000);
                attempts++;
            }
        }
        if(emailRow != null) {
            emailRow.click();
        } else {
            System.out.println("Email did not arrive in Mailinator");
        }

        // Switch to iframe with email content
        page.switchTo().frame(page.findElement(By.id("msg_body")));

        // Extract password from email
        String mailContent = page.findElement(By.tagName("body")).getText();
        String guestPassword = mailContent.split("Password: ")[1].split("\n")[0].trim();
        System.out.println("Guest Password: " + guestPassword);

        page.switchTo().defaultContent();

        // Login as Guest Vendor
        page.get("https://dprocure-uat.cormsquare.com/Public/GuestVendor/GuestVendorLogin");
        page.findElement(By.id("email")).sendKeys(guestEmail);
        page.findElement(By.id("password")).sendKeys(guestPassword);
        page.findElement(By.id("btnLogin")).click();
    }
}

