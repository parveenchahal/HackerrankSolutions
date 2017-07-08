
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static public int key(char x, int MaxKey) {
        int i = (int) x;
        i = compression(i, MaxKey);
        return i;
    }

    static public int compression(int x, int M) {
        return (x & 0x7fffffff) % M;
    }

    public static ArrayList findAnagramString(String txt, String pat) {
        ArrayList list = new ArrayList();
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            String substr = txt.substring(i, i + pat.length());
            if (isAnagrams(substr, pat)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int arr[] = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] = 0;
        }
        int key;
        for (int i = 0; i < str1.length(); i++) {
            key = key(str1.charAt(i), 26);
            arr[key]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            key = key(str2.charAt(i), 26);
            arr[key]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int nAnagrams(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substr = str.substring(i, j);
                    count += findAnagramString(str, substr).size() - 1;
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str = sc.next();
            System.out.println(nAnagrams(str));
        }
    }
}
