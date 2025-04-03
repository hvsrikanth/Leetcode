#include <string>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    string reverseWords(string s) {
    int n = s.length();
    string result;
    int end = n - 1;
    // Iterate thru' the string from the end
    while (end >= 0) {
        // Skip trailing spaces
        while (end >= 0 && s[end] == ' ') {
            end--;
        }
        if (end < 0) break;
        // Find the start of the word
        int start = end;
        while (start >= 0 && s[start] != ' ') {
            start--;
        }
        // Add the word to the result
        // If the result is already filled add a space
        // before adding the word
        if (!result.empty()) {
            result += ' ';
        }
        result += s.substr(start + 1, end - start);
        // Move to the next word
        end = start - 1;
    }
    return result;
    }
};

int main(void) {
    string s = "the sky is blue";
    s = "  hello world  ";
    s = "a good   example";
    Solution sol;
    cout <<"Reverse worded string is: " << sol.reverseWords(s) << endl;
    return 0;
}