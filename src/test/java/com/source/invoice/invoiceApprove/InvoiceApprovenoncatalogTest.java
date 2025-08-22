package com.source.invoice.invoiceApprove;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class InvoiceApprovenoncatalogTest extends BaseTest {
    @Test
    public void invoiceApproveTest() throws InterruptedException {
        String[] emails = {
                "sajimon.bp@yokogawa.com",
                "hemanth.r@yokogawa.com",
                "v.rangaswamy@yokogawa.com",

        };
        String password = "Admin@123";

        invoiceApprovenoncatalog.approve(emails, password);
    }
}


