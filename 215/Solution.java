import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array
        for (int num : nums) {
            minHeap.add(num); // Add the current number to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if heap size exceeds k
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", k = " + k1 + " -> Output: " + solution.findKthLargest(nums1, k1)); // Expected: 5

        // Test case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", k = " + k2 + " -> Output: " + solution.findKthLargest(nums2, k2)); // Expected: 4
    }
}
