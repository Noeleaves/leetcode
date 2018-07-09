class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int len = digits.length;
        int[] ans = new int[len];
        int count = (digits[len - 1] + 1) / 10;
        ans[len-1] =  (digits[len - 1] + 1) % 10;
        for(int i = len - 2; i >= 0; i-- ) {
            digits[i] += count;
            count = digits[i] / 10;
            ans[i] = digits[i] % 10;
        }
        if(count != 0) {
            int[] tmp = ans;
            ans = new int[len+1];
            ans[0] = count;
            System.arraycopy(tmp, 0, ans, 1, len);
        }
        return ans;
    }
}
