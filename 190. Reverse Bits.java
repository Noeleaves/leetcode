public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            ans <<= 1; //math.pow() return double and has might miss something when convert to int.
            ans += (n&1);
            n = n >>> 1;
        }
        return ans;
    }
}
