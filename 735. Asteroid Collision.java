class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[]{};
        Stack<Integer> s = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] < 0) {
                ans.push(asteroids[i]);
                while(!s.isEmpty()) {
                    if(s.peek() < Math.abs(asteroids[i])) {
                        s.pop();
                    }else if(s.peek() == Math.abs(asteroids[i])) {
                        s.pop();
                        ans.remove(ans.size() - 1);
                        break;
                    }else {
                        ans.remove(ans.size() - 1);
                        break;
                    }
                }
            }else if(asteroids[i] > 0) {
                s.push(asteroids[i]);
            }
        }
        int[] res = new int[ans.size() + s.size()];
        int j = 0;
        while(!s.isEmpty()) {
            res[res.length - 1 - j] = s.pop();
            j++;
        }
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
        
    }
}
