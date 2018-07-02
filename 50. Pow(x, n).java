class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) x = 1/x;
        if(n%2 == 0) return myPow(x*x,Math.abs(n/2));
        return myPow(x*x, Math.abs(n/2))*x;
    }
}
