import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int startIndex, List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: If the target becomes zero, add the combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through the candidates starting from startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // Skip if the candidate is larger than the remaining target

            // Choose the candidate
            currentCombination.add(candidates[i]);

            // Recursively call with the updated target (remaining target minus the candidate)
            backtrack(candidates, target - candidates[i], i, currentCombination, result);

            // Backtrack: Remove the last added element
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Input: candidates = [2, 3, 6, 7], target = 7");
        System.out.println("Output: " + solution.combinationSum(candidates1, target1));

        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Input: candidates = [2, 3, 5], target = 8");
        System.out.println("Output: " + solution.combinationSum(candidates2, target2));

        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Input: candidates = [2], target = 1");
        System.out.println("Output: " + solution.combinationSum(candidates3, target3));
    }
}
