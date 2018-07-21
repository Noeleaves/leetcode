class Solution {
    public boolean find132pattern(int[] nums) {
        int cen = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < cen) return true;
            else while (!st.isEmpty() && nums[i] > st.peek()) {
                cen = st.peek(); 
                st.pop();
                
            }
            st.push(nums[i]);
        }
        return false;
    }
}
