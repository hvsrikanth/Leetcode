# 1004. Max Consecutive Ones 3 - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Max Consecutive Ones 3](https://leetcode.com/problems/max-consecutive-ones-iii/description/)  

## Description
Given a binary array `nums` and an integer `k`, return *the maximum number of consecutive `1`'s in the array if you can flip at most* `k 0's`.

## Example 1:
Input: `nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2`  
Output: `6`  
Explanation: [`1,1,1,0,0,`**1**,`1,1,1,1`,**1**]  
Bolded numbers were flipped from `0` to `1`. The longest subarray including bolded **1**'s is `6`.

## Example 2:
Input: `nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3`  
Output: `10`  
Explanation: [`0,0,1,1`,**1,1**,`1,1,1`,**1**,`1,1,0,0,0,1,1,1,1`]  
Bolded numbers were flipped from `0` to `1`. The longest subarray including bolded **1**'s is `10`.

## Constraints:
`1 <= nums.length <= 10`<sup>`5`</sup>  
`nums[i]` is either `0` or `1`.  
`0 <= k <= nums.length`

## Solution
*My initial solutions ran on my local were clumsy. I looked up on the hints listed on the site to come up with this solution. Look up hints 2 and 3 in the problem description.* Here is the outline.

We use a two pointer technique to guard the bounds of the sliding window. These two pointers move to expand and shrink the window and thus a sliding window of dynamic size. Also these two pointers move in such a way to satisfy the condition of atmost `k` `0's` to be flipped to `1's`.
* Initialization
    * `left` and `right` pointers acting as the boundaries of the sliding window. Both start at `0`.
    * `count` to track the number of `0's` in the window.
    * `maxLength` to track the max length of the window
* Loop thru' the `nums` until right meets end of array.
    * Expand the window
        * `right` pointer moves to right to expand the window.
        * If `nums[right]` is `0`, then increment `count`.
    * Shrink the window
        * When `count` exceeds `k` (meaning we got too many `0's`), increment `left` until `count <= k`.
    * Update `maxLength`
        * At the end of each iteration, update maxLength with window size calculated as `right-left+1`. 
* Return `maxLength`.

## Time Complexity:
* **O(n):** Solution has single iteration of the input array and is proportional to the size of the array, `n`.

## Space Complexity:
* **O(1):** Constant space is used in terms of two pointers `left` and `right` and variables such as `count` and `maxLength`.

## Dry Run
Input: `nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2`  
Variables: `left = 0, right = 0, count = 0, maxLength = 0`

| Iter | right | nums[right] | count | left | Window  nums[left:right] | maxLength |
| ---- | ----- | ----------- | ----- | ---- | ------------------------ | --------- |
| 1    | 0     | 1           | 0     | 0    | `[1]`                    | 1         |
| 2    | 1     | 1           | 0     | 0    | `[1,1]`                  | 2         |
| 3    | 2     | 1           | 0     | 0    | `[1,1,1]`                | 3         |
| 4    | 3     | 0           | 1     | 0    | `[1,1,1,0]`              | 4         |
| 5    | 4     | 0           | 2     | 0    | `[1,1,1,0,0]`            | 5         |
| 6    | 5     | 0           | 3 > k | 4    | `[0,0]`                  | 5         |
| 7    | 6     | 1           | 2     | 4    | `[0,0,1]`                | 5         |
| 8    | 7     | 1           | 2     | 4    | `[0,0,1,1]`              | 5         |
| 9    | 8     | 1           | 2     | 4    | `[0,0,1,1,1]`            | 5         |
| 10   | 9     | 1           | 2     | 4    | `[0,0,1,1,1,1]`          | 6         |
| 11   | 10    | 0           | 3 > k | 5    | '[0,1,1,1,1,0]`          | 6         |

Return `maxLength = 6`.

## Source Code
[C++ Implementation](./longestOnes.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*