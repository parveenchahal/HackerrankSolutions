
import java.util.*;

class Solution {
    
    static private int values(char ch) {
        switch(ch) {
            case '{':
                return -1;
            case '}':
                return 1;
            case '[':
                return -2;
            case ']':
                return 2;
            case '(':
                return -3;
            case ')':
                return 3;
        }
        return 0;
    }

    static public boolean isBalancedBrackets(char[] str) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            int val = values(str[i]);
            if(val < 0) {
                st.push(val);
            } else if(val > 0) {
                if(st.size() > 0 && val + st.peek() == 0) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.size() <= 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            if(isBalancedBrackets(sc.nextLine().toCharArray())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
