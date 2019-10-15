/*
You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its vertical axis.

Example:
Input image :
              1 0
              1 0

Modified to :
              0 1
              0 1
*/

public static void flipItVerticalAxis(int[][] matrix) {
    int len = matrix[0].length;
    for(int j=0; j< matrix.length; j++){
        for (int i=0; i < len/2; i++){
            matrix[j][i]+=matrix[j][len-i-1];
            matrix[j][len-i-1] = matrix[j][i] - matrix[j][len-i-1];
            matrix[j][i] -= matrix[j][len-i-1];
        }
    }
}
