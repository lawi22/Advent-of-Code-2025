
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public static void execute() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("10/input.txt"));
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();

        for (String line : lines) {
            String[] r = line.split(" ");
        }

    }

}
