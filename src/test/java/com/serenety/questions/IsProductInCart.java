package com.serenety.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebDriver;

public class IsProductInCart implements Question<Boolean> {
    private final String productName;

    public IsProductInCart(String productName) {
        this.productName = productName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            WebDriver driver = actor.abilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class).getDriver();
            String xpath = "//div[contains(@class, 'inventory_item_name') and text()='" + productName + "']";
            return !driver.findElements(org.openqa.selenium.By.xpath(xpath)).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "whether " + productName + " is in the cart";
    }
}
