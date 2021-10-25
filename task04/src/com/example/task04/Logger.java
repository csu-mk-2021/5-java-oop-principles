package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

enum Level {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private String name;
    private Level level;

    private MessageHandler handler;

    public Logger(String name, MessageHandler handler, Level level) {
        this.name = name;
        this.handler = handler;
        this.level = level;
    }
    public Logger(String name) {
        this.name = name;
        this.handler = new ConsoleHandler();
        this.level =  Level.DEBUG;
    }
    private static ArrayList<Logger> loggers = new ArrayList<Logger>();

    private Date dateNow = new Date();
    private SimpleDateFormat date = new SimpleDateFormat("yyyy.mm.dd");
    private SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }


    public static Logger getLogger(String name) {
        int index = -1;
        for (Logger logger : loggers) {
            if (Objects.equals(logger.name, name)) {
                index = loggers.indexOf(logger);
            }
        }
        if (index == -1){
            Logger logger = new Logger (name);
            loggers.add(logger);
            return logger;
        }
        return loggers.get(index);
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String pattern, Object... args) {
        log(Level.DEBUG, pattern, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String pattern, Object... args) {
        log(Level.INFO, pattern, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String pattern, Object... args) {
        log(Level.WARNING, pattern, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String pattern, Object... args) {
        log(Level.ERROR, pattern, args);
    }

    public void log(Level level, String message) {
        System.out.println(String.format("[%s] %s %s %s - %s",
                level, date.format(dateNow), time.format(dateNow), name, message));
    }

    public void log(Level level, String pattern, Object... args) {
        System.out.println(String.format("[%s] %s %s %s - %s",
                level, date.format(dateNow), time.format(dateNow), name, String.format(pattern, args)));
    }
}