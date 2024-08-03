package com.example;

import java.io.IOException;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    private static void generateFile(String fileName, int size, int numPositive) throws IOException {
        Cache c = new Cache(size);
        Random rand = new Random();
        for (int i = 0; i < numPositive; ++i) {
            c.set(Encoder.numIdToStr(rand.nextInt(size)));
        }
        c.save(fileName);
    }

    public static void main(String[] args) throws IOException {
        final String fileName = "/tmp/a.gz";
        final int fileSize = Encoder.maxNumId;

        if (args.length > 0) {
            if (args[0].equals("-g")) {
                System.out.println("Generate File: " + fileName);
                App.generateFile(fileName, fileSize, fileSize / 10);
            } else if (args[0].equals("-r")) {
                System.out.println("read");
            } else {
                System.out.println("unknown");
            }
        }

    }
}
