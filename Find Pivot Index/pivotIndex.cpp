#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int pivot = -1;
        int leftSum = 0;
        int rightSum = 0;
        // Calculate rightSum
        for(int x : nums) {
            rightSum += x;
        }
        // Now iterate nums to calculate leftSum at each i
        for(int i = 0; i < nums.size(); i++) {
            // Subtract current element from rightSum
            rightSum -= nums[i];
            // Check leftSum and rightSum are equal
            if(leftSum == rightSum) {
                pivot = i;
                break;
            }
            // Add current element to leftSum
            leftSum += nums[i];
        }
        return pivot;
    }
};

int main(void) {
    vector<int> nums = {1,7,3,6,5,6};
    Solution sol;
    cout << "Pivot Index is: " << sol.pivotIndex(nums) << endl;
    return 0;
}