import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If the current number exceeds the target, no need to continue
            if (candidates[i] > target) break;

            // Include the current number
            current.add(candidates[i]);

            // Recur with reduced target and next index
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            // Backtrack by removing the last number added
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println("Input: candidates = [10, 1, 2, 7, 6, 1, 5], target = 8");
        System.out.println("Output: " + solution.combinationSum2(candidates1, target1));

        // Test case 2
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println("Input: candidates = [2, 5, 2, 1, 2], target = 5");
        System.out.println("Output: " + solution.combinationSum2(candidates2, target2));
    }
}
