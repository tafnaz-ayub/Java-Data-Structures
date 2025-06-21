package Sorts;

import java.util.Arrays;

public class MergeSort {
    public static int[] Merge(int[] left, int[] right){
        int[] combined = new int[left.length+right.length];
        int i = 0, j = 0, index = 0;
        while(i < left.length && j < right.length){
            if(left[i]<right[j]){
                combined[index] = left[i];
                index++;
                i++;
            }
            else{
                combined[index] = right[j];
                index++;
                j++;
            }
        }
        while(i<left.length){
            combined[index] = left[i];
            index++;
            i++;
        }
        while(j<right.length){
            combined[index] = right[j];
            index++;
            j++;
        }
        return combined;
    }
    public static int[] mergesort(int[] array){
        if(array.length == 1) return array;
        int midIndex = array.length/2;
        int[] left = mergesort(Arrays.copyOfRange(array,0,midIndex));
        int[] right = mergesort(Arrays.copyOfRange(array,midIndex,array.length));
        return Merge(left,right);
    }
    public static void main(String[] args){
        int[] array = {1,90,4,2,97,45,28};
        int[] combined = mergesort(array);
        System.out.println(Arrays.toString(combined));
    }
}
