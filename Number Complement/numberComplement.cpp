#include <iostream>

using namespace std;

class Solution {
public:
    int findComplement(int num) {
        // Create a mask with all bits set to 1
        // Primarirly bitwise NOT of 0
        int mask = ~0;
        // Now left shift the mask until all the bits of input num are covered
        while(num & mask){
            mask = mask << 1;
        }
        // Now negate the mask and return the XOR with num
        // Negating the mask ensures the mask matches the number of bits in input number
        return ~mask ^ num;
    }
};

int main(){
    Solution sol;
    int num = 5;
    cout << "Number complement of " << num << " is: " << sol.findComplement(num) << endl;
    return 0;
}