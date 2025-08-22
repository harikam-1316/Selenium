package com.source.CreateRFQ;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class RFQApproverTest extends BaseTest {
    @Test
    public void approvePORTest() throws InterruptedException {
        String[] emails = {
                "shashanka.s@yokogawa.com",
               };
        String password = "Admin@123";

        approvePOR.approve(emails, password);
    }
}