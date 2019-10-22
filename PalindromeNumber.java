/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
*/
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0))
            return false;
        int check = 0;
        while(x > check){
            check = check*10 + x%10;
            x /= 10;
        }
        return x == check || x == check/10;

    }
}

/*
String pali = Integer.toString(x);
        int len =pali.length();
        for(int i=0; i<len/2;i++)
            if(pali.charAt(i) != pali.charAt(len - i - 1))
                return false;
        return true;
*/
