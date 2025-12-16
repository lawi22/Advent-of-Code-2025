
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("6/input.txt"));

        execute(lines);
    }

    public static void execute(List<String> lines) {

        // map Key= index, Value = numbers to operate on
        Map<Integer, List<Integer>> hm = new HashMap<>();
        String[] operatorList = new String[lines.get(0).length() + 1];
        System.out.println(operatorList.length);
        int indexCount = 0;
        Long total = 0l;

        for (String l : lines) {
            String[] chops = l.trim().split("\\s+");
            System.out.println("NEW CHOPS");
            for (String s : chops) {
                System.out.println(s);
            }

            for (int i = 0; i < chops.length; i++) {
                if (hm.containsKey(i)) {
                    if (isAnOperator(chops[i])) {
                        operatorList[i] = chops[i];
                    } else {
                        hm.get(i).add(Integer.valueOf(chops[i]));
                    }
                    System.out.println("added " + chops[i] + "at index: " + i);

                } else {
                    List<Integer> column = new ArrayList<>();
                    column.add(Integer.valueOf(chops[i]));
                    hm.put(i, column);
                }

            }

            //System.out.println(l);
        }
        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {

            if (operatorList[entry.getKey()].equals("*")) {
                Long curr = 1l;
                for (Integer i : entry.getValue()) {
                    curr *= i;
                }
                total += curr;
            } else if (operatorList[entry.getKey()].equals("+")) {
                Long curr = 0l;
                for (Integer i : entry.getValue()) {
                    curr += i;
                }
                total += curr;
            }
        }
        System.out.println("Total: " + total);
    }

    private static boolean isAnOperator(String s) {
        boolean b = false;
        if (s.equals("*") || s.equals("+")) {
            b = true;
        }
        return b;
    }

    // todo unfinished
    public static void executeTwo(List<String> lines) {

        // map Key= index, Value = numbers to operate on
        Map<Integer, List<Integer>> hm = new HashMap<>();
        String[] operatorList = new String[lines.get(0).length() + 1];
        System.out.println(operatorList.length);
        int indexCount = 0;
        Long total = 0l;

        for (String l : lines) {
            String[] chops = l.trim().split("\\s+");
            System.out.println("NEW CHOPS");
            for (String s : chops) {
                System.out.println(s);
            }

            for (int i = 0; i < chops.length; i++) {
                if (hm.containsKey(i)) {
                    if (isAnOperator(chops[i])) {
                        operatorList[i] = chops[i];
                    } else {
                        hm.get(i).add(Integer.valueOf(chops[i]));
                    }
                    System.out.println("added " + chops[i] + "at index: " + i);

                } else {
                    List<Integer> column = new ArrayList<>();
                    column.add(Integer.valueOf(chops[i]));
                    hm.put(i, column);
                }

            }

            //System.out.println(l);
        }

        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            for (Integer i : entry.getValue()) {
                String s = i.toString();
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {

            if (operatorList[entry.getKey()].equals("*")) {
                Long curr = 1l;
                for (Integer i : entry.getValue()) {
                    curr *= i;
                }
                total += curr;
            } else if (operatorList[entry.getKey()].equals("+")) {
                Long curr = 0l;
                for (Integer i : entry.getValue()) {
                    curr += i;
                }
                total += curr;
            }
        }
        System.out.println("Total: " + total);
    }

}
