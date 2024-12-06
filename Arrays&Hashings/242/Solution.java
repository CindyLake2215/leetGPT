class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: Check length
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency count using an array
        int[] count = new int[26]; // For lowercase English letters only

        for (char c : s.toCharArray()) {
            count[c - 'a']++; // Increment for string s
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--; // Decrement for string t
        }

        // Step 3: Validate the frequency array
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\" -> Output: " + solution.isAnagram(s1, t1)); // Expected: true

        // Test case 2
        String s2 = "rat", t2 = "car";
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\" -> Output: " + solution.isAnagram(s2, t2)); // Expected: false

        // Test case 3
        String s3 = "a", t3 = "a";
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\" -> Output: " + solution.isAnagram(s3, t3)); // Expected: true

        // Test case 4
        String s4 = "aacc", t4 = "ccac";
        System.out.println("Input: s = \"" + s4 + "\", t = \"" + t4 + "\" -> Output: " + solution.isAnagram(s4, t4)); // Expected: false
    }
}
