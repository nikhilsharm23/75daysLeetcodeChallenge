class Solution {
    public int maximumSum(int[] arr) {
        int i = 0;
        int nodelete = arr[0];
        int ans = arr[0];
        int onedelete = Integer.MIN_VALUE;

        for(i = 1; i < arr.length; i++){
            int v2;
            int prevnodelete = nodelete;
            int prevonedelete = onedelete;

            nodelete = Math.max(nodelete+arr[i], arr[i]);

            if(prevonedelete == Integer.MIN_VALUE){
                v2 = arr[i];
            } 
            else {
                v2 = prevonedelete + arr[i];
            }

            onedelete = Math.max(v2 , prevnodelete);

            ans = Math.max(ans , Math.max(onedelete , nodelete));
        }
        return ans;

    }
}