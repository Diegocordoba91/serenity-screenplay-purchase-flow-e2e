package com.serenety.config;

public class ConfigManager {

    private static String getProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        return (value != null) ? value : defaultValue;
    }

    public static String getUiBaseUrl() {
        return getProperty("ui.base.url", "https://www.saucedemo.com");
    }

    public static String getStandardUser() {
        return getProperty("ui.standard.user", "standard_user");
    }

    public static String getLockedUser() {
        return getProperty("ui.locked.user", "locked_out_user");
    }

    public static String getPassword() {
        return getProperty("ui.password", "secret_sauce");
    }
}
