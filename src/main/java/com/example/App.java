package com.example;

import java.io.IOException;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    private static void generateFile(String fileName, int size, int numPositive) throws IOException {
        System.out.println("Generate File: " + fileName);

        Cache c = new Cache(size);
        Random rand = new Random();
        for (int i = 0; i < numPositive; ++i) {
            c.set(Encoder.numIdToStr(rand.nextInt(size)));
        }
        c.set("000AA");
        c.save(fileName);
    }

    private static void readFile(String fileName, int size) throws IOException {
        System.out.println("Read File: " + fileName);

        long startTime = System.nanoTime();
        Cache c = new Cache(fileName, size);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Duration (nano): " + Long.toString(duration));
        System.out.println(c.has("000AA"));
    }

    public static void main(String[] args) throws IOException {
        final String fileName = "/tmp/a.gz";
        final int fileSize = Encoder.maxNumId;

        if (args.length > 0) {
            if (args[0].equals("-g")) {
                App.generateFile(fileName, fileSize, fileSize / 10);
            } else if (args[0].equals("-r")) {
                App.readFile(fileName, fileSize);
            } else {
                System.out.println("unknown argument");
            }
        }
    }
}
