class Solution {
    public int minSubArrayLen(int target,  int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow = 0, fast = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        while(fast < nums.length || sum > target) {
            sum += nums[fast];
            while(sum >= target) {
                res = Math.min(res, fast - slow + 1);
                sum-=nums[slow++];
            }
            fast++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
