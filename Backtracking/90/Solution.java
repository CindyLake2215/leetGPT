import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Iterate through the array
        for (int i = startIndex; i < nums.length; i++) {
            // Skip duplicates
            if (i > startIndex && nums[i] == nums[i - 1]) continue;

            // Include the current element
            currentSubset.add(nums[i]);
            
            // Recur for the next elements
            backtrack(nums, i + 1, currentSubset, result);
            
            // Backtrack: remove the last element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 2};
        System.out.println("Input: nums = [1, 2, 2]");
        System.out.println("Output: " + solution.subsetsWithDup(nums1));

        // Test case 2
        int[] nums2 = {0};
        System.out.println("Input: nums = [0]");
        System.out.println("Output: " + solution.subsetsWithDup(nums2));
    }
}
