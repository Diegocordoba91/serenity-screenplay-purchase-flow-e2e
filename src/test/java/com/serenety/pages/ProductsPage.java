package com.serenety.pages;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {

    public static final Target CART_ICON = Target.the("shopping cart icon")
        .locatedBy("[data-test='shopping-cart-link']");

    public static final Target CART_BADGE = Target.the("cart item count badge")
        .locatedBy(".shopping_cart_badge");

    public static final Target PRODUCTS_TITLE = Target.the("products page title")
        .locatedBy(".title");

    public static Target addToCartButton(int itemIndex) {
        return Target.the("Add to Cart button for item #" + itemIndex)
            .locatedBy("(//div[@class='inventory_item'])[" + itemIndex + "]//button[contains(@class, 'btn_primary')]");
    }
}
