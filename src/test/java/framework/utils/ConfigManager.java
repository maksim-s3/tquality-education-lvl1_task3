package framework.utils;

import org.json.simple.JSONObject;

public class ConfigManager {
    private static JSONObject config = JsonLoader.load("Config");

    public static boolean getIsIncognito() {
        return (boolean) config.get("incognito");
    }

    public static boolean getFullScreen() {
        return (boolean) config.get("full_screen");
    }

    public static long getExplicitWaitTime() {
        return (long) config.get("explicit_wait_time");
    }

    public static long getSleepInMillis() {
        return (long) config.get("sleep_in_millis");
    }

    public static long getPageLoadTimeout() {
        return (long) config.get("pageLoadTimeout");
    }

    public static String getURL() {
        return (String) config.get("BaseUrl");
    }
}
