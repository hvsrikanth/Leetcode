class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Get the size of the flowerbed
        int size = flowerbed.length;
        if(n > 0) {
            // Loop thru the flowerbed to find the possibility to put n plants
            for(int i = 0; i < size; i++) {
                // Find an empty plot and then check for eligibility to plant
                // We need 3 consecutive plots to be empty
                // Include array bounds while checking for eligibility
                if(flowerbed[i] == 0) {
                    if( (i == 0 || flowerbed[i-1] == 0) && (i == size-1 || flowerbed[i+1] == 0)) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                if(n == 0) {
                    break;
                }
            }
        }
        return (n == 0);
    }

    public static void main(String[] args) {
        int[] flowerbed = {0,0,0,0,0,1,0,0};
        int n = 0;
        Solution sol = new Solution();
        System.out.println("Can plan flowers of size " + n + ": " + sol.canPlaceFlowers(flowerbed, n));
    }
}