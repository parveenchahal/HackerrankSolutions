
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {

    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

}

class Queue<Node> extends Vector<Node> {

    public Queue() {
    }

    public void enqueue(Node e) {
        add(e);
    }

    public Node dequeue() {
        if (size() <= 0) {
            return null;
        }
        return remove(0);
    }
}

public class Solution {

    static public void updatePQ(PriorityQueue<Node> pq, Queue<Node> q, boolean[] marked) {
        Iterator<Node> i = q.iterator();
        while (i.hasNext()) {
            Node next = i.next();
            if(!marked[next.vertex]) {
                pq.add(next);
            }
        }
    }
    
    public static int primsMST(Queue<Node>[] graph, int s) {
        int sum = 0;
        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        };
        boolean[] marked = new boolean[graph.length];
        Arrays.fill(marked, false);
        PriorityQueue<Node> pq = new PriorityQueue<>(cmp);
        marked[s] = true;
        updatePQ(pq, graph[s], marked);
        while (!pq.isEmpty()) {
            Node min = pq.remove();
            if(marked[min.vertex]) {
                continue;
            }
            sum += min.weight;
            marked[min.vertex] = true;
            updatePQ(pq, graph[min.vertex], marked);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Queue<Node>[] graph = new Queue[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Queue<>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if (x != y) {
                graph[x].enqueue(new Node(y, z));
                graph[y].enqueue(new Node(x, z));
            }
        }
        int s = sc.nextInt();
        int A = primsMST(graph, s);
        System.out.println(A);
    }

}
