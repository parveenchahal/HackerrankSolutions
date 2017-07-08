import java.util.*;

public class Solution {

    static public boolean solve(String magazine[], String ransom[]) {
        Map<String, Integer> hm = new HashMap<>();
        for (String x : magazine) {
            if(!hm.containsKey(x)) {
                hm.put(x, 1);
            } else {
                hm.put(x, hm.get(x) + 1);
            }
        }
        for (String x : ransom) {
            if(!hm.containsKey(x)) {
                return false;
            } else if(hm.get(x) > 1) {
                hm.put(x, hm.get(x) - 1);
            } else {
                hm.remove(x);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        if(solve(magazine, ransom)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
