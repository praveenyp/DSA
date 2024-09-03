
// MEDIAN OF TWO SORTED ARRAY...

public class Main8 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        // Binary search boundaries
        int left = 0, right = n;

        while (left <= right) {
            // Partition positions
            int partition1 = (left + right) / 2;
            int partition2 = (n + m + 1) / 2 - partition1;

            // Edge cases: when partition is at the very beginning or end
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == n) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == m) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the combined array length is even, return the average of the two middle
                // elements
                if ((n + m) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    // If odd, return the max of the left parts
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move left in nums1
                right = partition1 - 1;
            } else {
                // Move right in nums1
                left = partition1 + 1;
            }
        }

        // If input arrays are not sorted, this exception will be thrown
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println("Median is " + findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        int[] nums1b = { 1, 2 };
        int[] nums2b = { 3, 4 };
        System.out.println("Median is " + findMedianSortedArrays(nums1b, nums2b)); // Output: 2.5
    }
}
