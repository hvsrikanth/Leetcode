#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        int sLen = s.length();
        int i = 0;
        int sign = 1;
        int result = 0;
        // Skip leading spaces
        while (i < sLen && s[i] == ' '){
            i++;
        }
        // Check for sign character
        if (i < sLen && (s[i] == '-' || s[i] == '+')) {
            sign = (s[i] == '-' ? -1 : 1);
            i++;
        }
        // Skip leading zeros
        while (i < sLen && s[i] == '0') {
            i++;
        }
        // Now convert digits to integer if the character is not an alphabet
        while (i < sLen && isdigit(s[i])) {
            int digit = s[i] - '0';
            // Check for overflow or underflow of int before adding the digit
            if(result > INT32_MAX / 10 || (result == INT32_MAX / 10 && digit > 7) ) {
                result = (sign == 1) ? INT32_MAX : INT32_MIN;
                sign = 1;
                break;
            }
            // Add digit to the result
            result = result * 10 + digit;
            i++;
        }
        return (result * sign);
    }
};

int main(void) {
    Solution sol;
    string s = "    -1337c0d3";
    cout << "Input: " << s << "\t" <<  "Converted string: " << sol.myAtoi(s) << endl;
    s = "   words are 2";
    cout << "Input: " << s << "\t" <<  "Converted string: " << sol.myAtoi(s) << endl;
    s = "91283472332"; // INT32_MAX overflow case
    cout << "Input: " << s << "\t" <<  "Converted string: " << sol.myAtoi(s) << endl;
    s = "2147483648"; // INT32_MAX overflow case; One more than INT32_MAX
    cout << "Input: " << s << "\t" <<  "Converted string: " << sol.myAtoi(s) << endl;
    s = "-2147483648"; // Equal to INT32_MIN
    cout << "Input: " << s << "\t" <<  "Converted string: " << sol.myAtoi(s) << endl;
    return 0;
}