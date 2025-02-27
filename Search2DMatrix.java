/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length - 1, column = 0;
        if(matrix[row][matrix[0].length -1] < target || matrix[0][column] > target){
            return false;
        }

        while(row != -1 && column != matrix[0].length){
           System.out.println(row + "  " + column);
            int current = matrix[row][column];
           if(current == target){
               return true;
           }
           if( current > target ){
               row--;
           }
           else if(current < target){
               column++;
           }
        }
        return false;
    }
}
