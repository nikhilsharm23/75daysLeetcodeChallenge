class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0 , maxLen = 0;
        Map<Integer , Integer> f = new HashMap<>();
    
        for(int right = 0; right < n; right++){
            f.put(fruits[right] , f.getOrDefault(fruits[right] , 0) + 1);

            // shrink

            while(f.size() > 2){
                int leftfruit = fruits[left];
                f.put(leftfruit , f.get(leftfruit) - 1);
                if(f.get(leftfruit) == 0){
                    f.remove(leftfruit);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}