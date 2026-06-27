class Solution {

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (st.isEmpty() || st.peek().c != c) {
                st.push(new Pair(c, 1));
            } 
            else {

                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop();
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {

            Pair p = st.pop();

            for (int i = 0; i < p.count; i++) {
                res.append(p.c);
            }
        }

        return res.reverse().toString();
    }
}