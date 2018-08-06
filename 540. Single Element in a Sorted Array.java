class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
