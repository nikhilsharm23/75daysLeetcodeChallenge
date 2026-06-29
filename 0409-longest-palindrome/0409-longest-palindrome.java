class Solution {
    public int longestPalindrome(String s) {
        Map<Character , Integer> f = new HashMap<>();

        int n = s.length();

        for(int i = 0; i < n; i++){
            char c  = s.charAt(i);
            f.put(c , f.getOrDefault(c, 0) + 1);
        }

        boolean odd =  false;
        int  res = 0;

        // count even freq
        for(Map.Entry<Character , Integer> entry : f.entrySet()){
            int val = entry.getValue();

            if(val % 2 == 0 ){
                res += val;
            }
            else{
                odd = true;
            }
        }

        if(!odd){
            return res;
        }

        //count odd freq  

        for(Map.Entry<Character , Integer> entry: f.entrySet()){
            int val  = entry.getValue();

            if(val % 2 == 1){
                res += (val - 1);
            }
        }

        return res+1;
    }

}