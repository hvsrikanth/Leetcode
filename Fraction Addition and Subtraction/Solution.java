class Solution {
    // Helper function to compute GCD of two numbers
    public static int gcd(int a, int b) {
        return (a == 0 ? b : gcd(b % a, a));
    }

    // Helper function to check if a character is numeric
    public static boolean isNumeric(char c) { 
        if(Character.isDigit(c)){
            return true;
        } else {
            return false;
        }
    }

    public String fractionAddition(String expression) {
        int expSize = expression.length();
        // Initialize the resulting fraction as 0 / 1
        int numerator = 0;
        int denominator = 1;
        // Counter to iterate thru' the expression
        int i = 0;
        int sign = 1;
        while (i < expSize) {
            // Parse the sign
            // Default sign is +ve if no leading sign in the expression
            sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                // sign becomes -1 if negative
                sign = (expression.charAt(i) == '-') ? -1 : 1;
                // Increment the counter
                i++;
            }

            // Parse the numerator
            int tempNumerator = 0;
            while (isNumeric(expression.charAt(i))) {
                // Numerator can be more than 1 digit
                // Derive numeric value from the ascii value difference
                tempNumerator = tempNumerator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            // Apply the sign to the numerator
            tempNumerator *= sign;

            // Skip the '/' character
            i++;

            // Parse the denominator
            int tempDenominator = 0;
            // Denominator can be more than 1 digit
            // Derive the numeric value from the ascii value difference
            while (i < expSize && isNumeric(expression.charAt(i))) {
                tempDenominator = tempDenominator * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Add the fraction to the current result
            numerator = numerator * tempDenominator + tempNumerator * denominator;
            denominator = denominator * tempDenominator;

            // Simplify the fraction by dividing by GCD
            int gcdValue = gcd(Math.abs(numerator), denominator);
            numerator /= gcdValue;
            denominator /= gcdValue;
        }
        // Return simplified fraction
        return (numerator + "/" + denominator);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String expression = "-1/12-5/12+7/12-11/12";
        System.out.println("Result: " + sol.fractionAddition(expression));    
    }
}