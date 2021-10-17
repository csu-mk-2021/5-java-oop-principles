package com.example.task03;

/**
 * Интервал в секундах
 */
public class Seconds implements TimeUnit {

    private final long amount;

    public Seconds(long amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Seconds can't be negative");
        }this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount * 1000;
    }

    @Override
    public long toSeconds() {
        return amount;
    }

    @Override
    public long toMinutes() {
        return Math.round((double)amount / 60d);
    }

    @Override
    public long toHours(){return Math.round(amount / 3600d);}
}
