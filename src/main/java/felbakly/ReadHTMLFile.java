package felbakly;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadHTMLFile {
    StringBuilder sb;
    BufferedReader br;

    ReadHTMLFile(String inputFile) {
        sb = new StringBuilder();
        try {
            br = Files.newBufferedReader(Paths.get(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        var line = "";

        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFileContent() {
        return sb.toString();
    }
}
