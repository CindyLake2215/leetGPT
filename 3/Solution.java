import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last index of each character
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left boundary of the window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and within the current window
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= start) {
                start = charIndex.get(currentChar) + 1; // Move the start to avoid the duplicate
            }

            // Update the last index of the current character
            charIndex.put(currentChar, end);

            // Calculate the length of the current substring and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";

        System.out.println("Input: " + input1 + " -> Output: " + solution.lengthOfLongestSubstring(input1)); // Expected: 3
        System.out.println("Input: " + input2 + " -> Output: " + solution.lengthOfLongestSubstring(input2)); // Expected: 1
        System.out.println("Input: " + input3 + " -> Output: " + solution.lengthOfLongestSubstring(input3)); // Expected: 3
    }
}
