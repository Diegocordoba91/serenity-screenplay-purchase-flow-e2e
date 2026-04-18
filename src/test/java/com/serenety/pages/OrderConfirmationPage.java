package com.serenety.pages;

import net.serenitybdd.screenplay.targets.Target;

public class OrderConfirmationPage {

    public static final Target CONFIRMATION_MESSAGE = Target.the("thank you confirmation message")
        .locatedBy(".complete-header");
}
