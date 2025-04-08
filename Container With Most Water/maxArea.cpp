#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        // Two pointer left and right
        int left = 0;
        int right = height.size()-1;
        int area = 0;
        // Iterate from left and right of the array
        // until left and right meet
        while (left < right) {
            int currentArea = (right - left) * min(height[left], height[right]);
            // Move left if element at left is less than that of right
            // Else move right
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            area = max(currentArea, area);
        }
        return area;
    }
};

int main(void) {
    vector<int> height = {1,8,6,2,5,4,8,3,7};
    Solution sol;
    cout << "Max Area of water is: " << sol.maxArea(height) << endl;
    return 0;
}