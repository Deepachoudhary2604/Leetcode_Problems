class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];

                if (val < 0) negCount++;

                int absVal = Math.abs(val);
                sum += absVal;
                minAbs = Math.min(minAbs, absVal);
            }
        }

        // agar negatives odd hain → ek minimum abs value ko negative rehna padega
        if (negCount % 2 == 1) {
            sum -= 2L * minAbs;
        }

        return sum;
    }
}
