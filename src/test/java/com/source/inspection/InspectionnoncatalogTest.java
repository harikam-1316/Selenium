package com.source.inspection;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class InspectionnoncatalogTest extends BaseTest {
    @Test
    public void inspectionVendorLoginTest() throws InterruptedException {
        inspection.selectVendorLogin();
    }
}

