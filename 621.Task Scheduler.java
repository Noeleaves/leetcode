class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        int[] category = new int[26];
        int ans = 0;
        int maxTasks = 1;
        for(int i = 0; i < tasks.length; i++) {
            category[tasks[i] - 'A']++;
        }
        Arrays.sort(category);
        int maxCount = category[category.length - 1];
        for(int i = category.length - 2; i >= 0; i--) {
            if(category[i] != category[i+1]) break;
            maxTasks++;
        }
        ans = Math.max(maxTasks * maxCount + (maxCount - 1) * (n - (maxTasks - 1)), tasks.length); 
        return ans;
    }
}
