package Sorts;

import java.util.Arrays;

public class BubbleSort {
    public static void bubblesort(int[] array){
        for(int i = array.length-1;i>0;i--){
            for(int j = 0 ; j < i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] array = {1,90,4,2,97,45,28};
        bubblesort(array);
        System.out.println(Arrays.toString(array));
    }
}
