class Solution {
    public int largestAltitude(int[] gain) {
        // Current and max altitudes
        int current = 0;
        int maxAltitude = 0;
        // Iterate gain to calculate altitude
        for(int x : gain) {
            // Current altitude
            current += x;
            // Max altitude
            maxAltitude = Math.max(maxAltitude, current);
        }
        return maxAltitude;
    }
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        Solution sol = new Solution();
        System.out.println("Highest Altitude: " + sol.largestAltitude(gain));    
    }
}