package com.pyq.study.algorithm.arrayOptions;

import java.util.Arrays;

public class SortUtils {

    public static void mergeSort(int[] array,int start,int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }

    public static void merge(int[] array1,int start ,int mid , int end){
        int length1 = mid - start+1;
        int length2 = end - mid;
        int[] tempArr1 = Arrays.copyOfRange(array1,start,mid+1);
        int[] tempArr2 = Arrays.copyOfRange(array1,mid+1,end+1);

        int pos = start;
        int j = 0;
        int k = 0;
        while(pos <= end) {
            if(j==length1) {
                while (k < length2) {
                    array1[pos++] = tempArr2[k++];
                }
            }
            else if(k==length2){
                while (j < length1) {
                    array1[pos++] = tempArr1[j++];
                }
            }
            else if(tempArr1[j]<tempArr2[k])
                array1[pos++] = tempArr1[j++];
            else
                array1[pos++] = tempArr2[k++];
        }
    }

    public static void sopArray(int[] array){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0;i<array.length;i++) {
            if(i !=array.length-1)
                sb.append(array[i] +" , ");
            else
                sb.append(array[i] +"]");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        int[] arry = {6,1,3,7,9,4};
        mergeSort(arry,0,5);
        sopArray(arry);
    }
}