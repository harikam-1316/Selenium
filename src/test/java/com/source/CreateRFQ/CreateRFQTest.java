package com.source.CreateRFQ;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class CreateRFQTest extends BaseTest {
    @Test
    public void CreateRFQTest() throws InterruptedException {
        createRFQ.loginButton();
        createRFQ.Selectvendor();

    }
}
