class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int mid = 0;
        
        while(start <= end) {
            mid = start + (end - start)/2;
            if((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && mid + 1 < len && nums[mid] < nums[mid + 1]) start = mid + 1;
            else if((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 >= len || nums[mid] > nums[mid + 1])) return mid;
            else end = mid - 1;
        }
        return mid;
    }
}
