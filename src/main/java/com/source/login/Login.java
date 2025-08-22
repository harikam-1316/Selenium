package com.source.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Login {

    WebDriver webDriver;

//TODO Constructor
    private Login(){
    }

    public Login(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String login(String email, String password) {
        String title = "";
        try {
            webDriver.findElement(By.id("Input_Email")).sendKeys(email);
            webDriver.findElement(By.id("Input_Password")).sendKeys(password);
            webDriver.findElement(By.id("login-submit")).click(); // adjust id if needed

            Thread.sleep(3000);

            title = webDriver.getTitle();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return title;
    }



}