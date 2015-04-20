package com.amadeussoft.sbtsearch.managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Artem on 20.04.2015.
 */
public class InputHelper {

    public int[] readIntValuesArray() throws NumberFormatException {
        int[] result = null;
        String line = readLineFromStream();
        if (line != null) {
            try {
                String[] stringValues = line.split(",");
                int[] parsedValues = new int[stringValues.length];
                int index = 0;
                for (String stringValue : stringValues) {
                    parsedValues[index++] = Integer.parseInt(stringValue);
                }
                result = parsedValues;
            } catch (NumberFormatException e) {
                System.out.print("Values was entered in wrong format. Please, try again.\n");
            }
        }
        return result;
    }

    public Integer readIntValue() {
        Integer result = null;
        try {
            String stringValue = readLineFromStream();
            result = Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            System.out.print("Values was entered in wrong format. Please, try again.\n");
        }
        return result;
    }

    private String readLineFromStream() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
            line = line.replace(" ", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}