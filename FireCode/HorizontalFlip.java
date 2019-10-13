/*
You are given an m x n 2D image matrix where each integer represents 
a pixel. Flip it in-place along its horizontal axis.

Example:

Input image :  
              1 1
              0 0
Modified to :   
              0 0
              1 1
*/
public static void flipHorizontalAxis(int[][] matrix) {
    int end = matrix.length;
    int mid = end/2;
    for (int i =0; i< mid; i++){
        int[] temp = matrix[i];
        matrix[i] = matrix[end - i -1];
        matrix[end - i -1] = temp;
    }
    
}
