class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if(map.containsKey(key)) {
                map.get(key).add(strs[i]);
            }else {
                List<String> subList = new ArrayList<>();
                subList.add(strs[i]);
                ans.add(subList);
                map.put(key, subList);
            }
        }
        return ans;
    }
}
