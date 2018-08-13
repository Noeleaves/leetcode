class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                s.push(Integer.parseInt(token));
            }else {
                int num2 = s.pop();
                int num1 = s.pop();
                if(token.equals("+")) s.push((num1 + num2));
                else if(token.equals("-")) s.push((num1 - num2));
                else if(token.equals("*")) s.push((num1 * num2));
                else if(token.equals("/")) s.push((num1 / num2));
            }
        }
        return s.pop();
    }
}
