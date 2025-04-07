class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean tripletExists = false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        // Iterate thru' the nums array to find
        // first < second < third
        for (int x : nums) {
            // We find a number greater than second
            // We have our triplet
            if (x > second) {
                tripletExists = true;
                break;
            }
            // We find a number greater than first
            // Then It is second
            // Else it is first
            if ( x > first) {
                second = x;
            } else {
                first = x;
            }
        }
        return tripletExists;
    }
    public static void main(String[] args) {
        int nums[] = {2,1,5,0,4,6};
        Solution sol = new Solution();
        System.out.println("Increasing triplet subsequence exists: " + sol.increasingTriplet(nums));
    }
}