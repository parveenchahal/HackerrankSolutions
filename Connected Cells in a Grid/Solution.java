
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int dfs(int i, int j, boolean[][] marked, int count, int[][] arr) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || marked[i][j] || arr[i][j] == 0) {
            return count;
        }
        marked[i][j] = true;
        count++;
        count = dfs(i, j + 1, marked, count, arr);
        count = dfs(i + 1, j, marked, count, arr);
        count = dfs(i, j - 1, marked, count, arr);
        count = dfs(i - 1, j, marked, count, arr);
        count = dfs(i - 1, j - 1, marked, count, arr);
        count = dfs(i + 1, j + 1, marked, count, arr);
        count = dfs(i - 1, j + 1, marked, count, arr);
        count = dfs(i + 1, j - 1, marked, count, arr);
        return count;
    }

    static int maxConnectedCellInAGrid(int m, int n, int[][] arr) {
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                marked[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j] && arr[i][j] == 1) {
                    int p = dfs(i, j, marked, 0, arr);
                    if (p > max) {
                        max = p;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int A = maxConnectedCellInAGrid(m, n, arr);
        System.out.println(A);
    }
}
