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

import static com.constants.requisitions.create.PRCreate.QUOTATION_VADILITYDATE_XPATH;

public class VendorloginRFQ {
    private Login login;
    private Logout logout;
    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public VendorloginRFQ(Login login, Logout logout, WebDriverWait webDriverWait, WebDriver webDriver) {
        this.login = login;
        this.logout = logout;
        this.webDriverWait = webDriverWait;
        this.driver = webDriver;
    }

    public void SelectvendorLogin() throws InterruptedException {
        login.login("sales@nandipowertronics.com", "Admin@123");

        WebElement rfqTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarVerticalMenu\"]/div/div/div[2]/a/span")));
        rfqTab.click();

        List<WebElement> transactions = webDriverWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));


        WebElement freshFirstTransaction = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")
                ));
        freshFirstTransaction.click();

        WebElement sendQuote = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSendQuote")));
        sendQuote.click();

        WebElement Incoterm = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("incotermLocation")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Incoterm.clear();
        Incoterm.sendKeys("563");

        WebElement quotation = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("quotationReferenceNumber")));
        quotation.clear();
        quotation.sendKeys("13");

        WebElement vadilitydate = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(QUOTATION_VADILITYDATE_XPATH)));
        vadilitydate.click();

        String dayXpath = "//span[@class='flatpickr-day today']";
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath))).click();

        By[] radioLocators = {
                By.xpath("//input[@id='liquidatedComplyId' and @value='true']"),
                By.xpath("//input[@id='rohsComplyId' and @value='true']"),
                By.xpath("//input[@id='warrantyRequirementsComplyId' and @value='true']"),
                By.xpath("//input[@id='packingForwardingComplyId' and @value='true']"),
                By.xpath("//input[@id='freightComplyId' and @value='true']"),
                By.xpath("//input[@id='insuranceComplyId' and @value='true']"),
                By.xpath("//input[@id='bankGuaranteeComplyId' and @value='true']")
        };

        for (By locator : radioLocators) {
            try {
                WebElement radio = webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
                System.out.println("✅ Selected radio: " + locator.toString());
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("❌ Could not select radio: " + locator.toString() + " → " + e.getMessage());
            }
        }
    }

    public void QuotationItem() throws InterruptedException {
        WebElement hsn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("hsnsac-1")));
        hsn.clear();
        hsn.sendKeys("996111");

        WebElement Make = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("make-1")));
        Make.clear();
        Make.sendKeys("cas");

        WebElement Model = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("model-1")));
        Model.clear();
        Model.sendKeys("new");

        WebElement Partno = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("partNumber-1")));
        Partno.clear();
        Partno.sendKeys("3");

        WebElement country = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("countryOfOrigin-1")));
        country.clear();
        country.sendKeys("India");

        WebElement rate = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("rate-1")));
        rate.clear();
        rate.sendKeys("1800");

        WebElement discount = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("discount-1")));
        discount.clear();
        discount.sendKeys("25");

        WebElement IGST = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("igst-1")));
        IGST.clear();
        IGST.sendKeys("18");

        WebElement leadtime = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("leadTime-1")));
        leadtime.clear();
        leadtime.sendKeys("12");

        WebElement Action = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"viewitemspecification\"]")));
        Action.click();

        WebElement complyall = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"complyAll\"]")));
        complyall.click();

        WebElement savebutton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("itemSpecificationSave")));
        savebutton.click();

        WebElement attachfile = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("attachFile")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachfile.click();

        WebElement Attachfiledorpdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-attachmentTypeId-container\"]/span")));
        Attachfiledorpdown.click();
        WebElement Attachfilesearch = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='select2-search__field']")));
        Attachfilesearch.click();
        WebElement technicalTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Technical')]")));
        try {
            technicalTab.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", technicalTab);
        }
        System.out.println("✅ Technical option selected");


        WebElement fileInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"formFilePreupload\"]")));
        String filePath = "C:\\Users\\Harika\\Downloads\\sample-1.pdf";
        fileInput.sendKeys(filePath);
        Thread.sleep(1000);
        System.out.println("✅ File attached successfully");

        WebElement saveButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("attachmentSaveId")));
        saveButton.click();

        WebElement attachfile1 = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("attachFile")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachfile1.click();

        WebElement Attachdorpdown = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-attachmentTypeId-container\"]/span")));
        Attachdorpdown.click();
        WebElement Attachsearch = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='select2-search__field']")));
        Attachsearch.click();
        WebElement commericalTab = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Commercial')]")));
        try {
            commericalTab.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", commericalTab);
        }
        System.out.println("✅ Technical option selected");


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"formFilePreupload\"]")));
        fileInput.sendKeys(filePath);
        Thread.sleep(1000);
        System.out.println("✅ File attached successfully");

        WebElement saveBtn = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("attachmentSaveId")));
        saveBtn.click();

        WebElement sendQuote = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreate")));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        sendQuote.click();

        WebElement yesbutton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div[2]/button[1]")));
        yesbutton.click();
        logout.logout();
        Thread.sleep(2000);
    }
}
