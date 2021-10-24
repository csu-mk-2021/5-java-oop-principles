package com.example.task01;

import java.util.*;

public class Logger {
    public static final int INFO = 0;
    public static final int DEBUG = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    private static final Map<String, Logger> hashLogger = new HashMap<>();

    private final String name;
    private int current_level;

    public Logger(String name) {
        this.name = name;
        current_level = 3;
    }

    public void setLevel(int current_level) {
        this.current_level = current_level;
    }

    public int getLevel() {
        return current_level;
    }

    private void printMessage(String level, String message) {
        System.out.printf("[%s] %04d.%02d.%02d %02d:%02d:%02d %s - %s%n",
                level,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                Calendar.getInstance().get(Calendar.SECOND),
                name,
                message
        );

    }

    public void debug(String message) {
        if (this.current_level <= DEBUG)
            this.printMessage("DEBUG", message);
    }

    public void debug(String format, Object... args) {
        if (this.current_level <= DEBUG)
            this.printMessage("DEBUG", String.format(format, Arrays.toString(args)));
    }

    public void error(String message) {
        if (this.current_level <= ERROR)
            this.printMessage("ERROR", message);
    }

    public void error(String format, Object... args) {
        if (this.current_level <= ERROR)
            this.printMessage("ERROR", String.format(format, args));
    }

    public void info(String message) {
        if (this.current_level <= INFO)
            this.printMessage("INFO", message);
    }

    public void info(String format, Object... args) {
        if (this.current_level <= INFO)
            this.printMessage("INFO", String.format(format, args));
    }

    public void warning(String message) {
        if (this.current_level <= WARNING)
            this.printMessage("WARNING", message);
    }

    public void warning(String format, Object... args) {
        if (this.current_level <= WARNING)
            this.printMessage("WARNING", String.format(format, args));
    }

    public void log(int level, String message, Object... args) {
        log(level, String.format(message, args));
    }

    public void log(int level, String message) {
        switch (level) {
            case INFO:
                this.info(message);
                break;
            case WARNING:
                this.warning(message);
                break;
            case ERROR:
                this.error(message);
                break;
            case DEBUG:
                this.debug(message);
                break;
            default:
                throw new IllegalArgumentException("bad level");
        }
    }

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        Logger logger = hashLogger.get(name);
        if (logger != null)
            return hashLogger.get(name);
        logger = new Logger(name);
        hashLogger.put(name, logger);
        return logger;
    }


}
