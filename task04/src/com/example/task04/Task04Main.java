package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("test");
        log.addHandler(new FileHandler("C:/java/file.txt"));
        log.setLevel(Level.WARNING);
        log.debug("mes1");
        log.info("mes2");
        log.warning("mes3");
        log.error("mes4");
    }
}
