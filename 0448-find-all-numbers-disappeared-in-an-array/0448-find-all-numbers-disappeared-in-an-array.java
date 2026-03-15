class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        List<Integer> list = new ArrayList();

        for(int i = 0; i < size; i++){
            int idx = Math.abs(nums[i]) -1;

            if(nums[idx] > 0){
                nums[idx] = nums[idx] * -1;
            }
        }
        for(int i = 0; i < size; i++)
        {
            if(nums[i] > 0){
              list.add(i+1);  
            }
        }

        return list;
    }
}