package com.source.requisition.Approvers;

import com.source.login.Login;
import com.constants.logout.Logout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static com.constants.requisitions.create.PRCreate.*;

public class Approvers {
    private WebDriver driver;
    private WebDriverWait wait;
    private Login login;
    private Logout logout;

    public Approvers(WebDriver driver, WebDriverWait wait, Login login, Logout logout) {
        this.driver = driver;
        this.wait = wait;
        this.login = login;
        this.logout = logout;
    }

    public String[] getApprovers() {
        WebElement getApprovers = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='approvalData']/tbody/tr/td[3]")));
        String[] approvers = new String[]{getApprovers.getText()};
        return approvers;
    }

    public void approve(String[] email, String password) throws InterruptedException {
        for (int i = 0; i < email.length; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Input_Email")));
            driver.findElement(By.id("Input_Email")).clear();
            driver.findElement(By.xpath("//*[@id=\"Input_Password\"]")).clear();
            login.login(email[i], password);
            try {
                WebElement myApprovalsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ni-my-approvals']/a/span")));
                myApprovalsTab.click();
                System.out.println("Clicked on 'My Approvals' tab");

                WebElement reqTab = wait.until(ExpectedConditions.elementToBeClickable(By.id(REQUISITION_NAVIGATION_BAR)));
                reqTab.click();

                List<WebElement> transactions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-primary.btn.btn-sm.btn-link.p-0")));
                transactions.get(0).click();


                WebElement updateOITP = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(UPDATE_OITP_XPATH)));
                updateOITP.click();

                WebElement orderIntakeCostInput = wait.until(ExpectedConditions.elementToBeClickable(By.id(ORDERINTAKECOSTINPUT_ID)));
                orderIntakeCostInput.clear();
                orderIntakeCostInput.sendKeys("12");

                WebElement targetPrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TARGETPRICE_XPATH)));
                targetPrice.clear();
                targetPrice.sendKeys("5");

                WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(SUBMIT_BUTTON_ID)));
                submitButton.click();
                System.out.println("clicked Submit button");

                WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnApprove")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", approveButton);
                approveButton.click();
                System.out.println("Clicked Approve button successfully");

                WebElement submitButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'bootbox-accept')]")));
                submitButton1.click();
                System.out.println("clicked Submit button");
            } catch (Exception e) {
                System.out.println("Approval failed for user " + email[i] + ": " + e.getMessage());
            } finally {
                Thread.sleep(500);
                logout.logout();

            }
        }
    }
}



