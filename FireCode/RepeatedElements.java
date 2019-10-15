/*
Write a method duplicate to find the repeated or duplicate elements in an array.
This method should return a list of repeated integers in a string with the elements sorted in ascending order (as illustrated below).


duplicate({1,3,4,2,1}) --> "[1]"

duplicate({1,3,4,2,1,2,4}) --> "[1, 2, 4]"

*/

public static String duplicate(int[] numbers){
    Arrays.sort(numbers);
    HashSet<Integer> hash = new HashSet<Integer>();
    TreeSet<Integer> dup = new TreeSet<>();
    for(int i = 0; i<numbers.length; i++){
        if(hash.contains(numbers[i])){
            dup.add(numbers[i]);
        }
        hash.add(numbers[i]);
    }
    return dup.toString();
}
