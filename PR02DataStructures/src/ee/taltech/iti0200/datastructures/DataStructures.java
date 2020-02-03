
package ee.taltech.iti0200.datastructures;
import java.lang.reflect.Array;
import java.util.*;

public class DataStructures {

    /**
     * Given String is a sentence with some words.
     * There are only single whitespace between every word and no punctuation marks.
     * Also there are no capital letters in input string.
     * <p>
     * Return the longest word from the input sentence.
     * <p>
     * If there are more than one word with the same length then return the word which comes alphabetically first.
     * <p>
     * Hints:
     * You can split words into an array using "str.split()"
     * Sorting the list with the longest words can definitely help you to find the word which comes alphabetically first.
     *
     * @param sentence input String to find the longest words
     * @return the longest String from input
     */
    public static String findLongestWord(String sentence) {
        String theLongest = "";
        String[] arrayOfWords = sentence.split(" ");
        Arrays.sort(arrayOfWords);
        for (String word : arrayOfWords) {
            if (word.length() > theLongest.length()) {
                theLongest = word;
            }
        }
        return theLongest;
    }


    /**
     * Imagine yourself as a librarian who needs to rearrange a bookshelf in the library.
     * <p>
     * You have an input List with book name and author.(in format [Name-Author])
     * If the first letter of the book name and the author name are the same (case-insensitive)
     * then you need to put the book (name) on left part of the shelf (before every other book),
     * if not then on the right part (after every other book).
     * The list will contain book names (and a separator).
     * <p>
     * <p>
     * Shelf separator is "][". It will be a separate element in your list.
     * There is always exactly one separator in your result list.
     * So if the bookshelf is empty it should look like [][] when printing out.
     * If there is one book on the left side then: [Raamat, ][]
     * If there are books on both sides then: [LeftBook, ][, RightBook]
     * <p>
     * To add smth to the beginning of the list or to the end take a look at LinkedList data structure.
     * For example list.addFirst() can help you.
     * <p>
     * There are some examples below.
     * <p>
     * PS. BE CAREFUL WITH CAPITAL AND NON-CAPITAL LETTERS!
     *
     * @param books input List to locate correctly.
     * @return List of book names located correctly
     */
    public static List<String> rearrangeTheShelf(List<String> books) {
        LinkedList<String> bookList = new LinkedList<String>();
        String bookName;
        bookList.add("][");
        for (int i = 0; i < books.size(); i++) {
            String book = books.get(i);
            for (int x = 0; x < book.length(); x++) {
                Character firstChar = Character.toLowerCase(book.charAt(0));
                Character secondChar = book.charAt(x);
                if (x == 0) {
                    continue;
                } else if (secondChar.equals('-') && firstChar.equals(Character.toLowerCase(book.charAt(x + 1)))) {
                    bookName = book.substring(0, x);
                    bookList.addFirst(bookName);
                    break;
                } else if (secondChar.equals('-')) {
                    bookName = book.substring(0, x);
                    bookList.addLast(bookName);
                    break;
                }
            }
        }
        return bookList;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that the string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, Integer> mapOfWords = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!mapOfWords.containsKey(word)) {
                mapOfWords.put(word, 1);
            } else if (mapOfWords.containsKey(word)) {
                int amount = mapOfWords.get(word);
                mapOfWords.put(word, amount + 1);
            }
        }
        for (Map.Entry mapElement : mapOfWords.entrySet()) {
            int value = ((int)mapElement.getValue());
            String key = ((String)mapElement.getKey());
            int howMany = value / 2;
            for (int z = 0; z < howMany; z++) {
                    answer.add(key);
            }
        }
        Collections.reverse(answer);
        return answer;
    }


    public static void main(String args[]) {
        //System.out.println(findLongestWord("nimi on salastatud"));  // "salastatud"
        //System.out.println(findLongestWord("aaa bbbbb"));  // "bbbbb"
        //System.out.println(findLongestWord("hello ahllo")); // "ahllo"


        //System.out.println(rearrangeTheShelf(Arrays.asList("Raamat1-Autor1", "Raamat2-Raamatu2Autor"))); // [Raamat2, ][, Raamat1]
        //System.out.println(rearrangeTheShelf(Arrays.asList("Raamat1-Autor1", "Raamat2-Raamatu2Autor")).get(1));  // ][
        //System.out.println(rearrangeTheShelf(Arrays.asList("seiklused metsas-Saimon", "Kodumaa-Karl Gustav ", "Raamat3-Tundmatu")));  //  [Kodumaa, seiklused metsas, ][, Raamat3]
        //System.out.println(rearrangeTheShelf(Arrays.asList("Book-bob",  "raamat-Romeo", "story-teller", "teine-name", "name-nbook"))); // [name, raamat, Book, ][, story, teine]

        System.out.println(onlyEvenWords(Arrays.asList("foo", "bar", "baz", "baz", "bar", "foo"))); // [baz, bar, foo]
        //System.out.println(onlyEvenWords(Arrays.asList("a", "b", "b", "a"))); // [b, a]
        //System.out.println(onlyEvenWords(Arrays.asList("eggs", "bacon", "SPAM", "ham", "SPAM", "SPAM"))); // [SPAM]
    }


}

