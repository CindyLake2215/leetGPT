### Process Explanation
To solve the "Longest Palindromic Substring" problem, we can use the following steps:

1. **Understand a Palindrome**:
   - A palindrome is a string that reads the same forward and backward (e.g., "aba", "bb").
2. **Expand Around Center Technique**:
   - A palindrome can be centered on one character (odd-length) or between two characters (even-length).
   - We iterate over each possible center of the palindrome and expand outward while the substring remains a palindrome.
3. **Track the Longest Palindrome**:
   - Keep track of the start and end indices of the longest palindromic substring.
4. **Edge Cases**:
   - An empty string should return an empty result.
   - A single-character string is always a palindrome.

### Pseudocode
```text
Function longestPalindrome(s):
    If s is empty or has length 1, return s.
    Initialize start and end to track the longest palindrome's indices.
    
    For each index i in s:
        Expand around i (odd-length palindrome).
        Expand around i and i + 1 (even-length palindrome).
        Update start and end if a longer palindrome is found.
    
    Return the substring of s from start to end + 1.

Function expandAroundCenter(s, left, right):
    While left >= 0 and right < s.length and s[left] == s[right]:
        Move left pointer to the left and right pointer to the right.
    Return the length of the palindrome found.
```

### Code Solution (Java)
```java
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindrome
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String input1 = "babad";
        System.out.println("Input: " + input1);
        System.out.println("Longest Palindrome: " + solution.longestPalindrome(input1));
        
        String input2 = "cbbd";
        System.out.println("Input: " + input2);
        System.out.println("Longest Palindrome: " + solution.longestPalindrome(input2));
    }
}
```

### Explanation of the Code
1. **Main Method**:
   - The `main` method tests the solution with given examples (`"babad"` and `"cbbd"`).
2. **Expand Around Center**:
   - The helper function `expandAroundCenter` finds the longest palindrome centered at `left` and `right`.
3. **Updating Start and End**:
   - Whenever a longer palindrome is found, `start` and `end` are updated.
4. **Substring Extraction**:
   - The longest palindrome is extracted using the `substring(start, end + 1)` method.
