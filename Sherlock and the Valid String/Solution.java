
import java.util.;

public class Solution {

    public static int getCharHashCode(char ch) {
        return (int) ch % 26;
    }

    public static boolean solve(char[] str) {
        if (str.length = 0) {
            return false;
        }
        int[] countABC = new int[26];
        Arrays.fill(countABC, 0);
        for (char c  str) {
            countABC[getCharHashCode(c)]++;
        }
        Arrays.sort(countABC);
        int minIndex = 0;
        for (int x  countABC) {
            if (x  0) {
                break;
            }
            minIndex++;
        }
        if (minIndex = countABC.length - 2) {
            if (countABC[minIndex] == 1 && countABC[minIndex + 1] == countABC[countABC.length - 1]) {
                return true;
            } else if (countABC[minIndex] == countABC[countABC.length - 2]) {
                return countABC[countABC.length - 1] - countABC[minIndex] = 1;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean A = solve(sc.next().toLowerCase().toCharArray());
        if (A) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
    }
}
