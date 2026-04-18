package com.serenety.questions;

import com.serenety.pages.OrderConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OrderConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(OrderConfirmationPage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }

    @Override
    public String toString() {
        return "the order confirmation message";
    }
}
