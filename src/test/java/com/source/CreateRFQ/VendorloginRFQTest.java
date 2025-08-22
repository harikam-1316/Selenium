package com.source.CreateRFQ;

import com.base.BaseMain;
import org.testng.annotations.Test;
public class VendorloginRFQTest extends BaseMain {

    @Test
    public void VendorloginRFQTest() throws InterruptedException {
        vendorloginRFQ.SelectvendorLogin();
        vendorloginRFQ.QuotationItem();



    }
}

