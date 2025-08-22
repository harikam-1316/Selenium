package com.source.invoice.invoicechecklist;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Invoicechecklist {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Login login;
    private Logout logout;
    private Properties properties;

    public Invoicechecklist(WebDriver driver, WebDriverWait wait, Login login, Logout logout, Properties properties) {
        this.driver = driver;
        this.webDriverWait = wait;
        this.login = login;
        this.logout = logout;
        this.properties = properties;
    }

    public void createInvoice() throws InterruptedException, IOException {
        login.login("sajimon.bp@yokogawa.com", "Admin@123");

        WebElement invoiceMenu = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ni-invoices\"]/a")));
        invoiceMenu.click();

        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();

        WebElement firstChecklist = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@onclick, 'openCheckList')])[1]"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstChecklist);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(firstChecklist)).click();

        WebElement acceptButton1 = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("acceptCheckListId")));
        acceptButton1.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("acceptCheckListId")));


        WebElement secondChecklist = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@onclick, 'openCheckList')])[2]"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", secondChecklist);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(secondChecklist)).click();

        WebElement acceptButton2 = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("acceptCheckListId")));
        acceptButton2.click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("acceptCheckListId")));


        WebElement verifyButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnAccept")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", verifyButton);
        verifyButton.click();

        WebElement submitButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'bootbox-accept') and text()='Submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
        submitButton.click();

        logout.logout();

    }
}
