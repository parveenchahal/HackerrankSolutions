
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static public int solve(int[] arr) {
        int N = arr.length;
        int max = 0;
        for (int i = 0; i < N - 1; i++) {
            int x = arr[i];
            int t = 1;
            int j = i - 1;
            for (; j >= 0 && arr[j] >= x; j--) {
                t++;
            }
            
            j = i + 1;
            for (; j < N && arr[j] >= x; j++) {
                t++;
            }
            if(t * x > max) {
                max = t * x;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int A = solve(arr);
        System.out.println(A);
    }
}
