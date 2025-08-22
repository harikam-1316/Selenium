package com.source.Vendorlogin;


import com.base.BaseMain;
import org.testng.annotations.Test;

public class VendorLoginTest extends BaseMain {

    @Test
    public void testVendorLogin() throws InterruptedException {
        vendorlogin.selectVendorLogin();

    }
}
