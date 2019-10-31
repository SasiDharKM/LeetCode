/*
Given a non-empty array of integers,
every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
 For this we could XOR everything.
Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> sin = new HashSet<>();
        for (int i: nums){
            if (sin.contains(i)){
                sin.remove(i);
            }
            else{
                sin.add(i);
            }

        }
        for(int i: sin){
            return i;
        }
        return -1;
    }
}
