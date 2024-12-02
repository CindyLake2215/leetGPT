import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to strings
        String[] numStrings = Arrays.stream(nums)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        // Sort strings using a custom comparator
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Join sorted strings into a single result
        return String.join("", numStrings);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {10, 2};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + solution.largestNumber(nums1));

        // Test case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + solution.largestNumber(nums2));

        // Test case 3
        int[] nums3 = {0, 0};
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Output: " + solution.largestNumber(nums3));
    }
}
