/*
Given an array A of positive integers, call a (contiguous, not necessarily distinct)
subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.



Example 1:

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers:
[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers:
[1,2,1,3], [2,1,3], [1,3,4].


Note:

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
*/
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        int left1 = 0, left2 =0;
        Map<Integer, Integer> less = new HashMap<>();
        Map<Integer, Integer> lessEqual = new HashMap<>();
        for(int i = 0; i<A.length; i++){
            int val = A[i];
            less.put(val, less.getOrDefault(val, 0) + 1);
            lessEqual.put(val, lessEqual.getOrDefault(val, 0) + 1);
            while(lessEqual.size() >= K){
                int temp = lessEqual.getOrDefault(A[left1],0);
                if(temp <= 1){
                    lessEqual.remove(A[left1]);
                }
                else{
                    lessEqual.put(A[left1], lessEqual.get(A[left1]) - 1);
                }
                left1++;
            }

            while(less.size() > K){
                int temp = less.getOrDefault(A[left2],0);
                if(temp <= 1){
                    less.remove(A[left2]);
                }
                else{
                    less.put(A[left2], less.get(A[left2]) - 1);
                }
                left2++;
            }
            count = count + left1 - left2;
        }

        return count;
    }
}
