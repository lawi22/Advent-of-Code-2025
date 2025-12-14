
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("1/input.txt"));

        execute(lines);
    }

    public static void execute(List<String> lines) {
        int i = 50;
        int count = 0;
        int partTwoCount = 0;
        System.out.println("Dial starts at 50");

        for (String l : lines) {
            int value = Integer.parseInt(l.substring(1));
            if (l.toCharArray()[0] == 'R') {

                i += value;
                if (i > 99) {
                    int hundreds = i / 100;
                    hundreds = hundreds == 0 ? 1 : hundreds;
                    i = i - 100 * hundreds;
                    System.out.println("Dial is rotated " + value + " and hits zero " + hundreds + " times");
                    partTwoCount += hundreds;

                }
            }
            if (l.toCharArray()[0] == 'L') {
                i -= value;
                if (i < 0) {
                    int hundreds = i / -100;
                    hundreds = hundreds == 0 ? 1 : hundreds;
                    i = i + 100 * hundreds;
                    System.out.println("Dial is rotated " + value + " and hits zero " + hundreds + " times");
                    partTwoCount += hundreds;
                }
            }
            System.out.println("Dial at " + i);
            /*if (i == 0) {

                partTwoCount++;
            }*/
        }
        System.out.println(partTwoCount);
    }
}
