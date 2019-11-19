/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/
class Solution {
  
    public boolean isValid(String s) {
        Stack<Character> paran = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                paran.push(c);
            }
            else if(!paran.isEmpty()){
                if (c == ')' && paran.pop() == '('){
                    continue;
                }
                else if (c == '}' && paran.pop() == '{'){
                    continue;
                }
                else if (c == ']' && paran.pop() == '['){
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                if(c == ')' || c == '}' || c == ']'){
                    return false;
                }
            }

        }

        return paran.isEmpty();
    }
}
