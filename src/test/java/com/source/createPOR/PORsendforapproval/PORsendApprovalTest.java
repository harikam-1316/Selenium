package com.source.createPOR.PORsendforapproval;

import com.base.BaseMain;
import org.testng.annotations.Test;

public class PORsendApprovalTest extends BaseMain {
    @Test
    public void porSendApprovalFlow() throws InterruptedException {
        porSendforApproval.SelectSendApproval();
    }
}

