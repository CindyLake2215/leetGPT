class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Calculate prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products and update the result
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: [1,2,3,4] -> Output: " + java.util.Arrays.toString(solution.productExceptSelf(nums1))); // Expected: [24,12,8,6]

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input: [-1,1,0,-3,3] -> Output: " + java.util.Arrays.toString(solution.productExceptSelf(nums2))); // Expected: [0,0,9,0,0]

        // Test case 3
        int[] nums3 = {2, 3};
        System.out.println("Input: [2,3] -> Output: " + java.util.Arrays.toString(solution.productExceptSelf(nums3))); // Expected: [3,2]
    }
}
