import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort by height desc, k asc
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1]; // smaller k first
                } else {
                    return b[0] - a[0]; // taller first
                }
            }
        });

        // Step 2: Insert into list at index = k
        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }

        // Step 3: Convert back to int[][]
        return ans.toArray(new int[people.length][2]);
    }
}
