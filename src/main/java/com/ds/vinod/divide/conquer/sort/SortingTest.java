package com.ds.vinod.divide.conquer.sort;

import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] arr = new int[]{10, 9 ,8 ,0 ,2};
        System.out.println("Bubble sort");
        sorting.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        sorting.selectionSort();
        sorting.quickSort();
        sorting.mergeSort();
        sorting.findMin();
        sorting.binarySearchUsingRecursive();
    }
}
