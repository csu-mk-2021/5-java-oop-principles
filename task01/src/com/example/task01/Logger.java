package com.example.task01;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class Logger {
    enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Level level;
    private String name;
    private static final HashMap<String, Logger> loggers = new HashMap<>();

    public String getName() {
        return name;
    }

    public Logger(String name){
        this(name, Level.INFO);
    }

    public Logger(String name, Level level) {
        this.level = level;
        if (!loggers.containsKey(name)) {
            this.name = name;
            loggers.put(name, this);
        }
    }

    public static Logger getLogger(String name){
        if (!loggers.containsKey(name)) {
            Logger logger = new Logger (name);
            loggers.put(name, logger);
            return logger;
        }
        else {
            return loggers.get(name);
        }

    }

    private void log(Level level, String message) {
        log(level, message, (Object) null);
    }

    private void log(Level level, String fMessage, Object... args) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if (this.level.ordinal() <= level.ordinal()) {
            System.out.println("[" + level + "] " + date.format(new Date()) + " " + this.name + " - " + String.format(fMessage, args));
        }
    }

    public void debug(String message) {
        log(Level.DEBUG, message, (Object) null);
    }

    public void debug(String fMessage, Object... args) {
        log(Level.DEBUG, fMessage, args);
    }

    public void info(String message) {
        log(Level.INFO, message, (Object) null);
    }

    public void info(String fMessage, Object... args) {
        log(Level.INFO, fMessage, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message, (Object) null);
    }

    public void warning(String fMessage, Object... args) {
        log(Level.WARNING, fMessage, args);
    }

    public void error(String message) {
        log(Level.ERROR, message, (Object) null);
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
