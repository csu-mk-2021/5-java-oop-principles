package com.example.task01;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Objects;
enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {


    private Level level;
    private String name;

    private static ConcurrentHashMap<String, Logger> loggers = new ConcurrentHashMap<String, Logger>();

    public String getName() {
        return name;
    }

    public static Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }

    private Logger(String name) {
        if (!loggers.containsKey(name)) {
            this.name = name;
            loggers.put(name, this);
        }
    }

    private void log(Level level, String message) {
        Objects.requireNonNull(level);
        log(level, message, null);
    }

    private void log(Level level, String fMessage, Object... args) {
        Objects.requireNonNull(level);
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if (this.level.ordinal() <= level.ordinal()) {
            System.out.println("[" + level + "] " + date.format(new Date()) + " " + this.name + " - " + String.format(fMessage, args));
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
        Objects.requireNonNull(level);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}

