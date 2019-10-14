/*
Write a method that takes in an array of ints and uses the 
Bubble Sort algorithm to sort the array 'in place' in ascending order. 
The method should return the same, in-place sorted array.

Examples:
bubbleSortArray({5,4,3}) -> {3,4,5}
bubbleSortArray({3}) -> {3}
bubbleSortArray({}) -> {}
{} -> [Empty] Array

*/

public static int[] bubbleSortArray(int[] arr){
    for(int i = 0; i<arr.length; i++){
        for(int j =0; j<arr.length - 1; j++){
            if(arr[j+1] < arr[j]){
                arr[j+1]+= arr[j];
                arr[j] = arr[j+1] - arr[j];
                arr[j+1]-= arr[j];
            }
        }
    }
    return arr;
}
