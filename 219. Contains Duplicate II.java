class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(q.size() == k + 1) {
                set.remove(q.poll());
            }
            q.add(nums[i]);
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
