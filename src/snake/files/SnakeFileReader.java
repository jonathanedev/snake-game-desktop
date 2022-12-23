package snake.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SnakeFileReader {

    private final static int SCOREBOARD_LENGTH = 5;
    
    public static int[] read(Path path) {
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            int[] scoreboard = new int[SCOREBOARD_LENGTH];
            String line;
            for (int i=0; i<SCOREBOARD_LENGTH; i++) {
                if ((line = bf.readLine()) != null) {
                    try {
                        int num = Integer.parseInt(line.strip());
                        scoreboard[i] = num;
                    } catch (NumberFormatException e) {
                        continue;
                    }
                } else break;
            }
            return scoreboard;
        } catch (IOException e) {
            System.err.println(e);
        }

        return null;
    }
}
