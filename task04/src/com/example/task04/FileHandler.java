package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private FileWriter writer;

    public FileHandler(String path) {
        try {
            this.writer = new FileWriter(path, true);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Override
    public void printMessage(String message) {
        try {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
