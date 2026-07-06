class Solution {

    private boolean canShip(int[] weights , int capacity , int days){
        int dayUsed = 1;
        int load = 0;
        for(int weight : weights){
            if(load + weight <= capacity){
                load += weight;
            }
            else{
                dayUsed++;
                load = weight;
            }
        }
        return dayUsed <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(weight , low);
            high += weight;
        }

        int ans = high;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canShip(weights ,mid,days)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

}