package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {

    private final MessageHandler handler;
    private final long bufferSize;
    private List<String> buffer = new ArrayList<>();

    public MemoryHandler(MessageHandler handler, long bufferSize) {
        this.handler = handler;
        this.bufferSize = bufferSize;
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= bufferSize) {
            for (String str : buffer)
                handler.log(str);
            buffer.clear();
        }
    }
}
