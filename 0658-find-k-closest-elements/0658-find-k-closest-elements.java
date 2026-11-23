
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - 1;

        while(right - left + 1 > k) {

            int leftdis = Math.abs(arr[left] - x);
            int rightdis = Math.abs(arr[right] - x);

            if(leftdis > rightdis) {
                left++;
            }
            else {
                right--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
