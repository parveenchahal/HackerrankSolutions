import java.util.Scanner;

public class Solution {

    public static int commonChild(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] L = new int[str1.length + 1][str2.length + 1];
        for (int i = 1; i < L.length; i++) {
            for (int j = 1; j < L[i].length; j++) {
                if(str1[i - 1] == str2[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
                }
            }
        }
        return L[str1.length][str2.length];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(commonChild(str1, str2));
    }
}
