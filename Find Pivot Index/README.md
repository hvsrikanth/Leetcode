# 724. Find Pivot Index - Leetcode Problem  

*Difficulty - Easy*  

[Leetcode Link - Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)  

## Description
Given an array of integers `nums`, calculate the **pivot index** of this array. The **pivot index** is the index where the sum of all the numbers **strictly** to the left of the index is equal to the sum of all the numbers **strictly** to the index's right.

If the index is on the left edge of the array, then the left sum is `0` because there are no elements to the left. This also applies to the right edge of the array.

Return the ***leftmost pivot index***. If no such index exists, return -1.

## Example 1:
Input: `nums = [1,7,3,6,5,6]`  
Output: `3`  
Explanation: The pivot index is `3`. Left sum = `nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11`. Right sum = `nums[4] + nums[5] = 5 + 6 = 11`.

## Example 2:
Input: `nums = [1,2,3]`  
Output: `-1`  
Explanation: There is no index that satisfies the conditions in the problem statement.

## Example 3:
Input: `nums = [2,1,-1]`  
Output: `0`  
Explanation: The pivot index is `0`. Left sum = `0` (no elements to the left of index 0). Right sum = `nums[1] + nums[2] = 1 + -1 = 0`

## Constraints:
`1 <= nums.length <= 10`<sup>`4`</sup>
`-1000 <= nums[i] <= 1000`

## Solution
It is quite clear from the description of the problem that we need to use Prefix Sum technique. Our solution involves calculating right prefix sum first and then modifying and comparing it with left prefix sum as we traverse the array. We have our pivot index where both right and left sum match. Here is the solution outline.
* Right Sum: First calculate the sum of all elements of the array. Let's call it `rightSum`.
* Left Sum: Initially this is `0` as there is nothing on left side of index `i = 0`. Let's call it `leftSum`.
* Iterate thru' the `nums` array and for each nums[i]
    * Modify `rightSum` by removing `nums[i]` from it. This gives us the right prefix sum at that index `i`.
    * Check if `leftSum` matches `rightSum`. If true, `i` is our pivot.
    * If not, add `nums[i]` to `leftSum`
* Return `i` if pivot exists else `-1`.

## Time Complexity:
* **O(n):** Solution traverses the input array twice. However, overall time complexity is still proportional to the size of the array, n.

## Space Complexity:
* **O(1):** Constant space is used in terms of variables `leftSum` and `rightSum`.

## Dry Run
Input: `nums = [1,7,3,6,5,6]`  
Variables: `leftSum = 0`, `rightSum = 0`, `pivot = -1`

Calculate rightSum: 

| i | nums[i] | rightSum    |
| - | ------- | ----------- |
| 0 | 1       | 0 + 1 = 1   |
| 1 | 7       | 1 + 7 = 8   |
| 2 | 3       | 8 + 3 = 11  |
| 3 | 6       | 11 + 6 = 17 |
| 4 | 5       | 17 + 5 = 22 |
| 5 | 6       | 22 + 6 = 28 |

Variables: `rightSum = 28`, `leftSum = 0`, `pivot = -1`

| i | nums[i] | Update rightSum | leftSum == rightSum | leftSum    | pivot |
| - | ------- | --------------- | ------------------- | ---------- | ----- |
| 0 | 1       | 28 - 1 = 27     | 0 == 28, false      | 0 + 1 = 1  | -1    |
| 1 | 7       | 27 - 7 = 20     | 1 == 20, false      | 1 + 7 = 8  | -1    |
| 2 | 3       | 20 - 3 = 17     | 8 == 17, false      | 8 + 3 = 11 | -1    |
| 3 | 6       | 17 - 6 = 11     | 11 == 11, true      | -          | 3     |

Return `pivot = 3`.

## Source Code
[C++ Implementation](./pivotIndex.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*