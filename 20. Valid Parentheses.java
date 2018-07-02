class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<Character>();


        for(int i = 0;i<len;i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stack.push(s.charAt(i));
            else if(!stack.empty() && map.get(stack.peek()) == s.charAt(i)) stack.pop();
            else return false;
        }
        
        return stack.empty();
    }
}
