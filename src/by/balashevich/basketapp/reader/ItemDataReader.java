package by.balashevich.basketapp.reader;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDataReader {
    private final String DEFAULT_PATH = "input/inputData.txt";

    public List<String> readerAllData(String filename) {
        File file = new File(filename);
        List<String> dataLines;

        if (!file.canRead()) {
            file = new File(DEFAULT_PATH);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            dataLines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file", e);
        }

        return dataLines;
    }
}