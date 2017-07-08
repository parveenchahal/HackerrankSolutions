
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.security.InvalidParameterException;
import java.util.regex.*;

class PrimeNumbers {

    static private Set<Integer> table = null;

    static private int MAX = 0x7fffffff;

    static private int MAX_SQRT = (int) Math.sqrt(MAX) + 1;

    static private void initTable() {
        table = new HashSet<>();
        boolean[] marked = new boolean[MAX_SQRT + 1];
        Arrays.fill(marked, true);
        table.add(2);
        for (int i = 2; i <= MAX_SQRT; i++) {
            if (marked[i]) {
                table.add(i);
                for (int j = i + i; j <= MAX_SQRT; j += i) {
                    marked[j] = false;
                }
            }
        }
    }

    static public boolean isPrime(int e) {
        if (table == null) {
            initTable();
        }
        if (e <= MAX_SQRT) {
            return table.contains(e) == true;
        }
        for (Integer x : table) {
            if (e % x == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            if(PrimeNumbers.isPrime(sc.nextInt())) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
