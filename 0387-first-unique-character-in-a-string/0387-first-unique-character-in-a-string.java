class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character , Integer> f = new HashMap<>();
        for(int i = 0; i < s.length(); i++){ // count freq
            char ch = s.charAt(i);
            f.put(ch , f.getOrDefault(ch , 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(f.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }
}