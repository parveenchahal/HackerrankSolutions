
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static public int solve(int[] arr) {
        int A = arr[0];
        for (int i = 1; i < arr.length; i++) {
            A = A ^ arr[i];
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        System.out.println(solve(a));
    }
}
