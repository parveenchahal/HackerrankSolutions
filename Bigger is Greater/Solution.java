
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean isPossible(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    static String modifyStrR(String str) {
        char[] abc = str.toCharArray();
        char X = abc[0];
        Arrays.sort(abc);
        char Y = '0';
        for (int i = 0; i < abc.length; i++) {
            if (abc[i] > X) {
                Y = abc[i];
                abc[i] = '0';
                break;
            }
        }
        Arrays.sort(abc);
        abc[0] = Y;
        return new String(abc);
    }

    static String findgreater(String str) {
        if (!isPossible(str)) {
            return "no answer";
        }
        int pat = 0;
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i - 1) < str.charAt(i)) {
                pat = i - 1;
                break;
            }
        }
        String strL = str.substring(0, pat);
        String strR = str.substring(pat);
        strR = modifyStrR(strR);
        return strL + strR;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str = sc.next();
            String A = findgreater(str);
            System.out.println(A);
        }
    }
}
