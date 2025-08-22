package com.source.createPO;

import com.base.BaseTest;
import com.source.POcreate.CreatePO;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreatePOTest extends BaseTest {
    @Test
    public void testCreatePO() throws IOException {
        createPO.SelectcreatePO();
    }
}
