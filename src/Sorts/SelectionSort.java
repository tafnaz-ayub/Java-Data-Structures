package Sorts;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionsort(int[] array){
        for(int  i = 0 ; i< array.length;i++){
            int minIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minIndex]) {
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[] array = {1,90,4,2,97,45,28};
        selectionsort(array);
        System.out.println(Arrays.toString(array));
    }
}
