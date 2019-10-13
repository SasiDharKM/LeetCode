/*
Write a method that takes in a String and 
returns the reversed version of the String.
Examples:
reverseString("abcde") -> "edcba"
reverseString("1") -> "1"
reverseString("") -> ""
reverse("madam") -> "madam"
reverse(null) -> null
*/


public static String reverseString(String str){
    String inputString = str;
    String outputString = null;
    if(inputString != null){
        outputString = "";
        for(int i = inputString.length()-1; i >= 0; i--){
            outputString += Character.toString(inputString.charAt(i));
        }
    }
    
    return outputString;
}
