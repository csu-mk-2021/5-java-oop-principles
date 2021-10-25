package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test", new FileHandler("test.log"), Level.DEBUG);
        logger.info("test1");
        logger.info("test2");
        logger.info("test3");
    }
}
