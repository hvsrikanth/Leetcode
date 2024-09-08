class Solution {
    public boolean isPalindrome(int x) {
        boolean gotPalindrome = false;
        int temp = x;
        int reversed = 0;
        // -ve numbers are not palindromes
        if (x < 0) {
           gotPalindrome = false;
        } else {
            while(temp != 0) {
                // Get the last digit and add to the reversed number
                reversed = reversed * 10 + temp % 10;
                // Check for overflow before updating reverse
                if (reversed > Integer.MAX_VALUE / 10) {
                    break;
                }
                // Remove last digit from the number
                temp /= 10;
            }
            gotPalindrome = (x == reversed);
        }
        return gotPalindrome;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int x = 21412;
        System.out.println("Is " + x + " a palindrome? " + sol.isPalindrome(x));
    }
}