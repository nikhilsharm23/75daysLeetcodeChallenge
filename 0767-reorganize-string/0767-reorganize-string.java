import java.util.*;

class Solution {

    class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (char ch : map.keySet()) {
            pq.offer(new Pair(map.get(ch), ch));
        }

        StringBuilder ans = new StringBuilder();

        while (pq.size() > 1) {

            Pair first = pq.poll();
            Pair second = pq.poll();

            ans.append(first.ch);
            ans.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0) {
                pq.offer(first);
            }

            if (second.freq > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {

            Pair last = pq.poll();

            if (last.freq > 1) {
                return "";
            }

            ans.append(last.ch);
        }

        return ans.toString();
    }
}