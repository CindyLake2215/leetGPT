import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Add the triplet to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Move left pointer right to increase the sum
                } else {
                    right--; // Move right pointer left to decrease the sum
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + solution.threeSum(nums1));

        // Test case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + solution.threeSum(nums2));

        // Test case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Output: " + solution.threeSum(nums3));
    }
}
