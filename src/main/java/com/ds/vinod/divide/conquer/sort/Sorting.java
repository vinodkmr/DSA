package com.ds.vinod.divide.conquer.sort;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        int[] arr = new int[]{10, 20, 0, 2, 5, -1};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Sorting using selection sort " + Arrays.toString(arr));
    }

    /**
     * make first element as pivot
     * low as 0th index
     * high as n-1th index
     * while left < item do
     *  while left item < pivot, left++
     *  if right item > pivot, right--
     *  if left < right, swap left and right
     *  end
     *  swap pivot with right
     */
    public void quickSort() {
        int[] arr = new int[]{2, -1, -2, -3, 10, 20, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick Sorted Elements " + Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        else {
            int pivot = partition(arr, low, high);
            quickSort(arr, 0, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            while (arr[right] > pivot) right--;

            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

        }
        int temp = arr[right];
        arr[right] = arr[low];
        arr[low] = temp;
        return right;
    }

    /**
     * Divide the arr to left array and right array until there is only one element
     * compare the element in two arrays, left and right and merge to the new array
     */
    public void mergeSort(){
        int[] arr = getRandomIntArray();
        System.out.println("Merge sort");
        System.out.println("Before "+Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After "+Arrays.toString(arr));
    }

    private void mergeSort(int[] inputArr) {
        //divide until there is one element i.e. less than 2
        if(inputArr.length < 2) return;

        int mid = inputArr.length/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[inputArr.length - mid];

        for (int i=0; i<mid; i++){
            leftArr[i] = inputArr[i];
        }

        for (int j=mid; j<inputArr.length; j++){
            rightArr[j-mid] = inputArr[j];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);

        //conquer part
        merge(inputArr,leftArr,rightArr);
    }

    private void merge(int[] inputArr, int[] leftArr, int[] rightArr){
        int i=0, j=0, k=0;
        while (i<leftArr.length && j<rightArr.length){
            if(leftArr[i] <= rightArr[j]){
                inputArr[k] = leftArr[i];
                i++;
            }else{
                inputArr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        if(i<leftArr.length){
            inputArr[k] = leftArr[i];
            i++;
            k++;
        }

        if(j<rightArr.length){
            inputArr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private int[] getRandomIntArray() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }
}
