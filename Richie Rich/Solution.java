
import java.util.*;

public class Solution {

    static private int changesForPalindrome(char[] number) {
        int count = 0;
        int lastIndex = number.length - 1;
        int halfLen = (number.length) / 2;
        for (int i = 0; i < halfLen; i++) {
            if (number[i] != number[lastIndex - i]) {
                count++;
            }
        }
        return count;
    }

    static public String solve(char[] number, int k) {
        int leastChanges = changesForPalindrome(number);
        if (k < leastChanges) {
            return "-1";
        }
        int lastIndex = number.length - 1;
        int halfLen = number.length / 2;
        HashSet<Integer> changesLoc = new HashSet<>();
        for (int i = 0; i < halfLen; i++) {
            if (number[i] != number[lastIndex - i]) {
                number[i] = (char) Math.max(number[i], number[lastIndex - i]);
                number[lastIndex - i] = number[i];
                k--;
                changesLoc.add(i);
            }
        }
        if(number.length % 2 != 0) {
            changesLoc.add(halfLen);
        }
        for (int i = 0; i <= halfLen && k > 0; i++) {
            if(number[i] != '9' && changesLoc.contains(i)) {
                number[i] = number[lastIndex - i] = '9';
                k--;
            } else if(number[i] != '9' && k >= 2) {
                number[i] = number[lastIndex - i] = '9';
                k -= 2;
            }
        }
        StringBuilder A = new StringBuilder();
        for (char c : number) {
            A.append(c);
        }
        return A.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        char[] number = in.next().toCharArray();
        System.out.println(solve(number, k));
    }
}
