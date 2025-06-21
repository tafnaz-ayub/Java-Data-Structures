package Sorts;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1]= array[index2];
        array[index2] = temp;
    }
    public static int pivot(int[] array, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for(int i=pivotIndex+1;i<=endIndex;i++){
            if(array[i]<array[pivotIndex]){
                swapIndex++;
                swap(array,swapIndex,i);
            }
        }
        swap(array,pivotIndex,swapIndex);
        return swapIndex;
    }
    public static void quicksort(int[] array, int first, int last){
        if(first<last){
        int pivotIndex = pivot(array,first,last);
        quicksort(array,first,pivotIndex-1);
        quicksort(array,pivotIndex+1,last);
    }}
    public static void main(String[] args){
        int[] array = {1,90,4,2,97,45,28};
        quicksort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
