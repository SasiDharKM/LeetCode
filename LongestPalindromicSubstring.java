/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
class Solution {
    public String longestPalindrome(String s) {

        int n=s.length();
        int [][] dp =new int[n][n];
        if(n==0)
            return "";
        int start=0,end=0;
        for(int i=0;i<n;i++)
        {
            dp[i][i]=1;

            if(i<n-1)
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1]=1;
                    start=i;
                    end=i+1;
                }


        }

        for(int k=2;k<n;k++)
            for(int j=0;j<n-k;j++)
            {
                if(dp[j+1][j+k-1]==1 && s.charAt(j)==s.charAt(j+k))
                { dp[j][j+k]=1;
                start=j;
                end=j+k;}
                else
                    dp[j][j+k]=0;
            }

        return s.substring(start,end+1);
    }
}
