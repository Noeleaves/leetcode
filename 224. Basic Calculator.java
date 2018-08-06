class Solution {
    public int calculate(String s) {
        int result = 0;
        if (s == null || s.length() == 0) return result;
        
        Stack<Integer> stack = new Stack<>();
        int len = s.length(), sign = 1, num=0;
        int i=0;
        while (i < len) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                while (i<len && Character.isDigit(s.charAt(i))) 
                    num = num * 10 + s.charAt(i++) - '0';
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = c == '+' ? 1 : -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                sign = 1;
                result = result * stack.pop() + stack.pop();
            }
        }
        
        if (num != 0)  result += sign * num;
        return result;
                       
    }
}
