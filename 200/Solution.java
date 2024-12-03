class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    markIsland(grid, i, j); // Perform DFS to mark the entire island
                }
            }
        }

        return numIslands;
    }

    private void markIsland(char[][] grid, int i, int j) {
        // Check bounds and if the cell is already water
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark the cell as visited

        // Explore the four adjacent directions
        markIsland(grid, i + 1, j); // Down
        markIsland(grid, i - 1, j); // Up
        markIsland(grid, i, j + 1); // Right
        markIsland(grid, i, j - 1); // Left
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Input: grid1 -> Output: " + solution.numIslands(grid1)); // Expected: 1

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Input: grid2 -> Output: " + solution.numIslands(grid2)); // Expected: 3
    }
}
