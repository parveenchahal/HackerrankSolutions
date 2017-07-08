import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static public void mergeSort(int[] arr) {
        count = 0;
        mergeSort(0, arr.length - 1, arr);
    }
    
    static private void mergeSort(int st, int lt, int[] arr) {
        if(st >= lt) {
            return;
        }
        int mid = (st + lt) / 2;
        mergeSort(st, mid, arr);
        mergeSort(mid + 1, lt, arr);
        merge(st, mid, lt, arr);
    }
    
    static long count = 0;

    static private void merge(int st, int mid, int lt, int[] arr) {
        int[] tempArr = new int[lt - st + 1];
        int k = 0;
        int i = st;
        int j = mid + 1;
        while(i <= mid && j <= lt) {
            if(arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                count += mid - i + 1;
                tempArr[k++] = arr[j++];
            }
        }
        if(i > mid) {
            for (int l = j; l <= lt; l++) {
                tempArr[k++] = arr[l];
            }
        } else {
            for (int l = i; l <= mid; l++) {
                
                tempArr[k++] = arr[l];
            }
        }
        for (int l = 0; l < tempArr.length; l++) {
            arr[st++] = tempArr[l];
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            mergeSort(arr);
            System.out.println(count);
        }
        
    }
}
