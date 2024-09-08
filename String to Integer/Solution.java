class Solution {
    public int myAtoi(String s) {
        int sLen = s.length();
        int i = 0;
        int sign = 1;
        int result = 0;
        // Skip leading spaces
        while (i < sLen && s.charAt(i) == ' '){
            i++;
        }
        // Check for sign character
        if (i < sLen && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-' ? -1 : 1);
            i++;
        }
        // Skip leading zeros
        while (i < sLen && s.charAt(i) == '0') {
            i++;
        }
        // Now convert digits to integer if the character is not an alphabet
        while (i < sLen && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Check for overflow or underflow of int before adding the digit
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7) ) {
                result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                sign = 1;
                break;
            }
            // Add digit to the result
            result = result * 10 + digit;
            i++;
        }
        return (result * sign);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "    -1337c0d3";
        s = "";
        System.out.println("Input: " + s +  "\tConverted string: " + sol.myAtoi(s));
        s = "   words are 2";
        System.out.println("Input: " + s +  "\tConverted string: " + sol.myAtoi(s));
        s = "91283472332"; // INT32_MAX overflow case
        System.out.println("Input: " + s +  "\tConverted string: " + sol.myAtoi(s));
        s = "2147483648"; // INT32_MAX overflow case; One more than INT32_MAX
        System.out.println("Input: " + s +  "\tConverted string: " + sol.myAtoi(s));
        s = "-2147483648"; // Equal to INT32_MIN
        System.out.println("Input: " + s +  "\tConverted string: " + sol.myAtoi(s));
    }
}