import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void solve(char[] str) {
        double sL = Math.sqrt(str.length);
        int row = (int)Math.floor(sL);
        int col = (int)Math.ceil(sL);
        for(int j = 0; j < col; j++) {
            for(int i = 0; i < row + 1; i++) {
                int ni = i * col + j;
                if(ni < str.length) {
                    System.out.print(str[ni]);
                }
            }
            System.out.print(" ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc.next().toCharArray());
    }
}