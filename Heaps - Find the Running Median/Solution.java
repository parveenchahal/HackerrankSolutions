
import java.util.*;

public class Solution {

    static public void solve(int[] arr) {
        if (arr.length <= 0) {
            return;
        } else {
            System.out.println(String.format("%.1f", (float) arr[0]));
        }
        if (arr.length <= 1) {
            return;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (arr[0] > arr[1]) {
            maxHeap.add(arr[0]);
            minHeap.add(arr[1]);
        } else {
            maxHeap.add(arr[1]);
            minHeap.add(arr[0]);
        }
        float answer = (float) (minHeap.peek() + maxHeap.peek()) / 2;
        System.out.println(String.format("%.1f", answer));
        boolean alt = true;
        for (int i = 2; i < arr.length; i++) {
            int x = arr[i];
            if (alt) {
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }
            if(maxHeap.peek() > minHeap.peek()) {
                int temp = minHeap.remove();
                minHeap.add(maxHeap.remove());
                maxHeap.add(temp);
            }
            if(maxHeap.size() != minHeap.size()) {
                answer = (float) maxHeap.peek();
            } else {
                answer = (float)(minHeap.peek() + maxHeap.peek()) / 2;
            }
            System.out.println(String.format("%.1f", answer));
            alt = !alt;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solve(arr);
    }
}
