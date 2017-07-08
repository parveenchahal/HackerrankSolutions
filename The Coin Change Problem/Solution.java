
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static long coinChange(int N, int[] arr) {
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
        return list[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        long A = coinChange(N, arr);
        System.out.println(A);
    }
}
