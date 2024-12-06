class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start a DFS search if the first character matches
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // If the entire word is matched
        if (index == word.length()) {
            return true;
        }

        // Check boundary conditions and if the character matches
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four directions
        boolean found = dfs(board, word, index + 1, row - 1, col) ||  // Up
                        dfs(board, word, index + 1, row + 1, col) ||  // Down
                        dfs(board, word, index + 1, row, col - 1) ||  // Left
                        dfs(board, word, index + 1, row, col + 1);    // Right

        // Restore the current cell
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println("Input: board = [[A,B,C,E],[S,F,C,S],[A,D,E,E]], word = ABCCED");
        System.out.println("Output: " + solution.exist(board1, word1)); // true

        // Test case 2
        char[][] board2 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word2 = "SEE";
        System.out.println("Input: board = [[A,B,C,E],[S,F,C,S],[A,D,E,E]], word = SEE");
        System.out.println("Output: " + solution.exist(board2, word2)); // true

        // Test case 3
        char[][] board3 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word3 = "ABCB";
        System.out.println("Input: board = [[A,B,C,E],[S,F,C,S],[A,D,E,E]], word = ABCB");
        System.out.println("Output: " + solution.exist(board3, word3)); // false
    }
}
