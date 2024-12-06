import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Input: [100, 4, 200, 1, 3, 2] -> Output: " + solution.longestConsecutive(nums1)); // Expected: 4

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Input: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1] -> Output: " + solution.longestConsecutive(nums2)); // Expected: 9

        // Test case 3
        int[] nums3 = {};
        System.out.println("Input: [] -> Output: " + solution.longestConsecutive(nums3)); // Expected: 0
    }
}
