/*
Remove the minimum number of invalid parentheses in order to make the
input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
*/

class Solution {

    HashSet<String> res = new HashSet<>();
    int minCount = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, new StringBuilder(), 0, 0);

        return new ArrayList<String>(res);
    }

    public void dfs(String s, int lc, int rc, StringBuilder sb, int removal, int index){

        if(index == s.length()){

            if(removal == minCount && lc == rc){
                res.add(new String(sb));
                return;
            }
            else{
                if(removal < minCount && lc == rc){
                    minCount = removal;
                    res.clear();
                    res.add(new String(sb));
                    return;
                }
            }
            return;
        }

        if(s.charAt(index) != '(' && s.charAt(index) != ')'){
            dfs(s, lc, rc, sb.append(s.charAt(ind)), removal, index + 1);
            sb.deleteCharAt(sb.length()-1);
        }
        else{

            dfs(s, lc, rc, sb, removal + 1, index + 1);
            sb.append(charAt(index));

            if(s.charAt(index) == '('){
                dfs(s, lc+1 , rc, sb, removal + 1, index + 1);
            }
            else if(lc > rc){
                dfs(s, lc, rc+1, sb, removal + 1, index + 1);
            }

            sb.deleteCharAt(sb.length()-1);
        }
    }
}
