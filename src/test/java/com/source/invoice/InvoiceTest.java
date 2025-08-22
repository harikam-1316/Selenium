package com.source.invoice;

import com.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class InvoiceTest extends BaseTest {
    @Test
    public void createInvoiceTest() throws InterruptedException, IOException {
        invoice.createInvoice();
    }
}
