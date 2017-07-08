
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

class Queue<E> extends Vector<E> {
    public Queue() {
    }
    
    public void enqueue(E value) {
        addElement(value);
    }

    public E dequeue() {
        if(size() <= 0) {
            return null;
        }
        return remove(0);
    }

}
public class Solution {

    private Queue<Integer> arr[];
    private int size;

    public Solution(int n) {
        this.size = n + 1;
        this.arr = new Queue[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Queue<>();
        }
    }

    public void addEdge(int u, int v) {
        arr[u].enqueue(v);
        arr[v].enqueue(u);
    }

    public int evenTree() {
        int count = 0;
        boolean[] marked = new boolean[size + 1];
        int[] NO_CH = new int[size + 1];
        Arrays.fill(marked, false);
        Arrays.fill(NO_CH, 1);
        dfs(1, marked, NO_CH);
        for (int i = 0; i < NO_CH.length; i++) {
            if(NO_CH[i] > 0 && NO_CH[i] % 2 == 0) {
                count++;
            }
        }
//        System.out.println(Arrays.toString(NO_CH));
        return count - 1;
    }

    private void dfs(int v, boolean[] marked, int[] NO_CH) {
        marked[v] = true;
        for (int w : arr[v]) {
            if (!marked[w]) {
                dfs(w, marked, NO_CH);
                NO_CH[v] += NO_CH[w];
            }
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Solution g = new Solution(N);
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.addEdge(a, b);
        }
        int A = g.evenTree();
        System.out.println(A);
    }

}
