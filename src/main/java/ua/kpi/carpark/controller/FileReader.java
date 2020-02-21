package ua.kpi.carpark.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artur Morozov on 2020-02-16
 */
public class FileReader {

    /**
     * Returns list of lines read from file
     *
     * @param fileName name of file in resources
     * @return lines read from file
     */
    public List<String> readFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException(Constants.FILENAME_IS_NULL);
        }
        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(
                    String.format(Constants.INPUT_STREAM_IS_NULL, fileName)
            );
        }
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .parallel()
                .collect(Collectors.toList());
    }

    /**
     * Returns list of lines read from file starting from n line
     *
     * @param fileName name of file in resources
     * @param fromLine number of start line (min 1)
     * @return lines read from file
     */
    public List<String> readFromLine(String fileName, int fromLine) {
        List<String> allLines = readFile(fileName);
        return allLines.subList(fromLine - 1, allLines.size());
    }
}
