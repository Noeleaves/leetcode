class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        long ans = 0;
        int count = 1;
        str = str.trim();
        for(int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(i == 0 && cur == '-') {
                count = -1;
            }else if(i == 0 && cur == '+'){
                continue;
            }else if(!Character.isDigit(cur)) {
                break;
            }else {
                ans*=10;
                ans += (cur - '0');
                if(ans*count >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(ans*count <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int) ans*count;
    }
}
