/* 
Write a method that returns a number that appears only once in an array.
Assume the array will surely have a unique value. The array will never be empty.
Examples:

{1,2,3,4,1,2,4,3,5} ==> 5
*/

public static int singleNumber(int[] A) {
    Hashtable<Integer, Boolean> check = new Hashtable<>();
    for(int i=0;i< A.length;i++){
        if(check.containsKey(A[i])){
            check.put(A[i], false);
        }
        else{
            check.put(A[i], true);
        }
    }
    int ans = 0;
    Set<Integer> keys = check.keySet();
    for(int key: keys){
        if(check.get(key)){
            ans = key;
            break;
        }
    }
    return ans;
}
