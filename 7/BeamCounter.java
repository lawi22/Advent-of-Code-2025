
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeamCounter {

    // split string by nextline into array
    // create array "beamLine"
    // get index of S in string (say X for example) at index 0 of the splitted array, begin. add index to beamline
    // check index of S in next string in array
    // if index = ^, then:
    // if X+1 or X-1 already in array, skip
    // elif add X-1 and X+1 into array
    // recursive call back.
    //String[] lines = big.split("\n");
    public static int execute() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("7/input.txt"));
        Set<Integer> beamLine = new HashSet<>();
        int count = 0;

        for (int i = 0; i < lines.size(); i++) {
            char[] currentLine = lines.get(i).toCharArray();
            for (int j = 0; j < currentLine.length; j++) {
                char currentSymbol = currentLine[j];
                if (currentSymbol == 'S') {

                    beamLine.add(j);
                } else if (currentSymbol == '^') {
                    if (beamLine.contains(j)) {
                        count++;
                        // todo: ifs kanske inte necessary, för logging bara nu
                        if (!beamLine.contains(j + 1)) {
                            beamLine.add(j + 1);
                        }
                        if (!beamLine.contains(j - 1)) {
                            beamLine.add(j - 1);
                        }
                        beamLine.remove(j);
                    }

                }
                if (beamLine.contains(j)) {
                    currentLine[j] = '|';
                }
            }
            System.out.println(currentLine);

        }
        return count;
    }

    public static void quantumExecute(List<String> lines, int index) throws IOException {
        //List<String> lines = Files.readAllLines(Paths.get("7/input.txt"));
        Set<Integer> beamLine = new HashSet<>();
        int count = 0;
        int timelineAmount = 1;

        for (int i = index; i < lines.size(); i++) {
            char[] currentLine = lines.get(i).toCharArray();
            for (int j = 0; j < currentLine.length; j++) {
                char currentSymbol = currentLine[j];
                if (currentSymbol == 'S') {

                    beamLine.add(j);
                } else if (currentSymbol == '^') {
                    if (beamLine.contains(j)) {
                        count++;

                        // when it reaches it, split in two
                        // 
                        if (!beamLine.contains(j + 1) && !beamLine.contains(j - 1)) {
                            timelineAmount++;
                            List<String> newLines = lines;
                            newLines.remove(i);
                            quantumExecute(newLines, index++);
                            beamLine.add(j + 1);
                        } else if (!beamLine.contains(j - 1)) {
                            beamLine.add(j - 1);
                        } else if (!beamLine.contains(j + 1)) {
                            beamLine.add(j + 1);

                        }
                        beamLine.remove(j);
                    }

                }
                if (beamLine.contains(j)) {
                    currentLine[j] = '|';
                }
            }
            //System.out.println(currentLine);

        }
        System.out.println(timelineAmount);
    }

    public static long countTimelines(List<String> grid) {
        int rows = grid.size();
        if (rows == 0) {
            return 0;
        }
        int cols = grid.get(0).length();

        // Find starting position
        int startRow = -1, startCol = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid.get(r).charAt(c) == 'S') {
                    startRow = r;
                    startCol = c;
                }
            }
        }

        // dp[r][c] = number of ways to reach row r, col c
        long[][] dp = new long[rows][cols];
        dp[startRow][startCol] = 1;

        for (int r = startRow; r < rows - 1; r++) {
            for (int c = 0; c < cols; c++) {
                if (dp[r][c] == 0) {
                    continue;
                }

                char cell = grid.get(r).charAt(c);

                if (cell == '^') {
                    // Splitter: send to left, straight, right on next row
                    if (c - 1 >= 0) {
                        dp[r + 1][c - 1] += dp[r][c];
                    }
                    dp[r + 1][c] += dp[r][c];
                    if (c + 1 < cols) {
                        dp[r + 1][c + 1] += dp[r][c];
                    }
                } else {
                    // Normal: continue straight down
                    dp[r + 1][c] += dp[r][c];
                }
            }
        }

        // Sum all timelines on the last row
        long total = 0;
        for (int c = 0; c < cols; c++) {
            total += dp[rows - 1][c];
        }

        return total;
    }
}
