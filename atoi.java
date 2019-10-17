/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
*/
class Solution {
    public int myAtoi(String str) {
        boolean whitespace = true, number = false;
        int mult = 1, output = 0;
        for(int i=0; i<str.length(); i++){
          //if it is whitespace i.e. still nothing else has been encountered
            if(str.charAt(i) == ' ' && whitespace){
                continue;
            }
            else if(str.charAt(i) != ' '){//if it is something else(a number or otherwise)
                whitespace = false;
                if(str.charAt(i) == '+' && !number){ //to account for positive sign
                    if(i+1 < str.length()){ //to handle plus being at last index
                        if(!(str.charAt(i+1) >47 && str.charAt(i+1) < 58)){//to check if next index is a number
                        return mult*output;
                        }
                    }
                    continue;
                }
                else if(str.charAt(i) == '-' && !number){//to account for negative sign
                    if(i+1 < str.length()){ //to handle minus being at last index
                        if(!(str.charAt(i+1) >47 && str.charAt(i+1) < 58)){//to check if next character is a number
                        return mult*output;
                        }
                    }
                    mult =-1; //multipier becomes negative
                }
                else if(!(str.charAt(i) >47 && str.charAt(i) < 58)){ // if not a number or a sign return
                    return mult*output;
                }
                else if(str.charAt(i) >47 && str.charAt(i) < 58){ //if it is a number
                    number = true;
                    if(mult == 1){
                      //positive has 2^32 -1 =  2,147,483,647
                        if((output < Integer.MAX_VALUE/10) ||((output == Integer.MAX_VALUE/10)&&(Character.getNumericValue(str.charAt(i)) < 8))){
                        output = output*10 + Character.getNumericValue(str.charAt(i));
                        }
                        else{//if integer overflow
                            return Integer.MAX_VALUE;
                        }
                    }
                    if (mult == -1){
                      //negative has 2^32 =  2,147,483,648
                        if((output < Integer.MAX_VALUE/10) ||((output == Integer.MAX_VALUE/10)&&(Character.getNumericValue(str.charAt(i)) < 9))){
                        output = output*10 + Character.getNumericValue(str.charAt(i));
                        }
                        else{
                          //if integer underflow
                         return Integer.MIN_VALUE;
                        }
                    }
                }
            }
            //if other than a number after number starts return
            else if(!(str.charAt(i) >47 && str.charAt(i) < 58) && number){
                return mult*output;
            }
        }
        return mult*output;
    }

}
