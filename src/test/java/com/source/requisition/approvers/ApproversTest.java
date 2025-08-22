package com.source.requisition.approvers;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class ApproversTest extends BaseTest {

    @Test
    public void approveTest() throws InterruptedException {

        String[] emails = {"admin@cormsquare.com", "shashanka.s@yokogawa.com"};
        String password = "Admin@123";

        approvers.approve(emails, password);
    }
}