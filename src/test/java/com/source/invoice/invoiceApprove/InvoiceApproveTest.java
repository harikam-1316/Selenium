package com.source.invoice.invoiceApprove;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class InvoiceApproveTest extends BaseTest {
    @Test
   public void invoiceApproveTest() throws InterruptedException {
        String[] emails = {
             "sajimon.bp@yokogawa.com",
             "hemanth.r@yokogawa.com",
             "v.rangaswamy@yokogawa.com",

        };
        String password = "Admin@123";

        invoiceApprove.approve(emails, password);
    }
}
