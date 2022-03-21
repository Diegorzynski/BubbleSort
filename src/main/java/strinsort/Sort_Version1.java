package strinsort;

import java.util.Arrays;

public class Sort_Version1 {

//Bubble sort  O(n2)
    public static void sort(String[] names){
        int n = names.length;
        System.out.println("Size of n: " + n);
        while(n > 1){
            for(int i=0; i < n-1; i++){
                if(names[i].compareTo(names[i+1]) > 0){
                    System.out.println("Result from compareTo(): " + names[i].compareTo(names[i+1]));
                    String temp = names[i+1];
                    names[i+1] = names[i];
                    names[i] = temp;
                }
                else {
                    System.out.println("Result from compareTo(): " + names[i].compareTo(names[i+1]));
                }
            }
            System.out.println(Arrays.toString(names));
            n--;
        }
    }
}
/*All object references in Java are passed by value (passing a copy of the value to a method), when the parameter(copy)
is passed to a method, it also changes the value of the real object.

The reason is that Java object variables are simply references that point to real objects in the memory heap(primitive types
are in the stack memory).
Therefore, even though Java passes parameters to methods by value, if the variable points to an object reference,
the real object will also be changed.
 */
