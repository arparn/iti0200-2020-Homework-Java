package ee.taltech.iti0200.tk1;

import java.util.List;
import java.util.Map;
public class Exam {

    /**
     * Return the sum of the numbers in the array,
     * except ignore sections of numbers
     * starting with a 6 and extending to the next 7
     * (every 6 will be followed by at least one 7).
     * Return 0 for no numbers.
     *
     * sum67([1, 2, 2]) => 5
     * sum67([1, 2, 2, 6, 99, 99, 7]) => 5
     * sum67([1, 1, 6, 7, 2]) => 4
     */
    public static int sum67(List<Integer> numbers) {
        Boolean start = false;
        Integer sumOfNumbers = 0;
        for (Integer number : numbers) {
            if (start == false && number != 6) {
                sumOfNumbers += number;
            } else if (number == 6) {
                start = true;
            } else if (start == true && number == 7) {
                start = false;
            }
        }
        return sumOfNumbers;
    }

    /**
     * Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca".
     * Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
     *
     * oneTwo("abc") => "bca"
     * oneTwo("tca") => "cat"
     * oneTwo("tcagdo") => "catdog"
     */
    public static String oneTwo(String str) {
        String a = "";
        String b = "";
        String c = "";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!a.equals("") && !b.equals("") && !c.equals("")) {
                result.append(b).append(c).append(a);
                a = "";
                b = "";
                c = "";
            } else if (i == 0 || a.equals("")) {
                a = String.valueOf(str.charAt(i));
            } else if (b.equals("")) {
                b = String.valueOf(str.charAt(i));
            } else if (c.equals("")) {
                c = String.valueOf(str.charAt(i));
            }
        }
        if (!a.equals("") && !b.equals("") && !c.equals("")) {
            result.append(b).append(c).append(a);
        return String.valueOf(result);
    }

    /**
     * Modify and return the given map as follows:
     * if exactly one of the keys "a" or "b" exists in the map (but not both), set the other to have that same value in the map.
     *
     * mapAXorB({"a": "aaa", "c": "cake"}) => {"a": "aaa", "b": "aaa", "c": "cake"}
     * mapAXorB({"b": "bbb", "c": "cake"}) => {"a": "bbb", "b": "bbb", "c": "cake"}
     * mapAXorB({"a": "aaa", "b": "bbb", "c": "cake"}) => {"a": "aaa", "b": "bbb", "c": "cake"}
     */
    public static Map<String, String> mapAXorB(Map<String, String> map) {
        return null;
    }
}
