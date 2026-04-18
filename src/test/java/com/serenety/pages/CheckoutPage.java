package com.serenety.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target FIRST_NAME_INPUT = Target.the("first name input field")
        .locatedBy("[data-test='firstName']");

    public static final Target LAST_NAME_INPUT = Target.the("last name input field")
        .locatedBy("[data-test='lastName']");

    public static final Target ZIP_CODE_INPUT = Target.the("zip code input field")
        .locatedBy("[data-test='postalCode']");

    public static final Target CONTINUE_BUTTON = Target.the("continue button")
        .locatedBy("[data-test='continue']");
}
