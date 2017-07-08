import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<E> extends Vector<E> {

    public MyQueue() {
    }
    
    public void enqueue(E e) {
        add(e);
    }
    
    public E dequeue() {
        if(size() > 0) {
            return remove(0);
        }
        return null;
    }
    
    public E peek() {
        if(size() > 0) {
            return firstElement();
        }
        return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
