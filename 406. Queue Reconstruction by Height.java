class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        ans.add(people[0]);
        for(int i = 1; i < people.length; i++) {
            ans.add(people[i][1], people[i]);
        }
        int[][] res = new int[people.length][2];
        int j = 0;
        for(int[] o :ans) {
//            System.out.println(o[0] +":"+o[1]);
            res[j][0] = o[0];
            res[j++][1] = o[1];
        }
        return res;
    }
}
