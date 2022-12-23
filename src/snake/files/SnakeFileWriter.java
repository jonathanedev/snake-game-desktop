package snake.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SnakeFileWriter {

    public static void write(Path path, int[] scores) {
        try (BufferedWriter bf = Files.newBufferedWriter(path)) {
            for (int i=0; i<scores.length; i++) {
                bf.write("" + scores[i]);
                bf.newLine();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
