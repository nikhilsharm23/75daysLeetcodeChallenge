class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;

        for(int num : set){
            if(!set.contains(num-1)){
                int maxNum  = num;
                int count = 1;
                
                while(set.contains(maxNum + 1)){
                    maxNum++;
                    count++;
                }

                maxLen = Math.max(maxLen , count);
            }
        }

        return maxLen;
    }
}