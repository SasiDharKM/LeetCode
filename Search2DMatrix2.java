/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        int row = matrix.length -1 ,col = 0, search;
        while(row != -1 && col != matrix[0].length){
            search = matrix[row][col];
            if(search == target){
                return true;
            }
            if(target > search){
                col++;
            }
            else{
                row--;
            }
        }
        return false;
    }
}
