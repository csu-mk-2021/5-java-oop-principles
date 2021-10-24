package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в секундах в интервал в миллисекундах
     *
     * @param seconds интервал в секундах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(Seconds seconds) {
        return new Milliseconds(seconds.toMillis());
    }
    /**
     * Конвертирует интервал в секундах в интервал в минутах
     *
     * @param seconds интервал в секундах
     * @return интервал в минутах
     */
    public static Minutes toMinutes(Seconds seconds) {
        return new Minutes(seconds.toMinutes());
    }
    /**
     * Конвертирует интервал в секундах в интервал в часах
     *
     * @param seconds интервал в секундах
     * @return интервал в часах
     */
    public static Hours toHours(Seconds seconds) {
        return new Hours(seconds.toHours());
    }

    /**
     * Конвертирует интервал в миллисекундах в интервал в секундах
     *
     * @param millis интервал в миллисекундах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(Milliseconds millis) {
        return new Seconds(millis.toSeconds());
    }
    /**
     * Конвертирует интервал в миллисекундах в интервал в минутах
     *
     * @param millis интервал в миллисекундах
     * @return интервал в минутах
     */
    public static Minutes toMinutes(Milliseconds millis) {
        return new Minutes(millis.toMinutes());
    }
    /**
     * Конвертирует интервал в миллисекундах в интервал в часах
     *
     * @param millis интервал в миллисекундах
     * @return интервал в часах
     */
    public static Hours toHours(Milliseconds millis) {
        return new Hours(millis.toHours());
    }

    /**
     * Конвертирует интервал в минутах в интервал в миллисекундах
     *
     * @param mins интервал в минутах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(Minutes mins) {
        return new Milliseconds(mins.toMillis());
    }
    /**
     * Конвертирует интервал в минутах в интервал в секундах
     *
     * @param mins интервал в минутах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(Minutes mins) {
        return new Seconds(mins.toSeconds());
    }
    /**
     * Конвертирует интервал в минутах в интервал в часах
     *
     * @param mins интервал в минутах
     * @return интервал в часах
     */
    public static Hours toHours(Minutes mins) {
        return new Hours(mins.toHours());
    }


    /**
     * Конвертирует интервал в часах в интервал в миллисекундах
     *
     * @param hours интервал в часах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(Hours hours) {
        return new Milliseconds(hours.toMillis());
    }
    /**
     * Конвертирует интервал в часах в интервал всекундах
     *
     * @param hours интервал в часах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(Hours hours) {
        return new Seconds(hours.toSeconds());
    }
    /**
     * Конвертирует интервал в часах в интервал в минутах
     *
     * @param hours интервал в часах
     * @return интервал в минутах
     */
    public static Minutes toMinutes(Hours hours) {
        return new Minutes(hours.toMinutes());
    }
}
