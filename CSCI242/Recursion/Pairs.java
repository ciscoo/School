/*
 * This class counts the number of pairs in a given string. For this class a
 * "pair" in a string is two instances of a char sperated by a char. So "AxA"
 * the A's make a pair. Pairs can overlap, so "AxAxA" contains (3) pairs - 
 * (2) for A and (1) for x. Recursion is used for this class.
 *
 */

/**
 *
 * @author Francisco
 */

public class Pairs {
    
    /**
     * Counts the number of pairs in a given string.
     * @param str - The given string for pairs
     * @return
     */
    public static int countPairs (String str) {
        return (str.equals("") || str.length() < 3 ) ? 0
             : (str.charAt(0) == str.charAt(2))      ? 1 + countPairs(str.substring(1))
             :  countPairs(str.substring(1));
    }
}
