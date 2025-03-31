class Solution {
    // Method to calculate GCD
    public int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }
    public String gcdOfStrings(String str1, String str2) {
        StringBuffer result = new StringBuffer();
        // Check if both strings are same when concatenated
        // with each other
        if((str1 + str2).equals(str2 + str1)) {
            // GCD of lengths of str1 and str2 will give the
            // length of the string pattern repeated in both strings
            int gcdLen = gcd(str1.length(), str2.length());
            result.append(str1.substring(0, gcdLen));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "ABCABCABC";
        String s2 = "ABCABC";
        System.out.println("GCD of input strings is: " + sol.gcdOfStrings(s1, s2));
    }
}