package com.serenety.tests.ui;

import com.serenety.actors.UiTestBase;
import com.serenety.config.ConfigManager;
import com.serenety.pages.ProductsPage;
import com.serenety.questions.CartItemCount;
import com.serenety.questions.IsProductInCart;
import com.serenety.questions.OrderConfirmationMessage;
import com.serenety.questions.PageTitle;
import com.serenety.tasks.AddProductToCart;
import com.serenety.tasks.FillCheckoutForm;
import com.serenety.tasks.FinishPurchase;
import com.serenety.tasks.Login;
import com.serenety.tasks.NavigateTo;
import com.serenety.tasks.ProceedToCheckout;
import com.serenety.tasks.ViewCart;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Purchase Flow - Complete E2E Test")
class PurchaseFlowTest extends UiTestBase {

    @Test
    @DisplayName("User can complete a full purchase flow successfully")
    void completePurchaseFlowSuccessfully() {
        var diego = OnStage.theActorCalled("Diego");

        diego.attemptsTo(
                new NavigateTo(ConfigManager.getUiBaseUrl()));

        diego.attemptsTo(
                new Login(ConfigManager.getStandardUser(), ConfigManager.getPassword()));

        assertThat(diego.asksFor(new PageTitle(ProductsPage.PRODUCTS_TITLE)))
                .isEqualTo("Products");

        diego.attemptsTo(
                new AddProductToCart(1));

        diego.attemptsTo(
                new AddProductToCart(2));

        assertThat(diego.asksFor(new CartItemCount()))
                .isEqualTo("2");

        diego.attemptsTo(
                new ViewCart());

        assertThat(diego.asksFor(new IsProductInCart("Sauce Labs Backpack")))
                .isTrue();

        assertThat(diego.asksFor(new IsProductInCart("Sauce Labs Bike Light")))
                .isTrue();

        diego.attemptsTo(
                new ProceedToCheckout());

        diego.attemptsTo(
                new FillCheckoutForm("Diego", "Cordoba", "28001"));

        diego.attemptsTo(
                new FinishPurchase());
        String confirmationMessage = diego.asksFor(new OrderConfirmationMessage());
        assertThat(confirmationMessage)
                .isNotEmpty()
                .containsIgnoringCase("THANK YOU")
                .containsIgnoringCase("ORDER");
    }
}
