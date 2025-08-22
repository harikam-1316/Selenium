package com.source.invoice.invoicecheckList;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class InvoicecheckListTest extends BaseTest {
    @Test
    public void createInvoiceTest() throws Exception {
        invoicechecklist.createInvoice();
    }
}

