package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    private static final String FILENAME = "evidence.csv";

    public static void saveData(String data) throws IOException {
        FileWriter fw = new FileWriter(FILENAME);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(data);
        bw.close();
        fw.close();
    }

    public static String loadData() throws IOException {
        return new String(Files.readAllBytes(Paths.get(FILENAME)));
    }
}
