class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = n % 14;
        if (n == 0) n = 14;
        for (int day = 0; day < n; day++) {
            int[] next = new int[8];
            next[0] = 0;
            next[7] = 0;
            for (int j = 1; j < 7; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    next[j] = 1;
                } else {
                    next[j] = 0;
                }
            }

            cells = next; 
        }
        return cells;
    }
}