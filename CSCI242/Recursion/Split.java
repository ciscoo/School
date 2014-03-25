/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francisco
 */
public class Split {
    
    public static boolean splitArray (int [] arr) {
        return helper(arr, 1, 1, 2);
    }
    
    public static boolean helper (int [] arr, int pos, int sumA, int sumB) {
        
        if (pos >= arr.length) {
            return (sumA == sumB);
        }
        
        int index = arr[pos];
        
        return helper(arr, pos + 1, sumA + index, sumB) ||
               helper(arr, pos + 1, sumA, sumB + index);
    }
    
    public static void main(String[] args) {
        int[] a = {2,2};
        System.out.println(splitArray(a));
    }
}
