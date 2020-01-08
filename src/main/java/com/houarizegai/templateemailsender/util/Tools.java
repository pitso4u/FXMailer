package com.houarizegai.templateemailsender.global;

import java.io.File;
import java.util.Scanner;

public class Utils {

    public static String loadFile(String pathname) {
        try {
            File file = new File(Constants.HTML_TEMPLATE_LOCATION + pathname + ".txt");

            StringBuilder fileContents = new StringBuilder((int) file.length());

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    fileContents.append(scanner.nextLine() + System.lineSeparator());
                }
                return fileContents.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String replaceString(String input, String... replace) {
        for(int i = 0; i < replace.length; i++)
            input = input.replaceFirst("%s", replace[i]);

        return input;
    }
}
