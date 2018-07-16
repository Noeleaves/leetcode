class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null) return null;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] map = new int[26];
        for(int i = 0; i < p.length(); i++) {
            int curr = p.charAt(i) - 'a';
            map[curr]+=1; 
        }
        for(int j = 0; j < s.length(); j++) {
            int curr = s.charAt(j) - 'a';
            if(map[curr] > 0) {
                map[curr]-=1;
                q.add(j);
            }else {
                while(q.size() != 0) {
                    // System.out.println(s.charAt(q.peek()) +" : "+ curr);
                    if(s.charAt(q.peek()) - 'a' == curr) {
                        // System.out.println(s.charAt(q.peek()));
                        q.poll();
                        q.add(j);
                        break;
                    }
                    map[s.charAt(q.poll()) - 'a']++;
                }
            }
            // System.out.println(q.size());
            if(q.size() == p.length()) ans.add(q.peek());

        }
        return ans;
    }
}
