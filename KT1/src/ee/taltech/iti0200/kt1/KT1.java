package ee.taltech.iti0200.kt1;

import java.util.LinkedList;
import java.util.List;

public class KT1 {
    /**
     * Given a non-empty array of integers,
     * every element appears twice except for one. Find that single one.
     * If there are not such (and in any other case) return 0.
     *
     * singleNumber([2,2,1]) => 1
     * singleNumber([4,1,2,1,2]) => 4
     */
    public static int singleNumber(int[] nums) {
        List<Integer> ints = new LinkedList<>();
        List<Integer> ints2 = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();
        for (Integer num : nums) {
            if (!ints.contains(num)) {
                ints.add(num);
            } else {
                ints2.add(num);
            }
        }
        for (Integer num : ints) {
            if (!ints2.contains(num)) {
               answer.add(num);
            }
        }
        if (answer.size() == 1) {
            return answer.get(0);
        } else {
            return 0;
        }
    }
}
