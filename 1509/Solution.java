import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;

        // If the array has 3 or fewer elements, we can make all values equal
        if (n <= 3) {
            return 0;
        }

        // Sort the array
        Arrays.sort(nums);

        // Calculate the possible differences
        int diff1 = nums[n - 1] - nums[3];
        int diff2 = nums[n - 2] - nums[2];
        int diff3 = nums[n - 3] - nums[1];
        int diff4 = nums[n - 4] - nums[0];

        // Return the minimum difference
        return Math.min(Math.min(diff1, diff2), Math.min(diff3, diff4));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {5, 3, 2, 4};
        System.out.println("Input: [5,3,2,4] -> Output: " + solution.minDifference(nums1)); // Expected: 0

        // Test case 2
        int[] nums2 = {1, 5, 0, 10, 14};
        System.out.println("Input: [1,5,0,10,14] -> Output: " + solution.minDifference(nums2)); // Expected: 1

        // Test case 3
        int[] nums3 = {3, 100, 20};
        System.out.println("Input: [3,100,20] -> Output: " + solution.minDifference(nums3)); // Expected: 0

        // Test case 4
        int[] nums4 = {1, 5, 6, 13, 20, 21};
        System.out.println("Input: [1,5,6,13,20,21] -> Output: " + solution.minDifference(nums4)); // Expected: 8
    }
}
