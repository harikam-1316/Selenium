package com.source.invoice;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.constants.requisitions.create.PRCreate.*;

public class Invoice {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Login login;
    private Logout logout;
    private Properties properties;

    public Invoice(WebDriver driver, WebDriverWait wait, Login login, Logout logout, Properties properties) {
        this.driver = driver;
        this.webDriverWait = wait;
        this.login = login;
        this.logout = logout;
        this.properties = properties;
    }

    public void createInvoice() throws InterruptedException, IOException {
        login.login("sales@nandipowertronics.com", "Admin@123");

        WebElement invoiceMenu = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navbarVerticalMenu']//div[9]//a")));
        invoiceMenu.click();
        WebElement createinvoice = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/div[2]/a")));
        createinvoice.click();
        try {
            String Invoicetype = properties.getProperty("Invoicetype");
            WebElement Invoice = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(INVOICETYPE_DROPDOWN_XPATH)));
            Invoice.click();
            WebElement Invoicetypesearch = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(INVOICETYPE_SEARCH_XPATH)));
            Invoicetypesearch.sendKeys(Invoicetype);
            String InvoicetypeXpath = getInvoicetype(Invoicetype);
            WebElement correctInvoicetypeOption = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvoicetypeXpath)));
            correctInvoicetypeOption.click();
            System.out.println("✅ Invoicetype  selected successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error selecting Invoicetype): " + e.getMessage());
        }
        WebElement Inovicenum = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(INVOICENUMBER_ID)));
        Thread.sleep(1000);
        Inovicenum.clear();
        Inovicenum.sendKeys("7393");

        WebElement invoiceDateInput = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"createForm\"]/div[1]/div[2]/div/div[1]/div[3]/input[2]")));
        invoiceDateInput.click();
        String dayXpath = "(//span[@class='flatpickr-day today'])[2]";
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath))).click();

        String poReferenceId = properties.getProperty("poReferenceId");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        WebElement dropDown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(PURCHASE_ORDER_DROPDOWN_XPATH)));
        dropDown.click();
        WebElement searchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(PURCHASE_ORDER_SEARCH_XPATH)));
        searchBox.sendKeys(poReferenceId);
        String purchaseOrderXpath = getpurchaseOrder(poReferenceId);
        WebElement correctpurchaseOrderOption = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseOrderXpath)));
        Thread.sleep(2000);
        correctpurchaseOrderOption.click();
        System.out.println("Using PO Reference in Invoice: " + poReferenceId);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('doc1').style.display='block';");

        WebElement fileInput = driver.findElement(By.id("doc1"));
        String filePath = System.getProperty("user.dir") + "\\documents\\sample-1.pdf";
        fileInput.sendKeys(filePath);
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("btnCreate"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
        Thread.sleep(1000);
        WebElement yesbutton = driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
        yesbutton.click();

        logout.logout();

    }

}

