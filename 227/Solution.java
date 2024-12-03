import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        char lastOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0'); // Build the current number
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                // Process the last operator
                if (lastOperator == '+') {
                    stack.push(currentNum);
                } else if (lastOperator == '-') {
                    stack.push(-currentNum);
                } else if (lastOperator == '*') {
                    stack.push(stack.pop() * currentNum);
                } else if (lastOperator == '/') {
                    stack.push(stack.pop() / currentNum);
                }

                // Update the operator and reset current number
                lastOperator = c;
                currentNum = 0;
            }
        }

        // Sum up all the numbers in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "3+2*2";
        System.out.println("Input: \"" + s1 + "\" -> Output: " + solution.calculate(s1)); // Expected: 7

        // Test case 2
        String s2 = " 3/2 ";
        System.out.println("Input: \"" + s2 + "\" -> Output: " + solution.calculate(s2)); // Expected: 1

        // Test case 3
        String s3 = " 3+5 / 2 ";
        System.out.println("Input: \"" + s3 + "\" -> Output: " + solution.calculate(s3)); // Expected: 5
    }
}
