package com.source.login;

import com.base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        String email = "";
        String password = "";
        login.login(email, password);
    }
}

