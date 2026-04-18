package com.serenety.tasks;

import com.serenety.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductToCart implements Task {
    private final int itemIndex;

    public AddProductToCart(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(ProductsPage.addToCartButton(itemIndex))
        );
    }

}
