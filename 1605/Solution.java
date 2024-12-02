import java.util.Arrays;

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Assign the minimum of the current row and column sums
                int value = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = value;

                // Update the rowSum and colSum
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] rowSum1 = {3, 8};
        int[] colSum1 = {4, 7};
        int[][] result1 = solution.restoreMatrix(rowSum1, colSum1);
        System.out.println("Test Case 1 Result: " + Arrays.deepToString(result1));

        // Test case 2
        int[] rowSum2 = {5, 7, 10};
        int[] colSum2 = {8, 6, 8};
        int[][] result2 = solution.restoreMatrix(rowSum2, colSum2);
        System.out.println("Test Case 2 Result: " + Arrays.deepToString(result2));
    }
}
