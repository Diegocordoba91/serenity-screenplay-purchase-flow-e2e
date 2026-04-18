package com.serenety.actors;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class UiTestBase {

    @BeforeEach
    void openTheTheater() {
        OnStage.setTheStage(new OnlineCast());
    }

    @AfterEach
    void closeTheTheater() {
        OnStage.drawTheCurtain();
    }
}
