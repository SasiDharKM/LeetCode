/*
Unique Chars in a String
Write a method that takes in an input String and returns true
if all the characters in the String are unique and false
if there is even a single repeated character.
The method should return true if the input is null or empty String.

Examples:
areAllCharactersUnique("abcde") -> true


areAllCharactersUnique("aa") -> false


areAllCharactersUnique("") -> true


areAllCharactersUnique(null) -> true

*/
public static boolean areAllCharactersUnique(String str){
    if(str == null || str == ""){
        return true;
    }
    HashSet<Character> uni =  new HashSet<>();
    for(int i =0; i<str.length(); i++){
        if(uni.contains(str.charAt(i))){
           return false;
        }
        else{
            uni.add(str.charAt(i));
        }
    }
    return true;

}
