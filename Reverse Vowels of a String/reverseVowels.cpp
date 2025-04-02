#include <string>
#include <iostream>
using namespace std;

class Solution {
private:
    // Method to check for vowel
    bool isVowel(char c) {
        c = tolower(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
public:
    string reverseVowels(string s) {
        // Initialize left and right pointers
        int left = 0;
        int right = s.length()-1;
        // Loop thru' the string and look for vowels from left and right
        while(left < right) {
            // If vowel is found at left and right pointers
            // swap the vowels and adjust pointers towards each other
            if(isVowel(s[left]) && isVowel(s[right])) {
                swap(s[left], s[right]);
                left++;
                right--;
            }
            // Move left towards right until a vowel is found
            if(left < right && !isVowel(s[left])) {
                left++;
            }
            // Move right towards left until a vowel is found
            if(right > left && !isVowel(s[right])) {
                right--;
            }
        }
        return s;
    }
};

int main(void) {
    string s = "IceCreAm";
    Solution sol;
    cout << "Reversal of vowels in " << s << " is: " << sol.reverseVowels(s) << endl;
    return 0;
}