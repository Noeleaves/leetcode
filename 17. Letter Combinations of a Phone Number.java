class Solution {
    public final String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new LinkedList<String>();
        List<String> ans = combinations(digits, new LinkedList<String>(), "");
        return ans;
    }
    
    public List<String> combinations(String digits, List<String> list, String conbination) {
        if(digits.length() == 0) {
            list.add(conbination);
            return list;
        } 
        String convertString = map[digits.charAt(0) - '0'];
        for(int i = 0;i < convertString.length();i++) {
            list = combinations(digits.substring(1), list, conbination + convertString.charAt(i));
        }
        return list;
    }
}
