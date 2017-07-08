import java.util.*;

public class Solution {

    static void swap(int x, int y, int[] arr) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    static void solve(int[] arr) {
        int numOfSwaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    count++;
                }
            }
            numOfSwaps += count;
            if(count == 0) {
                break;
            }
        }
        System.out.println("Array is sorted in " + numOfSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        solve(arr);
    }
}
