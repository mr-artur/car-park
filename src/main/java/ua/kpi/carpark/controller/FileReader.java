package ua.kpi.carpark.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> readFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("fileName should not be null");
        }
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(String.format("File '%s' was not found", fileName));
        }
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .parallel()
                .collect(Collectors.toList());
    }

    public List<String> readFromLine(String fileName, int fromLine) {
        List<String> allLines = readFile(fileName);
        return allLines.subList(fromLine - 1, allLines.size());
    }
}
