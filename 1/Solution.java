
import java.util.List;

public class Solution {

    public static void execute(List<String> lines) {
        int i = 50;

        for (String l : lines) {
            int value = Integer.parseInt(l.substring(1));
            if (l.toCharArray()[0] == 'R') {

                int hundreds = value % 100;
                i += value - hundreds;

            }
            if (l.toCharArray()[0] == 'L') {

                int hundreds = value % 100;
                i -= value - hundreds;

            }
        }
        System.out.println(i);
    }
}
