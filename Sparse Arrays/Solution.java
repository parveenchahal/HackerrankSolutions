
import java.util.*;

public class Solution {
    
    static void countNumber(Map<String, Integer> map, String str) {
        Integer n = map.get(str);
        if(n != null) {
            map.replace(str, n, n + 1);
        } else {
            map.put(str, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Map<String, Integer> strmap = new HashMap<>();
        String[] strarr = new String[N];
        for (int i = 0; i < N; i++) {
            countNumber(strmap, sc.nextLine());
        }
        int Q = Integer.parseInt(sc.nextLine());
        String[] qarr = new String[Q];
        for (int i = 0; i < Q; i++) {
            Integer count = strmap.get(sc.nextLine());
            if(count != null) {
                System.out.println(count);
            } else {
                System.out.println(0);
            }
                  
        }
        
    }
}
