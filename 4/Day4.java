
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("4/input.txt"));

        execute(lines);

    }

    private static void execute(List<String> lines) {

        List<List<Boolean>> mtx = new ArrayList<>();

        for (int i = 0; i <= lines.size(); i++) {
            char[] arr = lines.get(i).toCharArray();

            for (int j = 0; j <= arr.length; i++) {

                mtx.add(i, element);
                mtrx[i][j] = arr[j] == '@' ? true : false;
            }

        }

        System.out.println(mtrx);
    }

}
