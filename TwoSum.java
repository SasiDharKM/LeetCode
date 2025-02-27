/*
Given an array of integers, return indices of the two numbers such that
they add up to a specific target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> num = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int diff = target - nums[i];
            if(num.containsKey(diff))
                return new int[] {num.get(diff),i};
            num.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Solution");
    }
}

/*
int[] ind =new int[2];
        for(int i = 0; i< nums.length; i++)
            for (int j = i+1;  j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    ind[0] = i;
                    ind[1] = j;
                    break;
                }
            }
        return ind;
*/
