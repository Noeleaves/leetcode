class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] records = new int[26];
        for(int i = 0; i < s.length(); i++) {
            if(records[s.charAt(i) - 'a'] == 0)
                records[s.charAt(i) - 'a'] = i + 1;
            else 
                records[s.charAt(i) - 'a'] = -1;
        }
        for(int i = 0; i < s.length(); i++) {
            if(records[s.charAt(i) - 'a'] != 0 && records[s.charAt(i) - 'a'] != -1) return records[s.charAt(i) - 'a'] - 1;
        }
        return -1;
    }
}
