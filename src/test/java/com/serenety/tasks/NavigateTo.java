package com.serenety.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

public class NavigateTo implements Task {
    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = actor.abilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class).getDriver();
        driver.navigate().to(url);
    }
}
