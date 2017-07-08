
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static long knapsack(int N, int[] arr) {
        long[] list = new long[N + 1];
        Arrays.fill(list, 0);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x <= N) {
                list[x]++;
                for (int j = 1; j + x <= N; j++) {
                    if (list[j] > 0) {
                        list[j + x] += list[j];
                    }
                }
            }
        }
        for (int i = N; i >= 0; i--) {
            if (list[i] > 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[] arr = new int[M];
            for (int j = 0; j < M; j++) {
                arr[j] = sc.nextInt();
            }
            long A = knapsack(N, arr);
            System.out.println(A);
        }
    }
}
