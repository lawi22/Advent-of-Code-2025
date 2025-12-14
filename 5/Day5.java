
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {

    private static Map<Long, Long> hm = new HashMap<>();

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
        executePartTwo(ranges, ids);
    }

    public static void execute(List<String> ranges, List<String> ids) {
        List<Long> validIds = new ArrayList<>();
        int validCount = 0;

        //fyll hashmap med ranges
        for (String s : ranges) {
            String[] r = s.split("-");
            long first = Long.parseLong(r[0]);
            long last = Long.parseLong(r[1]);

            rangeMerge(first, last);
        }

        // check ids
        for (String id : ids) {
            Long intId = Long.parseLong(id);
            for (Map.Entry<Long, Long> entry : hm.entrySet()) {
                Long first = entry.getKey();
                Long last = entry.getValue();

                if (intId >= first && intId <= last) {
                    validIds.add(intId);
                    validCount += intId;

                }
            }

        }
        System.out.println(validIds.size());
    }

    // kollar alla entries
    // om en entry har start eller finish inom entrys range;
    // delete entry, och lägg till den nya start eller finish för att skapa ny range
    public static void rangeMerge(long first, long last) {

        long newFirst = first;
        long newLast = last;
        List<Long> removeList = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : hm.entrySet()) {

            if (newFirst <= entry.getValue() + 1 && newLast >= entry.getKey() - 1) {
                newFirst = newFirst < entry.getKey() ? newFirst : entry.getKey();
                newLast = newLast > entry.getValue() ? newLast : entry.getValue();

                removeList.add(entry.getKey());
            }

        }
        for (Long i : removeList) {
            hm.remove(i);
        }

        hm.put(newFirst, newLast);
    }

    public static void executePartTwo(List<String> ranges, List<String> ids) {
        List<Long> validIds = new ArrayList<>();
        int validCount = 0;
        Long amountOfValidKeysInRange = 0l;

        //fyll hashmap med ranges
        for (String s : ranges) {
            String[] r = s.split("-");
            long first = Long.parseLong(r[0]);
            long last = Long.parseLong(r[1]);

            rangeMerge(first, last);
        }

        for (Map.Entry<Long, Long> entry : hm.entrySet()) {

            amountOfValidKeysInRange += (entry.getValue() - entry.getKey() + 1);

        }
        System.out.println(amountOfValidKeysInRange);
    }

}
