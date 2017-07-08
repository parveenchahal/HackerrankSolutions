import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Node implements Comparable<Node> {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
        
    }
    
    static public String solve(int[] arr, int m) {
        Node[] nodeArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodeArr[i] = new Node(arr[i], i + 1);
        }
        Arrays.sort(nodeArr);
        int i = 0, j = arr.length - 1;
        while (i < j) {            
            if(nodeArr[i].value + nodeArr[j].value == m) {
                return (nodeArr[i].index < nodeArr[j].index) ? nodeArr[i].index + " " + nodeArr[j].index : nodeArr[j].index + " " + nodeArr[i].index;
            } else if(nodeArr[i].value + nodeArr[j].value > m) {
                j--;
            } else {
                i++;
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            System.out.println(solve(a, m));
        }
    }
}
