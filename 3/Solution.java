import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left boundary of the sliding window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1; // Move start to avoid duplicates
            }

            // Update the character's last seen index
            map.put(currentChar, end);

            // Calculate the current length and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Input: \"abcabcbb\" -> Output: " + solution.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println("Input: \"bbbbb\" -> Output: " + solution.lengthOfLongestSubstring("bbbbb"));       // Expected: 1
        System.out.println("Input: \"pwwkew\" -> Output: " + solution.lengthOfLongestSubstring("pwwkew"));   // Expected: 3
        System.out.println("Input: \"\" -> Output: " + solution.lengthOfLongestSubstring(""));               // Expected: 0
        System.out.println("Input: \"abcdef\" -> Output: " + solution.lengthOfLongestSubstring("abcdef"));   // Expected: 6
    }
}
