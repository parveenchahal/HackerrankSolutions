
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Queue<E> extends Vector<E> {

    public Queue() {
    }

    public void enqueue(E e) {
        addElement(e);
    }

    public E dequeue() {
        if (size() <= 0) {
            return null;
        }
        return remove(0);
    }
}

public class Solution {

    public static void bfs(Queue<Integer>[] g, int[][] edge, int s) {
        int[] dist = new int[g.length];
        Arrays.fill(dist, -1);
        boolean[] marked = new boolean[g.length];
        Arrays.fill(marked, false);
        Queue<Integer> Q = new Queue<>();
        Q.enqueue(s);
        marked[s] = true;
        dist[s] = 0;
        while (!Q.isEmpty()) {
            int temp = Q.dequeue();
            Iterator<Integer> i = g[temp].iterator();
            while (i.hasNext()) {
                int x = i.next();
                int p = dist[temp] + edge[temp][x];
                if (!marked[x] || p < dist[x]) {
                    Q.enqueue(x);
                    dist[x] = p;
                    marked[x] = true;
                }
            }
        }
        for (int i = 1; i < dist.length; i++) {
            if (i != s) {
                System.out.print((dist[i]) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<Integer>[] g = new Queue[N + 1];
            int[][] edge = new int[g.length][g.length];
            for (int j = 0; j < edge.length; j++) {
                for (int k = 0; k < edge[j].length; k++) {
                    edge[j][k] = -1;
                }
            }
            for (int j = 1; j < g.length; j++) {
                g[j] = new Queue<>();
            }
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                if (edge[x][y] == -1) {
                    edge[x][y] = edge[y][x] = z;
                    g[x].enqueue(y);
                    g[y].enqueue(x);
                } else if(z < edge[x][y]) {
                    edge[x][y] = edge[y][x] = z;
                    g[x].enqueue(y);
                    g[y].enqueue(x);
                }
            }
            int s = sc.nextInt();
            bfs(g, edge, s);
        }
    }
}
