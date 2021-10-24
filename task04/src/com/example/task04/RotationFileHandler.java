package com.example.task04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private final ChronoUnit rotation;
    String filename;

    public RotationFileHandler(String filename, ChronoUnit rotation) {
        this.filename = filename;
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
        String file = String.format("%s_%s", now, filename);
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
