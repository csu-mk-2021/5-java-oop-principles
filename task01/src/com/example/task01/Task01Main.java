package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("log1");
        Logger logger2 = Logger.getLogger("log2");
        logger1.setLevel(Level.WARNING);
        logger2.setLevel(Level.DEBUG);
        logger1.info("low level test");
        logger2.error("up level test");
    }
}
