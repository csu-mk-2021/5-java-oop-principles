package com.example.task04;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileHandler implements MessageHandler {

    String filename;

    public FileHandler() {
        this("latest.log");
    }

    public FileHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try(FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
