class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

       int[] prefix = new int[n];

       int max = 0;

       prefix[0] = gain[0];

       for(int i = 1; i < n; i++){
        prefix[i] = prefix[i-1] + gain[i];
       }

       for(int i = 0; i < n; i++){
        max = Math.max(max , prefix[i]);
       }

       return max;
    }
}