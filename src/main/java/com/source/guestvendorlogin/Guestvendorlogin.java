package com.source.guestvendorlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class Guestvendorlogin {
    private WebDriver webDriver;
    private Properties properties;
    private WebDriverWait wait;
    private Guestvendorlogin guestvendorlogin;



    public Guestvendorlogin(WebDriver webDriver, Properties properties, WebDriverWait wait ) {
        this.webDriver = webDriver;
        this.properties = properties;
        this.guestvendorlogin =guestvendorlogin;
        this.wait = wait;

    }

    public void loginGuestVendor(String inviteLink, String username, String password) {
        try {
            webDriver.get(inviteLink);
            webDriver.findElement(By.id("username")).sendKeys(username);
            webDriver.findElement(By.id("password")).sendKeys(password);
            webDriver.findElement(By.id("btnLogin")).click();
        } catch (WebDriverException e) {
            System.out.println("Error logging in Guest Vendor: " + e.getMessage());
        }
    }

}
