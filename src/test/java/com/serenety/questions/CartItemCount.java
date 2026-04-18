package com.serenety.questions;

import com.serenety.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CartItemCount implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.CART_BADGE).answeredBy(actor);
    }

    @Override
    public String toString() {
        return "the number of items in the cart";
    }
}
