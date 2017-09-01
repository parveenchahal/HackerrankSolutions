
import java.util.*;

public class Solution {

    static class Node implements Comparable<Node> {

        int day, price;

        public Node(int index, int price) {
            this.day = index;
            this.price = price;
        }

        @Override
        public String toString() {
            return "" + price;
        }

        @Override
        public int compareTo(Node o) {
            if (price == o.price) {
                return o.day - day;
            }
            return price - o.price;
        }
    }

    public static long solve(Node[] arr, long max) {
        Arrays.sort(arr);
        int i = 0;
        long stocks = 0;
        while (i < arr.length && max - arr[i].price * arr[i].day >= 0) {
            max -= arr[i].price * arr[i].day;
            stocks += arr[i].day;
            i++;
        }
        if (i < arr.length && max > 0) {
            stocks += max / arr[i].price;
        }
        return stocks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i + 1, sc.nextInt());
        }
        long max = sc.nextLong();
        System.out.println(solve(arr, max));
    }
}
