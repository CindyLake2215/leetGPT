class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2]; // Array to store the result
        int index = 0; // Index to track visited positions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up
        int steps = 1; // Steps to move in the current direction

        int r = rStart, c = cStart; // Starting coordinates

        result[index++] = new int[]{r, c}; // Add the starting position to the result

        while (index < rows * cols) {
            for (int[] direction : directions) {
                for (int i = 0; i < steps; i++) {
                    r += direction[0]; // Move in the row direction
                    c += direction[1]; // Move in the column direction

                    // Check if the current position is within bounds
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                    }
                }
                // After two directions, increment steps (expand the spiral boundary)
                if (direction == directions[1] || direction == directions[3]) {
                    steps++;
                }
            }
        }

        return result; // Return the final array
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int rows1 = 1, cols1 = 4, rStart1 = 0, cStart1 = 0;
        int[][] result1 = solution.spiralMatrixIII(rows1, cols1, rStart1, cStart1);
        printMatrix(result1);

        // Test case 2
        int rows2 = 5, cols2 = 6, rStart2 = 1, cStart2 = 4;
        int[][] result2 = solution.spiralMatrixIII(rows2, cols2, rStart2, cStart2);
        printMatrix(result2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[" + row[0] + ", " + row[1] + "] ");
        }
        System.out.println();
    }
}
