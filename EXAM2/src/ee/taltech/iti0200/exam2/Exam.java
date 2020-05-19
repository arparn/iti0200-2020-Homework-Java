package ee.taltech.iti0200.exam2;

public class Exam {

    /**
     * Write a recursive method which finds all the double and triple consecutive characters in the string.
     * Triple consecutive characters give 2 points.
     * Double consecutive characters give 1 point,
     * Sums all the combinations and returns the sum.
     * NB! Method must be recursive and not contain any for loops.  Helper functions  and are not allowed.
     *
     * "abc" => 0
     * "aa" => 1
     * "aab" => 1
     * "aaa" => 2
     * "aaabb" => 3
     * "aaaaaa" => 4 (2 times triple 'a', NOT 3 times double 'a')
     * "" => 0
     */
    public static int recCount(String s) {
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        boolean check = true;
        try {
            int num = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
        } catch (NumberFormatException x) {
            check = false;
        }
        if (!check) {
            int sum = 0;
            char ch = s.charAt(0);
            if (s.charAt(1) == ch) {
                sum += 1;
                s = s.substring(1);
            }
            if (s.charAt(1) == ch) {
                sum += 1;
                s = s.substring(2);
            }
            s += sum;
            return recCount(s);
        }
        if (check) {
            int sum = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
            s = s.substring(s.length() - 1);
            char ch = s.charAt(0);
            if (s.charAt(1) == ch) {
                sum += 1;
                s = s.substring(1);
            }
            if (s.charAt(1) == ch) {
                sum += 1;
                s = s.substring(1);
            }
            s += sum;
            return recCount(s);
        }
        return 0;
    }
}

