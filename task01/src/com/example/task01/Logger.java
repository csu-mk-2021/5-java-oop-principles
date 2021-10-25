package com.example.task01;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

enum Levels {DEBUG, INFO, WARNING, ERROR}

public class Logger {
    private static List<Logger> loggers = new ArrayList<>();
    private String Name;
    private Levels level;

    private void addNewLogger() {
        for (Logger e : loggers) {
            if (e.getName() != null && !e.getName().equals(this.getName()))
                loggers.add(this);
        }
    }

    public Logger(String name) {
        this.Name = name;
        loggers.add(this);
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
        addNewLogger();
    }


    public static Logger getLogger(String name) {
        for (Logger e : loggers) {
            if (e.getName() != null && e.getName().equals(name))
                return e;
        }
        return new Logger(name);
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public Levels getLevel() {
        return level;
    }

    public void debug(String message) {
        log(message, Levels.DEBUG);
    }

    public void debug(String message, Object... objects) {
        log(message, Levels.DEBUG, objects);
    }

    public void info(String message) {
        log(message, Levels.INFO);
    }

    public void info(String message, Object... objects) {
        log(message, Levels.INFO, objects);
    }

    public void warning(String message) {
        log(message, Levels.WARNING);
    }

    public void warning(String message, Object... objects) {
        log(message, Levels.WARNING, objects);
    }

    public void error(String message) {
        log(message, Levels.ERROR);
    }

    public void error(String message, Object... objects) {
        log(message, Levels.ERROR, objects);
    }

    public void log(String message, Levels level) {
        if (this.level == null)
            this.level = level;
        if (this.level.compareTo(level) >= 0)
            log(message, this.level, (Object) null);

    }

    public void log(String template, Levels level, Object... objects) {
        if (this.level != null && this.level.compareTo(level) >= 0)
            System.out.printf("[%s] %04d.%02d.%02d %02d:%02d:%02d %s - %s%n",
                    level,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                    Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                    Calendar.getInstance().get(Calendar.MINUTE),
                    Calendar.getInstance().get(Calendar.SECOND),
                    this.getName(),
                    template
            );
    }
}