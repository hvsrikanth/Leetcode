public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // Ensuring the first array is the smaller array
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        // Get m and n sizes of the each input array
        int m = A.length;
        int n = B.length;
        int low = 0, high = m;
        double median = 0.0;
        // Perform binary search until low <= high
        // Adjust low and high as we partition the input arrays
        while (low <= high) {
            // Initial partition values
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;
            /*
             * Calculate maxLeftA, minRightA, maxLeftB, minRightB
             * Variables used to adjust binary search based on these values
            */
            // If i == 0, it means that no elements from A are included in the left half.
            // Hence consider the maximum value of the left half of A to be INTMIN since there's no element from A on the left.
            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            // If i == m, it means that all elements of A are in the left half.
            // Hence consider the smallest value of the right half of A to be INTMAX since there's no element from A on the right.
            int minRightA = (i == m) ? Integer.MAX_VALUE : A[i];
            // If j == 0, it means that no elements from B are included in the left half.
            // Hence consider the maximum value of the left half of B to be INTMIN since there's no element from B on the left.
            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            // If j == n, it means that all elements of B are in the left half.
            // Hence consider the smallest value of the right half of B to be INTMAX since there's no element from B on the right.
            int minRightB = (j == n) ? Integer.MAX_VALUE : B[j];
            // Check for valid partition
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Found the correct partition
                if ((m + n) % 2 == 0) {
                    // Median calculation for even length of combined arrays
                    median = (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                    break;
                } else {
                    // Median calculation for odd length of combined arrays
                    median = Math.max(maxLeftA, maxLeftB);
                    break;
                }
            // Adjust binary search if the partition is not valid
            } else if (maxLeftA > minRightB) {
                // Move the partition to left
                high = i - 1;
            } else {
                // Move the partition to right
                low = i + 1;
            }
        }
        return median;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {2, 4, 6, 8, 10};
        int[] B = {3, 5, 7, 9, 11, 13, 15};
        double median = sol.findMedianSortedArrays(A, B);
        System.out.println("The median is: " + median);
    }
}
