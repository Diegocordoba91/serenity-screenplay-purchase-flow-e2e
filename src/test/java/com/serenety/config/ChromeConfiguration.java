package com.serenety.config;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfiguration {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");

        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        options.addArguments("--disable-prompt-on-repost");

        options.addArguments("--disable-infobars");

        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-default-apps");

        return options;
    }
}
