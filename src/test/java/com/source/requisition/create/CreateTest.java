package com.source.requisition.create;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class CreateTest extends BaseTest {

    @Test
    public void requisitionCreateTest() throws InterruptedException {
        create.requesterLogin();
        create.requisitionNav();
        create.clickCreateButton();
        create.clickPOCCatalog();
        create.enterTitle();
        create.selectProject();
        create.selectWBS();
        create.selectVendor();
        create.rateContract();
        create.SelectShippingAddress();
        create.SelectShippingMode();
        create.SelectChecker();
        create.setPoIssueDate();
        create.setDeliveryDate();
        create.SelectbuyerGroup();
        create.SelectaddRequisitionitem();
        create.Selectitem();
        create.selectquality();
        create.SelectButton();
        create.SelectCreateButton();
        create.SelectyesButton();

    }


}