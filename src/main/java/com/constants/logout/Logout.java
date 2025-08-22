package com.constants.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
    WebDriverWait webDriverWait;

    public Logout(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void logout() {
        try {
            WebElement logoutOption = webDriverWait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"accountNavbarDropdown\"]/div/img")));
            logoutOption.click();
            WebElement signOutOption = webDriverWait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign')]")));
            signOutOption.click();



            System.out.println("Logout successful.");

        } catch (StaleElementReferenceException e) {
            System.out.println("Element was stale, retrying logout...");
            logout(); // retry once
        } catch (Exception e) {
            System.out.println("Logout failed: " + e.getMessage());
        }
    }
}