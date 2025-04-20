#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        // Current and max altitudes
        int current = 0;
        int maxAltitude = 0;
        // Iterate gain to calculate altitude
        for(int x : gain) {
            // Current altitude
            current += x;
            // Max altitude
            maxAltitude = max(maxAltitude, current);
        }
        return maxAltitude;
    }
};

int main(void) {
    vector<int> gain = {-4,-3,-2,-1,4,3,2};
    Solution sol;
    cout << "Highest Altitude: " << sol.largestAltitude(gain) << endl;
    return 0;
}