
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private long ways(int i, int N, long count) {
        if (i < N) {
            count = ways(i + 1, N, count);
            count = ways(i + 2, N, count);
            count = ways(i + 3, N, count);
        } else if (i == N) {
            count++;
        }
        return count;
    }

    private long[] MAX_SETPS = null;

    private void initMaxStepsArray(int s) {
        if (MAX_SETPS != null) {
            return;
        }
        MAX_SETPS = new long[s + 1];
        MAX_SETPS[0] = 0;
        for (int i = 1; i <= s; i++) {
            MAX_SETPS[i] = ways(0, i, 0);
        }
    }

    long solve(int n, int maxSteps) {
        initMaxStepsArray(maxSteps);
        long[] ways = new long[n > maxSteps ? n + 1 : maxSteps + 1];
        for (int i = 0; i <= maxSteps; i++) {
            ways[i] = MAX_SETPS[i];
        }
        for (int i = maxSteps + 1; i <= n; i++) {
            for (int j = maxSteps; j > 0; j--) {
                ways[i] += ways[i - j];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        Solution sol = new Solution();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(sol.solve(n, 3));
        }
    }
}
