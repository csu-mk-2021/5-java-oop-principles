package com.example.task03;

import java.sql.SQLOutput;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Milliseconds(2000);
        System.out.println(unit1.toSeconds());;
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
    }
}
