package framework.logger;

import org.apache.log4j.LogManager;

public class Logger {
    private static final String LOGGER_NAME = "Logger";
    private static org.apache.log4j.Logger INSTANCE = LogManager.getLogger("Logger");
    private Logger() {
    }

    private static org.apache.log4j.Logger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = org.apache.log4j.Logger.getLogger(LOGGER_NAME);
        }
        return INSTANCE;
    }

    public static void info(String message){
        getInstance().info(message);
    }

    public static void debug(String message){
        getInstance().debug(message);
    }

    public static void attachLog() {

    }
}
