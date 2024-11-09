package com.redfox.pheonix_fox.builder.batpu_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PFBuilder {
    public static final String ANSI_reset = "\033[0m";
    public static final String ANSI_aqua = "\033[96m";

    private static String src;
    private static String srcPreCompiled;
    public static void main(String[] args) {
        if (args.length == 1) {
            if (args[0].toLowerCase().endsWith(".pxf") || args[0].toLowerCase().endsWith(".pfx")) {
                File inputFile = new File(args[0]);
                src = readFile(inputFile);
                srcPreCompiled = PreCompile(src);

                System.out.println("\nInput: \n" + ANSI_aqua + src + ANSI_reset);
                System.out.println("Precompiler: \n" + ANSI_aqua + srcPreCompiled + ANSI_reset);
            } else System.out.println("Error! Not the right file type. PheonixFox src files ends with '.pxf' or '.pfx'");
        } else System.out.println("Error! Not the right amount of args");
    }

    public static String readFile(File input) {
        StringBuilder output = new StringBuilder();

        if (input.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(input))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("src Line: " + ANSI_aqua + line + ANSI_reset);
                    output.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return output.toString();
    }

    public static String PreCompile(String src) {
        //commenter
        String commentedSrc = src.replaceAll("(?<!\\\\)//.*|(?<!\\\\)/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", ""); //"(?s)((?<!\\\\)//[^\\n]*)|((?<!\\\\)/\\*.*?(?<!\\\\)\\*/)"
        System.out.println("%Precompiler : Removed comments of src: \n" + ANSI_aqua + src + ANSI_reset + "\n\tNew String: \n" + ANSI_aqua + commentedSrc + ANSI_reset);

        return commentedSrc;
    }
}
