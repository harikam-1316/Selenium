package com.source.requisition.create;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class CreatenoncatalogTest extends BaseTest {
    @Test
    public void requisitionCreateTest() throws InterruptedException {
        createnoncatalog.requesterLogin();
        createnoncatalog.requisitionNav();
        createnoncatalog.clickCreateButton();
        createnoncatalog.clickPOCNonCatalog();
        createnoncatalog.enterTitle();
        createnoncatalog.selectProject();
        createnoncatalog.selectWBS();
        createnoncatalog.selectIncoterm();
        String ldType = properties.getProperty("ld.type");      // "Yokogawa Standard" OR "Special"
        String damage = properties.getProperty("ld.damage");
        createnoncatalog.selectLiquidatedDamages(ldType, damage);
        createnoncatalog.selectWarranty();
        createnoncatalog.selectpricevadility();
        createnoncatalog.SelectShippingAddress();
        createnoncatalog.SelectShippingMode();
        createnoncatalog.SelectQuotation();
        createnoncatalog.setPoIssueDate();
        createnoncatalog.setDeliveryDate();
        createnoncatalog.SelectbuyerGroup();
        createnoncatalog.SelectChecker();
        createnoncatalog.SelectPurchase();
        createnoncatalog.SelectaddRequisitionitem();
        createnoncatalog.Selectitem();
        createnoncatalog.selectquality();
        createnoncatalog.SelectButton();
        createnoncatalog.SelectCreateButton();
        createnoncatalog.SelectyesButton();


    }
}
