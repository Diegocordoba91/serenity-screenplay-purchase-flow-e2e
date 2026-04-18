package com.serenety.pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target USERNAME_INPUT = Target.the("username input field")
        .locatedBy("[data-test='username']");

    public static final Target PASSWORD_INPUT = Target.the("password input field")
        .locatedBy("[data-test='password']");

    public static final Target LOGIN_BUTTON = Target.the("login button")
        .locatedBy("[data-test='login-button']");
}
