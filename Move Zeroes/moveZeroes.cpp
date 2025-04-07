#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        // Left is used to track 0's
        int left = 0;
        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.size(); right++) {
            // When right is pointing to non-zero element
            // and left is pointing to zero
            if (nums[right] != 0) {
                if (nums[left] == 0) {
                    // Move non-zero element to the left pointer's position
                    nums[left] = nums[right];
                    // Now set element at right pointer's position to 0
                    nums[right] = 0;
                }
                // Increment the left pointer only when we move a non-zero element
                left++;
            }
        }
    }
};

void printArray(const vector<int>& A) {
    for (int x : A) {
        cout << x << " ";
    }
    cout << endl;
}

int main(void) {
    vector<int> nums = {0,1,0,3,12};
    Solution sol;
    sol.moveZeroes(nums);
    printArray(nums);
    return 0;
}