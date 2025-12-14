
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        String lines = new String(Files.readAllBytes(Paths.get("2/input.txt")));
        String[] ids = lines.split(",");

        executeTwo(ids);
    }

    private static void execute(String[] ids) {

        List<BigInteger> invalidIds = new ArrayList<>();
        BigInteger res = BigInteger.ZERO;

        for (String id : ids) {
            String[] twoIds = id.split("-");
            BigInteger idOne = new BigInteger(twoIds[0]);
            BigInteger idTwo = new BigInteger(twoIds[1]);

            for (BigInteger i = idOne; i.compareTo(idTwo) <= 0; i = i.add(BigInteger.ONE)) {
                System.out.println(i);
                if (!isValidId(i)) {
                    System.out.println("invalid: " + i);
                    invalidIds.add(i);
                }
            }

        }
        for (BigInteger i : invalidIds) {
            res = res.add(i);
            System.out.println("Res = " + res);
        }
        System.out.println("Final result: " + res);

    }

    private static boolean isValidId(BigInteger i) {

        //dela på mitten och verifiera om left=right
        String s = String.valueOf(i);
        int m = s.length() / 2;
        String s1 = s.substring(0, m);
        String s2 = s.substring(m);
        if (s1.equals(s2)) {
            System.out.println("invalid id found:" + i);
        }
        return !s1.equals(s2);
    }

    // PART 2
    private static void executeTwo(String[] ids) {

        List<BigInteger> invalidIds = new ArrayList<>();
        BigInteger res = BigInteger.ZERO;

        for (String id : ids) {
            String[] twoIds = id.split("-");
            BigInteger idOne = new BigInteger(twoIds[0]);
            BigInteger idTwo = new BigInteger(twoIds[1]);

            for (BigInteger i = idOne; i.compareTo(idTwo) <= 0; i = i.add(BigInteger.ONE)) {
                System.out.println(i);
                if (!isValidIdTwo(i)) {
                    System.out.println("invalid: " + i);
                    invalidIds.add(i);
                }
            }

        }
        for (BigInteger i : invalidIds) {
            res = res.add(i);
            System.out.println("Res = " + res);
        }
        System.out.println("Final result: " + res);

    }

    private static boolean isValidIdTwo(BigInteger i) {

        //dela på mitten och verifiera om left=right
        String s = String.valueOf(i);
        int m = s.length() / 2;

        // the largest possible sequece is M amount of digits.
        // 
        String s1 = s.substring(0, m);
        String s2 = s.substring(m);
        if (s1.equals(s2)) {
            System.out.println("invalid id found:" + i);
        }
        return !s1.equals(s2);
    }

}
