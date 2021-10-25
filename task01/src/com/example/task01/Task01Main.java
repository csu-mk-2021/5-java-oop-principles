package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getLogger("test");
        Logger log2 = Logger.getLogger("test");
        System.out.println(log1 == log2);
        log1.debug("Test");
        log1.error("Test");
        log1.warning("Test");
        log1.info("Test");
        log1.info("%s, %s", "Testtest", "123");
        log1.log(Level.DEBUG, "Hello, %s", "world");
    }
}
