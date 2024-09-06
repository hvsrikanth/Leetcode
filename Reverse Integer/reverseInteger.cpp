#include <iostream>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        int revX = 0;
        int lastDigit = 0;
        while (x != 0) {
            // Get the last digit from the number
            lastDigit = x % 10;

            // Check for overflow before updating rev
            // INT32_MAX = 2^31 - 1 = 2147483647. Hence check for lastDigit > 7
            if (revX > INT32_MAX / 10 || (revX == INT32_MAX / 10 && lastDigit > 7)) {
                revX = 0;
                break;
            }
            // INT32_MIN = -2^31 = -2147483648. Hence check for lastDigit < -8
            if (revX < INT32_MIN / 10 || (revX == INT32_MIN / 10 && lastDigit < -8)) {
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
};

int main(void) {
    Solution sol;
    int x = 10020;
    cout << "Reversed: " << sol.reverse(x) << endl;
    return 0;
}