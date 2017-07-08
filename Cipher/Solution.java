import java.util.Scanner;

public class Solution {

    static void cipher(int N, int K, char[] arr) {
        int x = 0;
        char[] ans = new char[N];
        for (int i = 0; i < N; ++i) {
            ans[i] = (char) (((arr[i] - '0') ^ x) + '0');
            if (i >= K - 1) {
                x = x ^ ans[i - K + 1] - '0' ^ ans[i] - '0';
            } else {
                x = arr[i] - '0';
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        cipher(N, K, sc.next().toCharArray());
    }

}
