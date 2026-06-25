class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char currchar = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == currchar){
                stack.pop();
            } else {
                stack.push(currchar);
            }
        }


        //Build a String result to store the result 

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}