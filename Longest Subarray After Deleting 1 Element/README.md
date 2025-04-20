# 1493. Longest Subarray of 1's After Deleting One Element - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)  

## Description
Given a binary array `nums`, you should delete one element from it. Return *the size of the longest non-empty subarray containing only 1's in the resulting array*. Return `0` if there is no such subarray.

## Example 1:
Input: `nums = [1,1,0,1]`  
Output: `3`  
Explanation: After deleting the number in position `2`, `[1,1,1]` contains `3` numbers with value of `1's`.

## Example 2:
Input: `nums = [0,1,1,1,0,1,1,0,1]`  
Output: `5`  
Explanation: After deleting the number in position `4`, `[0,1,1,1,1,1,0,1]` longest subarray with value of `1's` is `[1,1,1,1,1]`.

## Example 3:
Input: `nums = [1,1,1]`  
Output: `2`  
Explanation: You must delete one element.

## Constraints:
`1 <= nums.length <= 10`<sup>`5`</sup>
`nums[i]` is either `0` or `1`.

## Solution
*This solution is similar to that of 1004. Max Consecutive 1's with a minor change.* Here is the outline.

We use a two pointer technique to guard the bounds of the sliding window. These two pointers move to expand and shrink the window and thus a sliding window of dynamic size. Also these two pointers move in such a way to satisfy the condition of deleting an element to get max length subarray.
* Initialization
    * `left` and `right` pointers acting as the boundaries of the sliding window. Both start at `0`.
    * `count` to track the number of `0's` in the window.
    * `maxLength` to track the max length of the window
* Loop thru' the `nums` until right meets end of array.
    * Expand the window
        * `right` pointer moves to right to expand the window.
        * If `nums[right]` is `0`, then increment `count`.
    * Shrink the window
        * When `count` exceeds `1`, increment `left` until `count <= 1`.
    * Update `maxLength`
        * At the end of each iteration, update maxLength with window size calculated as `right-left`.
        * *Note - we skip +1 in right-left to mimic deleting an element.*
* Return `maxLength`.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, n.
## Space Complexity:
* **O(n):** Space complexity is proportional to the size of the array, n.

## Dry Run
Input: `nums = [0,1,1,1,0,1,1,0,1]`  
Variables: `left = 0, right = 0, count = 0, maxLength = 0`

| Iter | right | nums[right] | count | left | Window  nums[left:right] | maxLength |
| ---- | ----- | ----------- | ----- | ---- | ------------------------ | --------- |
| 1    | 0     | 0           | 1     | 0    | `[0]`                    | 0         |
| 2    | 1     | 1           | 1     | 0    | `[0,1]`                  | 1         |
| 3    | 2     | 1           | 1     | 0    | `[0,1,1]`                | 2         |
| 4    | 3     | 1           | 1     | 0    | `[0,1,1,1]`              | 3         |
| 5    | 4     | 0           | 2 > 1 | 1    | `[1,1,1,0]`              | 3         |
| 6    | 5     | 1           | 1     | 1    | `[1,1,1,0,1]`            | 4         |
| 7    | 6     | 1           | 1     | 1    | `[1,1,1,0,1,1]`          | 5         |
| 8    | 7     | 0           | 2 > 1 | 5    | `[1,1,0]`                | 5         |
| 9    | 8     | 1           | 1     | 5    | `[1,1,0,1]`              | 5         |

Return `maxLength = 5`.

## Source Code
[C++ Implementation](./longestSubarray.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*