# 1732. Find the Highest Altitude - Leetcode Problem  

*Difficulty - Easy*  

[Leetcode Link - Find the Highest Altitude](https://leetcode.com/problems/find-the-highest-altitude/)  

## Description
There is a biker going on a road trip. The road trip consists of `n + 1` points at different altitudes. The biker starts his trip on point `0` with altitude equal `0`.  
You are given an integer array `gain` of length `n` where `gain[i]` is the **net gain in altitude** between points `i`​​​​​​ and `i + 1` for all (`0 <= i < n`). Return the highest altitude of a point.

## Example 1:
Input: `gain = [-5,1,5,0,-7]`  
Output: `1`
Explanation: The altitudes are `[0,-5,-4,1,1,-6]`. The highest is `1`.

## Example 2:
Input: `gain = [-4,-3,-2,-1,4,3,2]`  
Output: `0`  
Explanation: The altitudes are `[0,-4,-7,-9,-10,-6,-3,-1]`. The highest is `0`.

## Constraints:
`n == gain.length`  
`1 <= n <= 100`  
`-100 <= gain[i] <= 100`

## Solution
Description clearly gives a hint to use **Prefix Sum** array. However, we will not create it. We only will use the technique, to find current altitude as we traverse the array.
* Initialization
    * `current` is the gain at point `i` as we traverse the array. Starts with `0`.
    * `maxAltitude` is the maximum altitude gained.
* For each `gain[i]`
    * Calculate `current` as `current += gain[i]`.
    * Update `maxAltitude` if `maxAltitude > current`.
* Return maxAltitude.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, `n`.

## Space Complexity:
* **O(1):** Constant space is used in terms of variables `current` and `maxAltitude`.

## Dry Run

Input: `gain = [-4,-3,-2,-1,4,3,2]`  
Variables: `current = 0`, `maxAltitude = 0`

| i | gain[i] | current      | maxAltitude     |
| - | ------- | ------------ | --------------- |
| 0 | -4      | 0 - 4 = -4   | max(0, -4) = 0  |
| 1 | -3      | -4 - 3 = -7  | max(0, -7) = 0  |
| 2 | -2      | -7 - 2 = -9  | max(0, -9) = 0  |
| 3 | -1      | -9 - 1 = -10 | max(0, -10) = 0 |
| 4 | 4       | -10 + 4 = -6 | max(0, -6) = 0  |
| 5 | 3       | -6 + 3 = -3  | max(0, -3) = 0  |
| 6 | 2       | -3 + 2 = -1  | max(0, -1) = 0  |

Return `maxAltitude = 0`.

## Source Code
[C++ Implementation](./largestAltitude.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*