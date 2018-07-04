class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }
            ArrayList<Integer>[] temp = new ArrayList[nums.length + 1];
            for(Map.Entry<Integer,Integer> o:map.entrySet()) {
                if(temp[o.getValue()] == null) {
                    temp[o.getValue()] = new ArrayList<>();
                }
                temp[o.getValue()].add(o.getKey());
            }
            int j = 0;
            for(int i = nums.length; i > 0  && ans.size() < k; i--) {
                if(temp[i] != null) {
                    ans.addAll(temp[i]);
                    j++;
                }
            }
        return ans;
    }
}
