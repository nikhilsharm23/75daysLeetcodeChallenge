class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {

            // Add current character
            windowFreq[s2.charAt(right) - 'a']++;

            // Window size becomes greater than s1 length
            if (right - left + 1 > s1.length()) {
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }

            // Window size == s1 length
            if (right - left + 1 == s1.length()) {

                if (java.util.Arrays.equals(s1Freq, windowFreq)) {
                    return true;
                }
            }

            right++;
        }

        return false;
    }
}