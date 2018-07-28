class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
   
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = map.get(s.charAt(s.length() - 1));
        char prev = s.charAt(s.length() - 1);
        for(int i = s.length() - 2; i >= 0; i--) {
            char curr = s.charAt(i);
            if(map.get(curr) < map.get(prev)) ans -= map.get(curr);
            else ans += map.get(curr);
            prev = curr;
        }
        return ans;
    }
}
