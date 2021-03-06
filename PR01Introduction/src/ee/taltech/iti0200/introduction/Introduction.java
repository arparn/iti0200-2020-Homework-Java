package ee.taltech.iti0200.introduction;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Introduction {


    /**
     * Method gets a string that contains x words.
     * The first character of the string starts a new word, next words always start with a capital letter.
     * Words are not separated by whitespace.
     * Words (including the first character) can contain all kinds of symbols.
     * The function should find and return  x.
     *
     * @param string Given string that contains x words.
     * @return The number of words in the given string.
     */
    public int camelCaseWordCounter(String string) {
        if (string.length() == 0) {
            return 0;
        }
        int answer = 1;
        for (int i = 1; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                answer += 1;
            }
        }
        return answer;
    }

    /**
     * Method gets a list of numbers.
     * Return a list containing only even numbers of the given list.
     * If the given list does not contain any even numbers, return an empty list.
     *
     * @param numbers given list that contains numbers.
     * @return list of even numbers.
     */
    public List<Integer> findEvenNumbersList(List<Integer> numbers) {
        List<Integer> answer = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                answer.add(number);
            }
        }
        return answer;
    }

    /**
     * Method gets an array of numbers.
     * Return an array containing only even numbers of the given array.
     * If the given array does not contain any even numbers, return an empty array.
     *
     * You must not use the previous function in this function!
     *
     * @param numbers given array that contains numbers.
     * @return array of even numbers.
     */
    public int[] findEvenNumbersArray(int[] numbers) {
        List<Integer> nums2 = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                nums2.add(numbers[i]);
            }
        }
        int[] answer = new int[nums2.size()];
        for (Integer number: nums2) {
            answer[index] = number;
            index += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Introduction introduction = new Introduction();
        System.out.println(introduction.camelCaseWordCounter("AsDgvhGasd")); // 3

        List<Integer> nums = new ArrayList<>(Arrays.asList(4, 8, 6, 2, 1, 2, -2, 0));
        System.out.println(introduction.findEvenNumbersList(nums)); // [4, 8, 6, 2, 2, -2, 0]

        int[] array = {9, 0, 24, -6, 3, 4};
        System.out.println(Arrays.toString(introduction.findEvenNumbersArray(array))); // [0, 24, -6, 4]
    }
}
