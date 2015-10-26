package com.kirillrublevsky;

import java.util.*;

/**
 * Class WordFinder contains one public static method to find the longest complex word in the array, and two private
 * utility methods.
 */
public final class WordFinder {

    /**
     * Don't let anyone instantiate this class.
     */
    private WordFinder() {}

    /**
     * Returns String - the longest complex word of the input array of Strings. Logic performed step by step:
     * 1. Create String longestWord and initialize it with first word of the array (because in can't be null);
     * 2. Create List of all complex words of the input array using utility method;
     * 3. In the loop compare all words by length and find the longest one;
     * 4. Return it.
     *
     * @param inputArray input array of Strings
     * @return String the longest complex word
     */
    public static String findTheLongestComplexWord(String[] inputArray) {
        String longestWord = inputArray[0];
        List<String> complexWords = findAllComplexWords(inputArray);
        for (String word : complexWords) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    /**
     * Private utility method. Returns List of all complex words of the input array. Uses other private utility method.
     * Logic performed step by step:
     * 1. Create empty List of complex words;
     * 2. Sort all words of the input array by length in descending order using LengthComparator class;
     * 3. In the loop check if each word in the array is complex using utility method isComplexWord();
     * 4. If true, current word is added to the complexWords list and this list is returned as output.
     *
     * @param inputArray array of Strings to process
     * @return List<String> List of all complex words
     */
    private static List<String> findAllComplexWords(String[] inputArray) {
        List<String> complexWords = new ArrayList<>();
        Arrays.sort(inputArray, new LengthComparator());
        for (String word : inputArray) {
            if (isComplexWord(word, inputArray)) {
                complexWords.add(word);
            }
        }
        return complexWords;
    }

    /**
     * Private utility method. Returns boolean - is input String a complex word or not. The main idea of the method
     * is to check in the loop if input word contains any other words from the array, except itself. Going through
     * the loop we check if contains - if yes, remove this word (sequence of chars) from the word and go further.
     * If the word becomes empty it means that this word is complex because it completely consists of other words
     * of the array. We start the loop with the longest word to avoid mistakes. The array is already sorted by length in
     * descending order. Logic performed step by step:
     * <p/>
     * 1. Create temporary String - in the loop we will change its contents (actually we change the object the
     * reference points to because the String is immutable, but using StringBuilder here complicates the program);
     * 2. In the loop check if current element is equal to the input word - if yes just continue to the next iteration;
     * 3. If element is not equal to itself we check if replaceable word contains current element - if yes we remove it
     * from the contents of the replaceable word;
     * 4. Then check if replaceable word is empty - if yes, we return true, it means that this word is complex;
     * 5. If the word is not empty we go to the next iteration and check if replaceable word contains next word of the
     * array;
     * 6. If loop ends and the word is not empty we return false - it means that the word is not complex and does not
     * completely consist of other words of the array.
     *
     * @param word  String to process - if it contains other words of the array
     * @param words String array to process
     * @return boolean is input word complex or not
     */
    private static boolean isComplexWord(String word, String[] words) {
        String replaceableWord = word;
        for (String element : words) {
            if (element.equals(word)) {
                continue;
            } else if (replaceableWord.contains(element)) {
                replaceableWord = replaceableWord.replaceAll(element, "");
                if (replaceableWord.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}