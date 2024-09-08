#include <iostream>

using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        bool gotPalindrome = false;
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
                if (reversed > INT32_MAX / 10) {
                    break;
                }
                // Remove last digit from the number
                temp /= 10;
            }
            gotPalindrome = (x == reversed);
        }
        return gotPalindrome;
    }
};

int main(void) {
    Solution sol;
    int x = 21412;
    cout << "Is " << x << " a palindrome? " << sol.isPalindrome(x) << endl;
    return 0;
}