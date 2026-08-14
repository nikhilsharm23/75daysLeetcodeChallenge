class Solution {
    public int addDigits(int num) {
        if( num < 10){
            return num;
        }

        int  d = num % 10;
        int n = num / 10;


        int ans = addDigits(n);
        int sum = ans + d;


        if(sum >= 10){
            return addDigits(sum);
        }
        return sum;
    }
}