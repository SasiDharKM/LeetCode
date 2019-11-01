/*

Given a string containing digits from 2-9 inclusive, return all possible
letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/
class Solution {
  public List<String> letterCombinations(String digits) {
      List<String> ans = new ArrayList<String>();
      if(digits == null || digits.length() == 0){
          return ans;
      }
      String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

      letterCombinationsRecursive(ans, digits, "", 0, map);
      return ans;
  }

  public void letterCombinationsRecursive(List<String> ans, String digits, String current, int index, String[] map){
      if(index == digits.length()){
          ans.add(current);
          return;
      }
      String letters = map[digits.charAt(index) - '0'];
      for(int i =0; i<letters.length(); i++){
          letterCombinationsRecursive(ans, digits, current +  letters.charAt(i), index + 1, map);
      }
  }
}
