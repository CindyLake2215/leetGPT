import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert numbers to strings
        String[] numStrings = Arrays.stream(nums)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        // Sort using custom comparator
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Join sorted strings to form the largest number
        return String.join("", numStrings);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {10, 2};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + solution.largestNumber(nums1)); // Expected: "210"

        // Test case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + solution.largestNumber(nums2)); // Expected: "9534330"

        // Test case 3
        int[] nums3 = {1};
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Output: " + solution.largestNumber(nums3)); // Expected: "1"

        // Test case 4
        int[] nums4 = {10};
        System.out.println("Input: " + Arrays.toString(nums4) + " -> Output: " + solution.largestNumber(nums4)); // Expected: "10"

        // Test case 5
        int[] nums5 = {0, 0};
        System.out.println("Input: " + Arrays.toString(nums5) + " -> Output: " + solution.largestNumber(nums5)); // Expected: "0"
    }
}
