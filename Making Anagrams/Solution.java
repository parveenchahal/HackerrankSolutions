
import java.util.*;

public class Solution {

    static private int key(char ch, int M) {
        return ((int) ch & 0x7fffffff) % M;
    }

    static int solve(char[] a, char[] b) {
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for (char x : a) {
            arr[key(x, 26)]++;
        }
        for (char x : b) {
            arr[key(x, 26)]--;
        }
        int count = 0;
        for (int c : arr) {
            if (c != 0) {
                count += Math.abs(c);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solve(a.toLowerCase()
                .toCharArray(), b.toLowerCase().toCharArray()));
    }
}
