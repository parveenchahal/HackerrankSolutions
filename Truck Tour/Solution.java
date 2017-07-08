
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
        if(size() <= 0) {
            return null;
        }
        return remove(0);
    }
}

class PetrolPump {
    private int quantity = 0;
    private int distance = 0;

    public PetrolPump(int quantity, int distance) {
        this.quantity = quantity;
        this.distance = distance;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDistance() {
        return distance;
    }
    
    
}

public class Solution {
    
    static boolean takeRound(Queue<PetrolPump> Q) {
        Iterator<PetrolPump> i = Q.iterator();
        int Capacity = 0;
        while (i.hasNext()) {            
            PetrolPump t = i.next();
            Capacity += t.getQuantity();
            if(t.getDistance() > Capacity) {
                return false;
            }
            Capacity -= t.getDistance();
        }
        return true;
    }
    
    static public int solve(Queue<PetrolPump> Q) {
        int count = 0;
        while (!takeRound(Q)) {            
            PetrolPump t = Q.dequeue();
            Q.enqueue(t);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<PetrolPump> Q = new Queue<>();
        
        for (int i = 0; i < N; i++) {
            int q = sc.nextInt();
            int d = sc.nextInt();
            Q.enqueue(new PetrolPump(q, d));
        }
        int A = solve(Q);
        System.out.println(A);
    }
}
