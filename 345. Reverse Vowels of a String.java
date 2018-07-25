class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('o');
        set.add('i');
        set.add('e');
        set.add('u');
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        
        while(i < j) {
            if(!set.contains(Character.toLowerCase(c[i]))) i += 1;
            if(!set.contains(Character.toLowerCase(c[j]))) j -= 1;
            if(set.contains(Character.toLowerCase(c[i])) && set.contains(Character.toLowerCase(c[j]))) {
                char tmp = c[i];
                c[i++] = c[j];
                c[j--] = tmp;
            }
        }
        return String.valueOf(c);
    }
}
