package com.source.createPO;

import com.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreatePOnoncatalogTest extends BaseTest {
    @Test
    public void testCreatePO() throws IOException {
        createPOnoncatalog.SelectcreatePO();
    }
}


