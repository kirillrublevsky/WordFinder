package com.kirillrublevsky;

import java.util.Comparator;

/**
 * Class LengthComparator implements interface Comparator and overrides its compare() method. Its aim is to
 * help to sort the array of Strings by length in descending order.
 */
public final class LengthComparator implements Comparator<String> {

    /**
     * Overrides compare() method of interface Comparator. Returns int - positive, negative or 0. Is used to sort
     * String by length in descending order.
     *
     * @param s1 first String to compare
     * @param s2 second String to compare
     * @return int positive, negative or 0
     */
    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
}
