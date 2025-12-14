
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("3/input.txt"));
        execute(lines);
    }

    /*public static void execute(List<String> lines) {

        int tot = 0;

        for (String line : lines) {
            char[] arr = line.toCharArray();
            char[] sorted = arr;
            int highest = 0;
            // dual-pivot quicksort O(N)
            Arrays.sort(sorted);
            System.out.println("highest number: " + sorted[sorted.length - 1]);
        }

    }*/
    public static void execute(List<String> lines) {

        int tot = 0;

        for (String line : lines) {
            char[] arr = line.toCharArray();
            // högst
            char h = '0';
            int hIndex = 0;
            // andra högst
            char sh = '0';

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > h) {
                    System.out.println("new highest: " + arr[i]);
                    h = arr[i];
                    hIndex = i;
                }
            }
            for (int i = hIndex + 1; i < arr.length; i++) {
                if (arr[i] >= sh) {
                    System.out.println("second highest: " + arr[i]);
                    sh = arr[i];
                }
            }
            int res = Integer.parseInt("" + h + sh);

            tot += res;

        }
        System.out.println(tot);

    }

}
