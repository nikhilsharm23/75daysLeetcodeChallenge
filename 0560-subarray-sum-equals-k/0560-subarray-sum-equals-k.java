import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        // Create a HaspMap 
        HashMap<Integer , Integer> map = new HashMap<>();

        // put the 0 freq in hash map 
        map.put(0,1);

        int sum = 0;
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int target = sum - k;

            if(map.containsKey(target)){
                res += map.get(target);
            }

            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }

        return res;
    }
}