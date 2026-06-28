class Solution {
    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> have = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> need = new HashMap<>();
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);

        int res = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            char c = entry.getKey();
            int fneed = entry.getValue();

            int fhave = have.getOrDefault(c, 0);

            int time = fhave / fneed;

            res = Math.min(res, time);
        }

        return res;
    }
}