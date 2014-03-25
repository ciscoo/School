/*
 * This class returns the sum of the digits of an integer. For example:
 * if a number x is 234, the method should return 2 + 3 + 4, which equals 6.
 * If a number is negative, then it is multipled by -1 and returned to the
 * method.
 * 
*/

/**
 *
 * @author Francisco
 */

public class Sum {
    
    /**
     * Sums up the digits of a given number
     * @param num - the number to sum
     * @return sum of numbers
     */
    public static int sumDigits (int num) {
        return (num < 0) ? sumDigits(num * -1)
             : (num/10 == 0) ? num
             :  num % 10 + sumDigits(num/10);
    }
}