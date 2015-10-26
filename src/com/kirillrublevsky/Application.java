package com.kirillrublevsky;

import java.util.Arrays;

import static com.kirillrublevsky.WordFinder.findTheLongestComplexWord;

/**
 * Class Application contains main() method that runs application.
 */
public final class Application {

    /**
     * Don't let anyone instantiate this class.
     */
    private Application() {}

    /**
     * Runs application. The logic step by step is:
     * 1. Specify the array of Strings sorted alphabetically to process;
     * 2. Print this array to console;
     * 3. Find and print the longest complex word using static method of WordFinder class;
     * 4. Catch exceptions.
     */
    public static void main(String[] args) {
        String[] words = {"five", "fivetwo", "fourfive", "fourfivetwo", "one", "onefiveone", "two", "twofivefourone"};

        try {
            System.out.println("The array of words is: " + Arrays.toString(words));
            System.out.println("The longest complex word in the array is: " + findTheLongestComplexWord(words));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}