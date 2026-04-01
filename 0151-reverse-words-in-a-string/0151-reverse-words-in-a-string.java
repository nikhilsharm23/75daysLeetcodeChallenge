class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String ans = "";

        
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();

        for (int i = 0; i < n; i++) {
            String word = "";

            while (i < n && s.charAt(i) != ' ') {
                word += s.charAt(i);
                i++;
            }

          
            StringBuilder w = new StringBuilder(word);
            w.reverse();

            if (word.length() > 0) {
                ans += " " + w.toString();
            }
        }

        // remove leading space
        return ans.substring(1);
    }
}