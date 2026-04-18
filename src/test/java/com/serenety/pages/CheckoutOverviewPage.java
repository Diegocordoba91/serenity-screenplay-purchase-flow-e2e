package com.serenety.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutOverviewPage {

    public static final Target FINISH_BUTTON = Target.the("finish button to complete purchase")
        .locatedBy("[data-test='finish']");
}
