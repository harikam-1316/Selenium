package com.source.createPOR.approvePOR;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class ApprovePORnoncatalogTest extends BaseTest {
    @Test
    public void approvePORTest() throws InterruptedException {
        String[] emails = {
                "chandrashekar.hegde@yokogawa.com",
                "shashanka.s@yokogawa.com",
                "rama.raju@yokogawa.com",
                "v.ravishankar@yokogawa.com",
                "harshit.patel@yokogawa.com"};
        String password = "Admin@123";

        approvePOR.approve(emails, password);
    }
}

