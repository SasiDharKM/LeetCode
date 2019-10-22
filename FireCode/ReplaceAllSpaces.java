/*
Replace all Spaces

Write a method to replace all spaces in a string with a given replacement string.

replace("This is a test","/") --> "This/is/a/test"



Note: Avoid using the in-built String.replaceAll() method.

*/
public static String replace(String a, String b) {
    if (a != null){
        for(int i =0; i< a.length(); i++){
            if(a.charAt(i) == ' '){
                a = a.substring(0,i) + b + a.substring(i+1,a.length());
            }
        }
    }
    return a;
}
