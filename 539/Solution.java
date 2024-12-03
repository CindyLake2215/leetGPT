import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Convert all times to minutes from midnight
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int totalMinutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            minutes.add(totalMinutes);
        }

        // Sort the times
        Collections.sort(minutes);

        // Initialize minimum difference
        int minDiff = Integer.MAX_VALUE;

        // Compare consecutive times
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        // Circular difference between the last and first time
        int circularDiff = 1440 - (minutes.get(minutes.size() - 1) - minutes.get(0));
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<String> timePoints1 = List.of("23:59", "00:00");
        System.out.println("Input: " + timePoints1 + " -> Output: " + solution.findMinDifference(timePoints1)); // Expected: 1

        // Test case 2
        List<String> timePoints2 = List.of("00:00", "23:59", "00:00");
        System.out.println("Input: " + timePoints2 + " -> Output: " + solution.findMinDifference(timePoints2)); // Expected: 0

        // Test case 3
        List<String> timePoints3 = List.of("01:10", "22:30", "13:45", "12:00");
        System.out.println("Input: " + timePoints3 + " -> Output: " + solution.findMinDifference(timePoints3)); // Expected: Minimum Difference
    }
}
