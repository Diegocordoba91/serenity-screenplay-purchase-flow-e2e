package com.serenety.tasks;

import com.serenety.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FillCheckoutForm implements Task {
    private final String firstName;
    private final String lastName;
    private final String zipCode;

    public FillCheckoutForm(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_INPUT),
            Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_INPUT),
            Enter.theValue(zipCode).into(CheckoutPage.ZIP_CODE_INPUT),
            Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}
