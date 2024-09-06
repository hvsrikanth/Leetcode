class Solution {
    public int reverse(int x) {
        int revX = 0;
        int lastDigit = 0;
        while (x != 0) {
            // Get the last digit from the number
            lastDigit = x % 10;
            // Check for overflow before updating rev
            // INT32_MAX = 2^31 - 1 = 2147483647. Hence check for lastDigit > 7
            if (revX > Integer.MAX_VALUE / 10 || (revX == Integer.MIN_VALUE / 10 && lastDigit > 7)) {
                revX = 0;
                break;
            }
            // INT32_MIN = -2^31 = -2147483648. Hence check for lastDigit < -8
            if (revX < Integer.MIN_VALUE / 10 || (revX == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                revX = 0;
                break;
            }
            // Add the last digit to the reversed number
            revX = revX * 10 + lastDigit;
            // Remove last digit from the number
            x /= 10;
        }
        return revX;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int x = 10020;
        System.out.println("Reversed: " + sol.reverse(x));
    }
}