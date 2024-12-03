class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n; // Each cell is divided into 4 regions
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int root = 4 * (i * n + j); // Starting index for the current cell
                char val = grid[i].charAt(j);

                // Merge regions within the cell
                if (val == ' ') {
                    uf.union(root, root + 1);
                    uf.union(root + 1, root + 2);
                    uf.union(root + 2, root + 3);
                } else if (val == '/') {
                    uf.union(root, root + 3);
                    uf.union(root + 1, root + 2);
                } else if (val == '\\') {
                    uf.union(root, root + 1);
                    uf.union(root + 2, root + 3);
                }

                // Merge with right neighbor
                if (j + 1 < n) {
                    uf.union(root + 1, 4 * (i * n + (j + 1)) + 3);
                }
                // Merge with bottom neighbor
                if (i + 1 < n) {
                    uf.union(root + 2, 4 * ((i + 1) * n + j));
                }
            }
        }

        return uf.count(); // Return the total number of connected components
    }

    // Union-Find helper class
    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] grid1 = {
            " /",
            "/ "
        };
        System.out.println("Input: grid1 -> Output: " + solution.regionsBySlashes(grid1)); // Expected: 2

        // Test case 2
        String[] grid2 = {
            " /",
            "  "
        };
        System.out.println("Input: grid2 -> Output: " + solution.regionsBySlashes(grid2)); // Expected: 1

        // Test case 3
        String[] grid3 = {
            "/\\",
            "\\/"
        };
        System.out.println("Input: grid3 -> Output: " + solution.regionsBySlashes(grid3)); // Expected: 5
    }
}
