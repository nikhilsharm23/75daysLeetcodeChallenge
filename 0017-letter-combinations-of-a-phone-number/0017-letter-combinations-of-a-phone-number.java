class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return res;
        }


        HashMap<Character , String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        backtrack(digits, 0 , new StringBuilder(), res , map);
        return res;
    }

    private void backtrack(String digits, int idx , StringBuilder current, List<String> res, HashMap<Character , String> map){

        if(idx == digits.length()){
            res.add(current.toString());
            return;
        }


        char digit = digits.charAt(idx);

        String letters = map.get(digit);

        for(int i  = 0; i < letters.length(); i++){
            current.append(letters.charAt(i));


            backtrack(digits , idx + 1 , current, res , map);

            current.deleteCharAt(current.length() - 1);
        }
    }
}