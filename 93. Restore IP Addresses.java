class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        DFS(s, ans, "", s.length() - 1, 4);
        return ans;
    }
    
    public void DFS(String s, List<String> ans, String ip, int pos, int level) {
        if(level == 0) {
            if(ip.length() == s.length() + 4) {
                ans.add(new String(ip.substring(1)));
            }    
            return;
        }
        // for(int k=1;k<=3;k++){
        //     if(s.length()<k) continue;
        //     int val = Integer.parseInt(s.substring(0,k));
        //     if(val>255 || k!=String.valueOf(val).length()) continue;
        //     /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
        //     helper(s.substring(k),tmp+s.substring(0,k)+".",res,n+1);
        // }
        String tmp = "";
        for(int i = pos; i > pos - 3 && i >= 0; i--) {
            tmp = s.substring(i,i+1) + tmp;
            if(Integer.valueOf(tmp) > 255 || (tmp.charAt(0) == '0' && tmp.length() != 1)) continue;
            DFS(s, ans, "." + tmp + ip, i-1, level - 1);
        }
    }
}
