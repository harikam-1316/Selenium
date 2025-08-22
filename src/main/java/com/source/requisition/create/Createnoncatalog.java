package com.source.requisition.create;

import com.constants.logout.Logout;
import com.constants.requisitions.create.PRCreate;
import com.source.login.Login;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import static com.constants.requisitions.create.PRCreate.*;
import static com.constants.requisitions.create.PRCreate.PROJECT_OPTION_TEXT;
import static com.constants.requisitions.create.PRCreate.WBS_DROPDOWN_XPATH;
import static com.constants.requisitions.create.PRCreate.WBS_OPTION_XPATH;
import static com.constants.requisitions.create.PRCreate.WBS_SEARCH_INPUT_XPATH;

public class Createnoncatalog {
    private Properties properties;
    private WebDriver webDriver;
    private Login login;
    private WebDriverWait wait;
    private Logout logout;


    public Createnoncatalog(WebDriver webDriver, Login login, Properties properties, WebDriverWait wait, Logout logout) {
        this.webDriver = webDriver;
        this.login = login;
        this.properties = properties;
        this.wait = wait;
        this.logout = logout;

    }

    public void requesterLogin() {
        try {
            String emailId = properties.getProperty("requesterEmail");
            String password = properties.getProperty("password");

            login.login(emailId, password);
        } catch (Exception exception) {
            System.out.println("Error in Requester Login Function");
        }
    }

    public void requisitionNav() {
        try {
            webDriver.findElement(By.id(PRCreate.REQUISITION_NAVIGATION_BAR)).click();
            Thread.sleep(3000);
        } catch (Exception exception) {
            System.out.println("Error in Requisition Navigation Bar Function");
        }
    }

