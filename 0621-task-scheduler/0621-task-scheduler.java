import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int gap) {
        // C++ ki tarah unordered_map ki jagah HashMap
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> free = new HashMap<>();

        int n = tasks.length;
        
        // Frequencies aur initial free time populate kar rahe hain
        for (int i = 0; i < n; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
            free.put(tasks[i], 1); 
        }

        // Java mein Max-Heap banane ke liye custom comparator
        // int[] array store karega: {frequency, character_ascii}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int seat = 1;

        // Outer while loop
        while (!pq.isEmpty()) {
            List<int[]> pulled = new ArrayList<>();

            // "checking wala while" loop
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                int fr = p[0];
                char child = (char) p[1];

                // Agar task current seat (time) par available hai
                if (free.get(child) <= seat) {
                    if (fr > 1) {
                        pq.offer(new int[]{fr - 1, child});
                    }
                    // Next available time update kar rahe hain
                    free.put(child, seat + gap + 1);
                    break;
                } else {
                    // Agar available nahi hai toh pulled list mein daal do
                    pulled.add(p);
                }
            }

            // Pulled tasks ko wapas Priority Queue mein daalna
            for (int i = 0; i < pulled.size(); i++) {
                pq.offer(pulled.get(i));
            }

            seat++;
        }

        // Last mein 1 minus kar rahe hain as per C++ code
        return seat - 1;
    }
}