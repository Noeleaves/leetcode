class Solution {
    public int nextGreaterElement(int n) {
        char[] cArr = String.valueOf(n).toCharArray();
        int j = cArr.length - 1;
        long ans = -1;
        for(int i = cArr.length - 2; i >= 0; i--) {
            if(cArr[i] < cArr[i + 1]) {
                while(cArr[i] >= cArr[j]) {
                    j--;
                }
                char temp = cArr[i];
                cArr[i++] = cArr[j];
                cArr[j] = temp;
                j = cArr.length - 1;
                while(i < j) {
                    temp = cArr[i];
                    cArr[i++] = cArr[j];
                    cArr[j--] = temp;
                }
                ans = Long.valueOf(new String(cArr));
                if(ans > Integer.MAX_VALUE) ans = -1;
                return (int) ans;
            }
        }
        return (int) ans;
    }
}
