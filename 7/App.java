
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {

    // solution 1, no recursion
    public static void main(String[] args) throws IOException {

        //int answer = BeamCounter.execute();
        List<String> lines = Files.readAllLines(Paths.get("7/input.txt"));

        //BeamCounter.quantumExecute(lines, 0);
        System.out.println(BeamCounter.countTimelines(lines));
        //System.out.println(answer);
    }
}
