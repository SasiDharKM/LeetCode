/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
class Solution {

  //The faster solution
  public String intToRoman(int num) {
        // List all the possible roman numberial values
        int[] romanValue = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanCharacters = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String solution = "";

        // We are going to determine how many times each roman numerial can be used in a single iteration
        for(int i = 0; i < romanValue.length; i++){
            int repeat = num / romanValue[i];

            // The remainder become the new value
            num = num % romanValue[i];

            // Adding the repeation to the result
            for(int j = 0; j < repeat; j++){
                solution += romanCharacters[i];
            }

        }
        return solution;
    }
  /*
    char [] roman = {'I','V','X', 'L','C','D','M'};
    public String intToRoman(int num) {
        int maxDigit = 4;
        int[] digit = new int[maxDigit];
        int j =0;
        while(num>0){
            digit[j] = num%10;
            num = num/10;
            j++;
        }
        for(int i = 0; i< maxDigit; i++){
            System.out.print(digit[i]);
        }

        StringBuilder res = new StringBuilder();

        for(int i = maxDigit - 1; i>=0; i--){
            int n = digit[i];
            System.out.println(n);
            if(n == 4 || n==9){
                res.append(roman[2*i]);
                if(n == 9)
                    res.append(roman[2*i + 2]);
                else
                    res.append(roman[2*i + 1]);
            }
            else{
                if(n>=5){
                    res.append(roman[2*i + 1]);
                    n = n - 5;
                }
                while(n>0){
                    res.append(roman[2*i]);
                    n--;
                }
            }
            System.out.println(res);
        }
        return res.toString();
    }
}*/
