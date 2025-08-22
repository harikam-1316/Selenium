package com.source.createPOR.PORsendforapproval;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class PORsendApprovalnoncatalogTest extends BaseTest {
    @Test
    public void porSendApprovalFlow() throws InterruptedException {
        porSendforApproval.SelectSendApproval();
    }
}

