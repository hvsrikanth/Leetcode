#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        // Sort the input array in ascending order
        sort(nums.begin(), nums.end());
        int count = 0;
        // Two pointers to the input array
        int left = 0;
        int right = nums.size()-1;
        // Now iterate over the input array to find k sum pairs
        while (left < right) {
            // Pair found increment count and move the pointers towards each other
            if(nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k) {
                // Sum is less than k; Move only left
                left++;
            } else {
                // Sum is more than k; Move only right
                right--;
            }
        }
        return count;
    }
};

int main(void) {
    vector<int> nums = {3,1,3,4,3};
    int k = 6;
    Solution sol;
    cout << "Number of Operations: " << sol.maxOperations(nums, k) << endl;
    return 0;
}