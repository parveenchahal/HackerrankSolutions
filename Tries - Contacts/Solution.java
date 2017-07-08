
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Tries {

    static private class Node {

        boolean isComplete;
        
        int completeCount;

        HashMap<Character, Node> children;

        public Node(boolean isComplete) {
            this.isComplete = isComplete;
            if(isComplete) {
                completeCount = 1;
            } else {
                completeCount = 0;
            }
            children = new HashMap<>();
        }

        int childrenSize() {
            return children.size();
        }

        Node getChildren(char ch) {
            return children.get(ch);
        }

        Node add(char ch, boolean isComplete) {
            if (!children.containsKey(ch)) {
                Node t = new Node(isComplete);
                children.put(ch, t);
                return t;
            }
            return children.get(ch);
        }

        @Override
        public String toString() {
            return isComplete + ";" + completeCount + ";" + children.toString();
        }
    }

    private final Node root = new Node(false);

    public void add(String str) {
        char[] charArr = str.toCharArray();
        Node ptr = root;
        for (int i = 0; i < charArr.length; i++) {
            ptr.completeCount++;
            ptr = ptr.add(charArr[i], i >= charArr.length - 1);
        }
    }
    
    private void add(Node ptr, int count) {
        
    }

    public int isPrefixOf(String str) {
        char[] charArr = str.toCharArray();
        Node ptr = root;
        for (char ch : charArr) {
            if (!ptr.children.containsKey(ch)) {
                return 0;
            }
            ptr = ptr.children.get(ch);
        }
        return ptr.completeCount;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}


public class Solution {

    static Tries tries;

    static public void solve(String query, String name) {

        switch (query) {
            case "find":
                System.out.println(tries.isPrefixOf(name));
                break;
            case "add":
                tries.add(name);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tries = new Tries();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            solve(op, contact);
        }
    }
}
