package com.redfox.pheonix_fox.builder.batpu_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PFBuilder {
    private static String input;
    public static void main(String[] args) {
        if (args.length == 2) {
            if (args[1].toLowerCase().endsWith(".pxf") || args[0].toLowerCase().endsWith(".pfx")) {
                File inputFile = new File(args[0]);
                input = readFile(inputFile);

                System.out.println("\nInput: " + getInput());
            } else System.out.println("Error! Not the right file type. PheonixFox src files ends with '.pxf' or '.pfx'");
        } else System.out.println("Error! Not the right amount of args");
    }

    public static String readFile(File input) {
        StringBuilder output = new StringBuilder();

        if (input.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(input))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("src Line: " + line);

                    output.append(line).append(" ");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return output.toString();
    }

    public static String getInput() {
        return input;
    }
}
