import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to group anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the string to use as a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            // Add the string to the group corresponding to the sorted key
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(strs1) + " -> Output: " + solution.groupAnagrams(strs1));

        // Test case 2
        String[] strs2 = {""};
        System.out.println("Input: " + Arrays.toString(strs2) + " -> Output: " + solution.groupAnagrams(strs2));

        // Test case 3
        String[] strs3 = {"a"};
        System.out.println("Input: " + Arrays.toString(strs3) + " -> Output: " + solution.groupAnagrams(strs3));
    }
}
