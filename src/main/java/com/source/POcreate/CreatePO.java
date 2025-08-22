package com.source.POcreate;

import com.constants.logout.Logout;
import com.source.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.utils.FileWriteUtil.writeFile;

public class CreatePO {
    private Login login;
    private Logout logout;
    private WebDriverWait wait;
    private WebDriver driver;
    private FileOutputStream fileOutputStream;
    private Properties properties;


    public CreatePO(Login login, Logout logout, WebDriverWait wait, WebDriver webDriver, FileOutputStream fileOutputStream, Properties properties) {
        this.driver = webDriver;
        this.login = login;
        this.logout = logout;
        this.wait = wait;
        this.fileOutputStream = fileOutputStream;
        this.properties = properties;
    }

    public void SelectcreatePO() throws IOException {
        login.login("manoj.yavagal@yokogawa.com", "Admin@123");

        WebElement poRequest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ni-purchase-order-requests']/a/span")));
        poRequest.click();
        System.out.println("Clicked on 'Purchase Order Request'");

        WebElement PORequest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='listContainer']/tr[2]/td[2]/div/a/span")));
        PORequest.click();
        System.out.println("Clicked on the  Purchase Order Request reference ID");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('createPOContainer').style.display='block';");


        WebElement createPOButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCreatePO")));

        createPOButton.click();


        System.out.println("Create PO button was made visible and clicked.");
        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn-primary bootbox-accept')]")));
        yesButton.click();

        String poReferenceId = wait.until(ExpectedConditions.elementToBeClickable(By.id("referenceId"))).getText();
        properties.setProperty("poReferenceId", poReferenceId);
        writeFile(properties);

        logout.logout();

    }
}





