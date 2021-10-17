package com.example.task04;

import java.util.*;
import java.text.SimpleDateFormat;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {


    private Level level;
    private String name;

    private static HashMap<String, Logger> loggers = new HashMap<String, Logger>();

    private static List<MessageHandler> handlers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        } else
            throw new NullPointerException();
    }

    public Logger(String name) {
        if (!loggers.containsKey(name)) {
            this.name = name;
            loggers.put(name, this);
        }
    }


    public static void addHandler(MessageHandler handler) {
        if (handler != null) {
            handlers.add(handler);
        }
    }

    private void log(Level level, String message) {
        log(level, message, null);
    }

    private void log(Level level, String fMessage, Object... args) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if (this.level.ordinal() <= level.ordinal()) {
            String msg = String.format("[%s] %s %s - %s", level, date.format(new Date()), this.name, String.format(fMessage, args));
            for (MessageHandler handle : handlers) {
                handle.printMessage(msg);
            }
        }
    }

    public void debug(String message) {
        log(Level.DEBUG, message, null);
    }

    public void debug(String fMessage, Object... args) {
        log(Level.DEBUG, fMessage, args);
    }

    public void info(String message) {
        log(Level.INFO, message, null);
    }

    public void info(String fMessage, Object... args) {
        log(Level.INFO, fMessage, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message, null);
    }

    public void warning(String fMessage, Object... args) {
        log(Level.WARNING, fMessage, args);
    }

    public void error(String message) {
        log(Level.ERROR, message, null);
    }

    public void error(String fMessage, Object... args) {
        log(Level.ERROR, fMessage, args);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
