import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i}; // Return indices
            }

            // Store the current number and its index
            map.put(nums[i], i);
        }

        // Should never reach here if there is exactly one solution
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9 -> Output: " + java.util.Arrays.toString(solution.twoSum(nums1, target1))); // Expected: [0, 1]

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: nums = [3, 2, 4], target = 6 -> Output: " + java.util.Arrays.toString(solution.twoSum(nums2, target2))); // Expected: [1, 2]

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Input: nums = [3, 3], target = 6 -> Output: " + java.util.Arrays.toString(solution.twoSum(nums3, target3))); // Expected: [0, 1]
    }
}
