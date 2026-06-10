class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int k = p.length();

        if(n < k){
            return res;
        }

        int[] pfreq = new int[26];
        int[] winfreq = new  int[26];

        for(int i =0; i < k; i++){
            pfreq[p.charAt(i) - 'a']++;
        }

        for(int i =0; i < k; i++){
            winfreq[s.charAt(i)- 'a']++;
        }

        int low = 0;
        int high = k -1;

        while(high < n){
            if(Arrays.equals(pfreq,winfreq)){
                res.add(low);
            }

            //left char remove kro 
            winfreq[s.charAt(low) - 'a']--;
            low++;

            high++;

            if(high < n){
                winfreq[s.charAt(high) - 'a']++;
            }
        }
        return res;
    }
}