class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0; // child pointer
        int j = 0; // cookie pointer
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // cookie can satisfy child
                i++;
            }
            // move to next cookie
            j++;
        }
        
        return i;
    }
}