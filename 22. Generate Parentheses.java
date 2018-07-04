class Solution {
    int len;
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if(n <= 0) return ans;
        len = 2*n;
        helper(ans, n-1, 1, "(");
        return ans;
    }
    
    public void helper(List<String> ans, int ln, int count, String s) {
        if(s.length() == len) {
            ans.add(s);
            return;
        }
        if(ln != 0) helper(ans, ln-1, count+1, s+"(");
        if(count != 0) helper(ans, ln, count-1,s+")");
        
        return;
    }
}
