package com.source.createPOR;


import com.base.BaseMain;
import com.base.BaseTest;
import org.testng.annotations.Test;

public class BuyerloginTest extends BaseTest {

    @Test
    public void buyerLoginTest() throws InterruptedException {

        buyerlogin.loginButton();
        buyerlogin.selectBuyerAndAssign();

    }

}
