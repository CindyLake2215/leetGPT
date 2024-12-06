import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation, boolean[] used, List<List<Integer>> result) {
        // Base case: If the current permutation has all elements
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Iterate through each number in nums
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip already used elements

            // Choose the element
            currentPermutation.add(nums[i]);
            used[i] = true;

            // Recur with the updated state
            backtrack(nums, currentPermutation, used, result);

            // Backtrack: Remove the last element and mark it as unused
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: nums = [1, 2, 3]");
        System.out.println("Output: " + solution.permute(nums1));

        // Test case 2
        int[] nums2 = {0, 1};
        System.out.println("Input: nums = [0, 1]");
        System.out.println("Output: " + solution.permute(nums2));

        // Test case 3
        int[] nums3 = {1};
        System.out.println("Input: nums = [1]");
        System.out.println("Output: " + solution.permute(nums3));
    }
}
