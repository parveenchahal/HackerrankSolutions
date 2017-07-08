import java.util.*;
class Queue<K> extends Vector<K> {

    public Queue() {
    }

    public void enqueue(K e) {
        if (e != null) {
            add(e);
        }
    }

    public K dequeue() {
        if (size() > 0) {
            return remove(0);
        }
        return null;
    }
}

class BTree {

    class Node {

        public Integer key;
        public Node left, right;

        public Node(Integer key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public BTree() {
        this.root = null;
    }

    public void makeTreeFromLevelOrder(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        root = new Node(arr[0]);
        Queue<Node> q = new Queue<>();
        q.enqueue(root);
        for (int i = 1; i < arr.length; i++) {
            Node temp = q.dequeue();
            Node left = arr[i] < 0 ? null : new Node(arr[i]);
            i++;
            Node right = arr[i] < 0 ? null : new Node(arr[i]);
            temp.left = left;
            temp.right = right;
            q.enqueue(left);
            q.enqueue(right);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void swapChildsForDepth(int depth) {
        swapChildsForDepth(root, 1, depth);
    }

    private void swapChildsForDepth(Node ptr, int i, int depth) {
        if (ptr == null) {
            return;
        }
        if (i % depth == 0) {
            Node temp = ptr.left;
            ptr.left = ptr.right;
            ptr.right = temp;
        }
        swapChildsForDepth(ptr.left, i + 1, depth);
        swapChildsForDepth(ptr.right, i + 1, depth);
    }

    private void printInOrder(Node ptr) {
        if (ptr == null) {
            return;
        }
        printInOrder(ptr.left);
        System.out.print(ptr.key + " ");
        printInOrder(ptr.right);
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() * 2 + 1;
        int[] arr = new int[N];
        arr[0] = 1;
        for (int i = 1; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        BTree tree = new BTree();
        tree.makeTreeFromLevelOrder(arr);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int depth = sc.nextInt();
            tree.swapChildsForDepth(depth);
            tree.printInOrder();
            System.out.println("");
        }
    }
}
