/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String current: strs){
            char[] characters = current.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(current);
        }

        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}
