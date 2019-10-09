/* Find the first non-duplicate character in a string. 
   Return null if no unique character is found.

firstNonRepeatedCharacter( "abcdcd" ) --> 'a'
firstNonRepeatedCharacter( "cbcd" ) --> 'b'
firstNonRepeatedCharacter( "cdcd" ) --> null 

*/
import java.utils.*;
import java.util.streams.*;

// the improvement for correctness
public static Character firstNonRepeatedCharacter(String str) {
    int[] counter = new int[256]; //max 255 ascii value
    for(int i =0; i<str.length(); i++){
        counter[str.charAt(i)]++;
    }
    for(char i : str.toCharArray()){
        if(counter[i] == 1){
            return i;
        }
    }
    return null;

}


/*
public static Character firstNonRepeatedCharacter(String str) {
    HashMap<Character, Integer> nonDup = new HashMap<>();
    Character ans =null;
    for (int i=0; i<str.length(); i++){

        //increase count if already present in HashMap
        if(nonDup.containsKey(str.charAt(i))){
            int value = nonDup.get(str.charAt(i));
            nonDup.put(str.charAt(i), value + 1);
        }
        else{
            nonDup.put(str.charAt(i),1);
        }
    }
    //return only characters with count of 1
    //Problem is that the first one need not be the output 
    //We could instead use an array[256] to maintain order instead of HashSet
    for(Character s : nonDup.keySet()){
        if(nonDup.get(s) == 1){
            ans = s;
            break;
        }
    }
    return ans;
}
*/
