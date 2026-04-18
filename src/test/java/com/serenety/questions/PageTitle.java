package com.serenety.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class PageTitle implements Question<String> {
    private final Target titleElement;

    public PageTitle(Target titleElement) {
        this.titleElement = titleElement;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(titleElement).answeredBy(actor);
    }

    @Override
    public String toString() {
        return "the page title";
    }
}
