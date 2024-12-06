import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // If the start index reaches the end, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // Check if the substring is a palindrome
            if (isPalindrome(s, start, end)) {
                // Add the substring to the current partition
                currentPartition.add(s.substring(start, end + 1));
                // Recurse for the remaining substring
                backtrack(s, end + 1, currentPartition, result);
                // Backtrack to explore other partitions
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "aab";
        System.out.println("Input: \"aab\"");
        System.out.println("Output: " + solution.partition(s1));

        // Test case 2
        String s2 = "a";
        System.out.println("Input: \"a\"");
        System.out.println("Output: " + solution.partition(s2));
    }
}
