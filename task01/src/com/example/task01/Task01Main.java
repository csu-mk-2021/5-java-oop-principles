package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test", Logger.Level.ERROR);
        logger.error("test");
    }
}
