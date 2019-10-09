/*
Write a method that searches an Array of integers for a given integer using the
Binary Search Algorithm. 
If the input integer is found in the array, return true. 
Otherwise, return false.
You can assume that the given array of integers is already sorted
in ascending order.
Examples:

binarySearch({2,5,7,8,9},9) -> true

binarySearch({2,8,9,12},6) -> false

binarySearch({2},4) -> false

binarySearch({},9) -> false

   {} -> [Empty] Array
*/

import java.utils.*;
import java.util.streams.*;


public static Boolean binarySearch(int[] arr, int n){
    
    int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == n) 
                return true; 
  
            // If x greater, ignore left half 
            if (arr[m] < n) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return false; 
}