class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1"; // Base case
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            next.append(count).append(result.charAt(result.length() - 1));
            result = next.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 4;
        System.out.println("Input: n = 4 -> Output: " + solution.countAndSay(n1)); // Expected: "1211"

        // Test case 2
        int n2 = 1;
        System.out.println("Input: n = 1 -> Output: " + solution.countAndSay(n2)); // Expected: "1"

        // Test case 3
        int n3 = 5;
        System.out.println("Input: n = 5 -> Output: " + solution.countAndSay(n3)); // Expected: "111221"
    }
}
