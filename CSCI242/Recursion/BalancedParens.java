/*
 * The method takes a string str from which all characters except the bracketing operators have 
 * already been removed. The method should return true if the bracketing operators in str are 
 * balanced, which means that they are correctly nested and aligned. If the string is not balanced, 
 * the method returns false.
 */

/**
 *
 * @author Francisco
 */
public class BalancedParens {

    /**
     * 
     * @param str The given string to check for balanced parentheses.
     * @return Boolean if given string is balanced
     */
    public static boolean isBalanced(String str) {
        return (str.contains("{}")) ? isBalanced(str.replaceFirst("\\{\\}", ""))
                : (str.contains("[]")) ? isBalanced(str.replaceFirst("\\[\\]", ""))
                : (str.contains("()")) ? isBalanced(str.replaceFirst("\\(\\)", ""))
                : (str.isEmpty()) ? true
                : (str.length() % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(([])"));
        System.out.println(isBalanced(")("));
        System.out.println(isBalanced("{(})"));
    }
}
