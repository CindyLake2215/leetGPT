class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // Dummy node to simplify the result list creation
        ListNode current = dummy; // Pointer to construct the result list
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // Value from l1 or 0 if null
            int val2 = (l2 != null) ? l2.val : 0; // Value from l2 or 0 if null

            int sum = val1 + val2 + carry; // Sum of the two digits and carry
            carry = sum / 10; // Update carry for the next iteration

            current.next = new ListNode(sum % 10); // Add the digit to the result list
            current = current.next; // Move to the next node

            // Move to the next nodes in the input lists if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // Return the head of the result list
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected: 7 -> 0 -> 8

        // Test case 2
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected: 0

        // Test case 3
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
