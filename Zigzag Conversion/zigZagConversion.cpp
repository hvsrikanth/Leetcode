#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        int sLen = s.size();
        string result = "";
        // Handle the edge case of only 1 row or rows >= string length
        if(numRows == 1 || numRows >= sLen) {
            result = s;
        } else {
            vector<string> rows(min(numRows, sLen));
            int curRow = 0;
            bool goingDown = false;
            // Traverse through each character in the string
            for (char c : s) {
                // Append character to current row
                rows[curRow] += c;
                // At first or last row, reverse direction
                if (curRow == 0 || curRow == numRows - 1){
                    goingDown = !goingDown;
                }
                curRow += goingDown ? 1 : -1;
            }
            // Combine all rows to form the result
            for (string row : rows) {
                result += row;
            }
        }
        return result;
    }
};

int main() {
    Solution sol;
    string s = "PAYPALISHIRING";
    int numRows = 15;
    cout << "Zigzag Conversion: " << sol.convert(s, numRows) << endl;
    return 0;
}
