/*
Given a string, find the first non-repeating character in it and
return it's index.
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> unique = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            if(!unique.containsKey(s.charAt(i))){
                unique.put(s.charAt(i), i);
            }
            else{
                unique.put(s.charAt(i), -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char c: unique.keySet()){
            if(unique.get(c) > -1 && unique.get(c) < min){
                min = unique.get(c);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
