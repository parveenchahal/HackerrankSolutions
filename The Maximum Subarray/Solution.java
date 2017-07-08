
import java.util.Scanner;

public class Solution {

    static int c_SubArray(int[] arr) {
        int max = 0x80000000;
        int[] sumarr = new int[arr.length];
        System.arraycopy(arr, 0, sumarr, 0, arr.length);
        for (int i = 1; i < arr.length; i++) {
            sumarr[i] = Math.max(sumarr[i], sumarr[i] + sumarr[i - 1]);
        }
        for (int i = 0; i < sumarr.length; i++) {
            if (sumarr[i] > max) {
                max = sumarr[i];
            }
        }
        return max;
    }

    static int nC_SubArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }
        if (sum == 0) {
            int max = 0x80000000;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            sum = max;
        }
        return sum;
    }

    static void theMaximumSubarray(int[] arr) {
        int c_sum = c_SubArray(arr);
        int nc_sum = nC_SubArray(arr);
        System.out.println(c_sum + " " + nc_sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                arr[j] = x;
            }
            theMaximumSubarray(arr);
        }
    }

}
