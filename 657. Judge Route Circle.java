class Solution {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0) return true;
        int[] arr = new int[2];
        
        for(int i = 0; i < moves.length(); i++) {
            char curr = moves.charAt(i);
            if(curr == 'U') arr[0]++;
            if(curr == 'D') arr[0]--;
            if(curr == 'L') arr[1]++;
            if(curr == 'R') arr[1]--;
        }
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) return false;
        }
        return true;
    }
}
