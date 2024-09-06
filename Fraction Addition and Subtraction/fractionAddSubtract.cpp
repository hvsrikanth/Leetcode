#include <iostream>
#include <string>

using namespace std;

class Solution {
private:
    // Helper function to compute GCD of two numbers
    int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }

public:
    string fractionAddition(string expression) {
        int expSize = expression.size();
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
            if (expression[i] == '-' || expression[i] == '+') {
                // sign becomes -1 if negative
                sign = (expression[i] == '-') ? -1 : 1;
                // Increment the counter
                i++;
            }

            // Parse the numerator
            int tempNumerator = 0;
            while (isdigit(expression[i])) {
                // Numerator can be more than 1 digit
                // Derive numeric value from the ascii value difference
                tempNumerator = tempNumerator * 10 + (expression[i] - '0');
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
            while (i < expSize && isdigit(expression[i])) {
                tempDenominator = tempDenominator * 10 + (expression[i] - '0');
                i++;
            }

            // Add the fraction to the current result
            numerator = numerator * tempDenominator + tempNumerator * denominator;
            denominator = denominator * tempDenominator;

            // Simplify the fraction by dividing by GCD
            int gcdValue = gcd(abs(numerator), abs(denominator));
            numerator /= gcdValue;
            denominator /= gcdValue;
        }
        // Return simplified fraction
        return to_string(numerator) + "/" + to_string(denominator);
    }
};

int main() {
    Solution sol;
    string expression = "-1/12-5/12+7/12-11/12";
    cout << "Result: " << sol.fractionAddition(expression) << endl;

    return 0;
}