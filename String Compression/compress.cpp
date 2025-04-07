#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int compress(vector<char>& chars) {
        // Size of the input array
        int size = chars.size();
        // Iterate the input array
        int i = 0;
        // Length of the compressed string
        int result = 0;
        // Iterate thru' the input array and count the 
        // instances of repeated characters
        while (i < size) {
            //  count indicates the group length
            int count = 1;
            // Count the ith element being repeated thru' the array
            while (i + count < size && chars[i+count] == chars[i]) {
                count++;
            }
            // Add the character to modify the array
            chars[result] = chars[i];
            // Increment result
            result++;
            // If count > 1, add the count to the modified array
            // Increment result
            if (count > 1) {
                for (char x: to_string(count)) {
                    chars[result] = x;
                    result++;
                }
            }
            // Move the index i by the count
            i += count;
        }
        return result;
    }
};

int main(void) {
    vector<char> chars = {'a','a','b','b','c','c','c'};
    Solution sol;
    cout << "Compressed String is of length: " << sol.compress(chars) << endl;
    return 0;
}