    public void clickCreateButton() {
        try {
            WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_BUTTON_XPATH)));
            createButton.click();

        } catch (Exception e) {
            System.out.println("❌ Failed to click Create button: " + e.getMessage());
        }
    }

    public void clickPOCNonCatalog() {
        try {
            WebElement pocCatalog = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PRCreate.POC_NONCATALOG_XPATH)));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", pocCatalog);
            System.out.println("✅ POC NonCatalog clicked");
        } catch (Exception e) {
            System.out.println("❌ Error while clicking POC NonCatalog: " + e.getMessage());
        }
    }
    public void enterTitle() {
        try {
            WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRCreate.TITLE_INPUT)));
            titleInput.sendKeys("popp");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("❌ Error in entering title: " + e.getMessage());
        }
    }

    public void selectProject() {
        try {

            WebElement projectDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PROJECT_DROPDOWN)));
            projectDropdown.click();

            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PROJECT_SEARCH_BOX)));
            searchBox.sendKeys("Satna Smart City Development");

            WebElement correctOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PROJECT_OPTION_TEXT)));
            correctOption.click();

            System.out.println("✅ Project selected successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error in selecting project: " + e.getMessage());
        }
    }

    public void selectWBS() {
        try {

            WebElement wbsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WBS_DROPDOWN_XPATH)));
            wbsDropdown.click();
            WebElement wbsSearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WBS_SEARCH_INPUT_XPATH)));
            wbsSearchBox.clear();
            wbsSearchBox.sendKeys("J11DCSH");
            Thread.sleep(1000);
            WebElement correctWbsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WBS_OPTION_XPATH)));
            correctWbsOption.click();
            System.out.println("✅ WBS 'J11DCSH' selected successfully.");
        } catch (StaleElementReferenceException stale) {
            System.out.println("⚠️ Stale element - trying again...");
            selectWBS();
        } catch (Exception e) {
            System.out.println("❌ Error in selecting WBS: " + e.getMessage());
        }
    }
    public void selectIncoterm() {
        try {

            WebElement incotermDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INCOTERM_DROPDOWN_XPATH )));
            incotermDropdown.click();
            WebElement incotermSearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INCOTERM_SEARCH_INPUT_XPATH)));
            incotermSearchBox.clear();
            incotermSearchBox.sendKeys("EXW - Ex Works ");
            Thread.sleep(1000);
            WebElement correctincotermOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INCOTERM_OPTION_XPATH)));
            correctincotermOption.click();
            System.out.println("✅ WBS 'EXW - Ex Works ' selected successfully.");
        } catch (StaleElementReferenceException stale) {
            System.out.println("⚠️ Stale element - trying again...");

        } catch (Exception e) {
            System.out.println("❌ Error in selecting incoterm: " + e.getMessage());
        }
    }
    public void selectLiquidatedDamages(String ldType, String damage) {
        if (ldType.equalsIgnoreCase("Yokogawa Standard")) {
            WebElement standard = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("isLDStandardYesId")));
            standard.click();
        } else if (ldType.equalsIgnoreCase("Special")) {
            WebElement special = wait.until(ExpectedConditions.elementToBeClickable(By.id("isLDStandardNoId")));
            special.click();

            WebElement damageInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("liquidatedamageTextId")));
            damageInput.clear();
            damageInput.sendKeys(damage);
        }
    }

    public void selectWarranty() {
            try {
                String warrantyyear = properties.getProperty("warranty.year");
                WebElement warrantyDropdown = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath(WARRANTY_DROPDOWN_XPATH)));
                warrantyDropdown.click();

                By warrantyOption = By.xpath(getWarranty(warrantyyear));
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(warrantyOption));
                option.click();

                System.out.println("Warranty selected: " + warrantyyear);
            } catch (Exception e) {
                System.out.println("Error selecting warranty: " + e.getMessage());
            }
        }
    public void selectpricevadility() {
        try {

            String priceValidity = properties.getProperty("price.validity");
            WebElement priceDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PRICE_VADILITY_DROPDOWN_XPATH)));
            priceDropdown.click();
            WebElement pricesearchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PRICE_VADILITY_SEARCHBOX_XPATH)));
            pricesearchbox.click();

            String priceOption = getprice(priceValidity);
            Thread.sleep(1000);
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(priceOption)));
            option.click();

            System.out.println("✅ Price validity '" + priceValidity + "' selected successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error selecting price validity: " + e.getMessage());
        }
    }


    public void SelectShippingAddress() {
        try {
            String shippingAddress = properties.getProperty("shippingAddress");
            WebElement ShippingAddress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHIPPINGADDRESS_DROPDOWN_XPATH)));
            ShippingAddress.click();
            WebElement ShippingAddresssearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHIPPINGADDRESS_SEARCH_XPATH)));
            ShippingAddresssearch.sendKeys(shippingAddress);
            Thread.sleep(3000);
            String ShippingAddressXpath = getShippingAddress(shippingAddress);
            WebElement correctshippingAddressOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ShippingAddressXpath)));
            correctshippingAddressOption.click();
            System.out.println("✅ ShippingAddress 'INDIAN OIL CORPORATION LIMITED' selected successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error selecting ShippingAddress): " + e.getMessage());
        }
    }

    public void SelectShippingMode() {
        try {
            String shippingMode = properties.getProperty("shippingMode");
            WebElement ShippingMode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHIPPINGMODE_DROPDOWN_XPATH)));
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
            ShippingMode.click();
            WebElement ShippingModesearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHIPPINGMODE_SEARCH_XPATH)));
            ShippingModesearch.sendKeys(shippingMode);
            String ShippingModeXpath = getShippingMode(shippingMode);
            WebElement correctshippingModeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ShippingModeXpath)));
            correctshippingModeOption.click();
            System.out.println("✅ ShippingMode 'Air Freight' selected successfully.");

        } catch (Exception ex) {
            System.out.println("❌ Retry failed: " + ex.getMessage());

        }
    }

    public void SelectQuotation() {
        try {
            wait.until((ExpectedConditions.elementToBeClickable(By.xpath(QUOTATION_INPUT_XPATH )))).click();

            String dayXpath = "//span[@class='flatpickr-day today']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath))).click();

        } catch (Exception e) {
            System.out.println("❌ Error setting Quotation:" + e.getMessage());
        }
    }

    public void setPoIssueDate() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PO_ISSUE_INPUT_XPATH))).click();

            String dayXpath = "//span[@class='flatpickr-day today']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath))).click();

        } catch (Exception e) {
            System.out.println("❌ Error setting PO Date: " + e.getMessage());
        }
    }

    public void setDeliveryDate() {
        try {
            wait.until((ExpectedConditions.elementToBeClickable(By.xpath(DELIVERY_INPUT_XPATH)))).click();

            String dayXpath = "//span[@class='flatpickr-day today']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath))).click();

        } catch (Exception e) {
            System.out.println("❌ Error setting delivery Date:" + e.getMessage());
        }
    }

    public void SelectbuyerGroup() {
        try {
            String buyerGroupName = properties.getProperty("buyerGroupName");
            WebElement buyerGroup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUYERGROUP_DROPDOWN_XPATH)));
            buyerGroup.click();
            WebElement buyerGroupsearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUYERGROUP_SEARCH_XPATH)));
            buyerGroupsearch.sendKeys(buyerGroupName);
            String buyerGroupXpath = getbuyerGroup(buyerGroupName);
            WebElement correctbuyerGroupOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buyerGroupXpath)));
            correctbuyerGroupOption.click();
            System.out.println("✅ buyerGroup 'BG2 - CONTROL ROOM / LVS / CABLES' selected successfully.");

        } catch (Exception e) {

            System.out.println("❌ Error selecting buyerGroup): " + e.getMessage());
        }
    }
    public void SelectChecker() {
        try {
            String checker = properties.getProperty("checker");
            WebElement CheckerDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKER_DROPDOWN_XPATH)));
            CheckerDropdown.click();
            WebElement Checkersearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKER_SEARCH_XPATH)));
            Checkersearch.sendKeys(checker);
            String checkerXpath = getchecker(checker);
            WebElement correctCheckerOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkerXpath)));
            correctCheckerOption.click();
            System.out.println("✅ Checker  selected successfully.");
        } catch (StaleElementReferenceException e) {
            try {
                String checker = properties.getProperty("checker");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + checker + "')]"))).click();
            } catch (Exception ex) {
                System.out.println("❌ Retry failed: " + ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println("❌ Error selecting Checker): " + e.getMessage());
        }
    }
    public void SelectPurchase () {
        try {
            String purchase = properties.getProperty("Purchase");
            WebElement purchaseDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PURCHASE_DROPDOWN_XPATH)));
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 500);");
            purchaseDropdown.click();

            WebElement purchaseSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PURCHASE_SEARCHBOX_XPATH)));
            purchaseSearch.sendKeys(purchase);
            String purchaseXpath = getPurchase(purchase);
            WebElement correctPurchaseOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseXpath)));
            correctPurchaseOption.click();

            System.out.println("✅ Purchase '" + purchase + "' selected successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error selecting Purchase: " + e.getMessage());
        }
    }

        public void SelectaddRequisitionitem() {
        WebElement additemButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addLineRequisitionItems")));
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 500);");
        additemButton.click();
    }

    public void Selectitem() {
        try {
            String itemName = properties.getProperty("itemName");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ITEM_DROPDOWN_XPATH))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ITEM_SEARCH_XPATH))).sendKeys(itemName);
            Thread.sleep(1000);

            String itemXpath = getitem(itemName);

            WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemXpath)));
            wait.until(ExpectedConditions.elementToBeClickable(item)).click();

            System.out.println("✅ Item selected: " + itemName);
        } catch (Exception e) {
            System.out.println("❌ Error selecting item: " + e.getMessage());
        }
    }

    public void selectquality() {
        try {
            String qualityNumber = properties.getProperty("qualityNumber");
            WebElement qualityInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quantity\"]")));
            qualityInput.clear();
            qualityInput.sendKeys(qualityNumber);
        } catch (Exception e) {
            System.out.println("❌ Error Entering quality): " + e.getMessage());
        }
    }

    public void SelectButton() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveRequisitionItem")));
        addButton.click();
    }

    public void SelectCreateButton() {
        WebElement createDraftButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreate")));
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 800);");
        createDraftButton.click();
    }

    public void SelectyesButton() throws InterruptedException {
        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'bootbox-accept') and normalize-space(text())='Yes']")));
        yesButton.click();

        Thread.sleep(2000);

        logout.logout();
    }
}





