package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test", new FileHandler(), 0);
        logger.info("test1");
        logger.info("test2");
        logger.info("test3");
    }
}
