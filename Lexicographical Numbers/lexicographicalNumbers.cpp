#include <iostream>
#include <vector>
using namespace std;

void printArray(const vector<int> &A){
    cout << "[ ";
    if(!A.empty()) {
        for(int x : A){
            cout << x << " ";
        }
    }
    cout << " ]" << endl;
}

class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<int> lexicalNumbers;
        int current = 1;
        // Generate lexical numbers from 1 to n
        for(int i = 0; i < n; i++){
            // Add the current number to the lexical list of numbers
            lexicalNumbers.push_back(current);
            // Move to the next lexically valid number by 
            // multiplying current by 10
            if(current * 10 <= n){
                current *= 10;
            } else {
                // current has moved out of range of n
                // Adjust the value of current to move to the next
                // lexically valid number
                while(current >= n || current % 10 == 9){
                    current /= 10;
                }
                // Increment current
                current++;
            }
        }
        return lexicalNumbers;
    }
};

int main() {
    Solution sol;
    int n = 13;
    vector<int> output = sol.lexicalOrder(n);
    printArray(output);
    return 0;
}