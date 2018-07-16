class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        boolean[] visited = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(map.containsKey(s.charAt(i))) {
                map.put(curr, map.get(curr) + 1);
            }else {
                map.put(curr, 1);
            }
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        visited[s.charAt(0) - 'a'] = true;
        map.put(s.charAt(0),map.get(s.charAt(0)) - 1);
        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.get(curr) - 1);
            if(visited[curr - 'a']) continue;
            while(!stack.isEmpty() && stack.peek() > curr) {
                if(map.get(stack.peek()) > 0) {
                    visited[stack.pop() - 'a'] = false;
                } else {
                    break;
                }
            }
            visited[curr - 'a'] = true;
            stack.push(curr);    
        }
        StringBuilder ans= new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
