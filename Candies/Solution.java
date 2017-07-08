
import java.util.Scanner;

public class Solution {

    static public int minCandies(int[] score) {
        int[] candies = new int[score.length];
        for (int i = 0; i < score.length;) {
            int j = i + 1;
            boolean less = false;
            for (; j < score.length; j++) {
                if (score[j] >= score[j - 1]) {
                    break;
                }
                less = true;
            }
            int candy = 0;
            for (int k = j - 1; (k >= i) && less; k--) {
                candies[k] += candy++;
            }
            i = j;
        }
        for (int i = 0; i < score.length;) {
            int j = i + 1;
            boolean greater = false;
            for (; j < score.length; j++) {
                if (score[j] <= score[j - 1]) {
                    break;
                }
                greater = true;
            }
            int candy = 0;
            for (int k = i; (k < j) && greater; k++) {
                if (candies[k] <= candy) {
                    candies[k] = candy++;
                }
            }
            i = j;
        }
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i] + 1;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int A = minCandies(arr);
        System.out.println(A);

    }

}
