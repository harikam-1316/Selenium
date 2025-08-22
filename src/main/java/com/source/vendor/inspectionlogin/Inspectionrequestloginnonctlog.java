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
import java.util.Properties;

import static com.constants.requisitions.create.PRCreate.*;

public class Inspectionrequestloginnonctlog {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;
    private Properties properties;

    public Inspectionrequestloginnonctlog(Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver, Properties properties) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
        this.properties = properties;
    }

    public void selectrequestorLogin() throws InterruptedException {
        login.login("manoj.yavagal@yokogawa.com", "Admin@123");
        WebElement OrderSchedules = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ni-order-schedules\"]/a/span")));
        OrderSchedules.click();
        List<WebElement> transactions = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
        transactions.get(0).click();
        WebElement AssignInspection = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnAssignInspector")));
        AssignInspection.click();
        try {
            String InspectorName = properties.getProperty("InspectorName");
            WebElement Inspector = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(INSPECTOR_DROPDOWN_XPATH)));
//            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);"); // scrolls down 300px
            Thread.sleep(1000);
            Inspector.click();
            WebElement Inspectorsearch = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(INSPECTOR_SEARCH_XPATH)));
            Inspectorsearch.sendKeys(InspectorName);
            String InspectorNameXpath = getInspectorName(InspectorName);
            WebElement correctInspectorNameOption = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(InspectorNameXpath)));
            correctInspectorNameOption.click();
            System.out.println("✅ InspectorName 'InspectorName' selected successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error selecting InspectorName): " + e.getMessage());
        }
        WebElement AssignButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveInspector")));
        AssignButton.click();
        Thread.sleep(2000);
        WebElement btn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnForCreateInspection")));
        btn.click();
        WebElement physicalinspection = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div[3]/div[2]/div[1]/label")));
        physicalinspection.click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
        WebElement createinspectionbtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateInspection")));
        createinspectionbtn.click();
        WebElement submitButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div[3]/button[1]")));
        submitButton.click();
        logout.logout();
    }
}

