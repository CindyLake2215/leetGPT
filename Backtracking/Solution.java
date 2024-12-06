import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombos = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return letterCombos; // Return empty list if digits is empty
        }

        // Digit-to-letters mapping
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), phoneMap);
        return letterCombos;
    }

    private void backtrack(String digits, int index, StringBuilder current, Map<Character, String> phoneMap) {
        // If the current combination has the same length as digits
        if (index == digits.length()) {
            letterCombos.add(current.toString());
            return;
        }

        // Get the letters for the current digit
        String letters = phoneMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the letter
            backtrack(digits, index + 1, current, phoneMap); // Recurse for the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String digits1 = "23";
        System.out.println("Input: \"23\"");
        System.out.println("Output: " + solution.letterCombinations(digits1));

        // Test case 2
        String digits2 = "";
        System.out.println("Input: \"\"");
        System.out.println("Output: " + solution.letterCombinations(digits2));

        // Test case 3
        String digits3 = "2";
        System.out.println("Input: \"2\"");
        System.out.println("Output: " + solution.letterCombinations(digits3));
    }
}
