public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        int d;
        while ((d =z & -z) != 0) {
            count++;
            z -= d;
        }
        return count;
    }
}
