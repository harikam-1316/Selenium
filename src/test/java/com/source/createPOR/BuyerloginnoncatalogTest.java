package com.source.createPOR;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class BuyerloginnoncatalogTest extends BaseTest {

    @Test
    public void buyerLoginTest() throws InterruptedException {

        buyerloginnoncatalog.loginButton();
        buyerloginnoncatalog.selectBuyerAndAssign();
    }
}