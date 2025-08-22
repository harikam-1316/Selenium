package com.source.inspection;


import com.base.BaseMain;

import org.testng.annotations.Test;

public class InspectionTest extends BaseMain {
    @Test
    public void inspectionVendorLoginTest() throws InterruptedException {
        inspection.selectVendorLogin();
    }
}


