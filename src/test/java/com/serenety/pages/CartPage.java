package com.serenety.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
        .locatedBy("[data-test='checkout']");

    public static Target cartItemByName(String productName) {
        return Target.the("Cart item: " + productName)
            .locatedBy("//div[@class='inventory_item_name' and text()='" + productName + "']");
    }
}
