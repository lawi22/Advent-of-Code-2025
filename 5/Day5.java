
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day5 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("5/input.txt"));
        List<String> ranges = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        boolean idTime = false;

        for (String line : lines) {
            if (idTime) {
                ids.add(line);
            }
            if (line.isEmpty()) {
                idTime = true;
            }
            if (!idTime) {
                ranges.add(line);
            }

        }
        execute(ranges, ids);
    }

    private static void execute(List<String> ranges, List<String> ids) {

    }
}
