# 643. Maximum Average Subarray 1 - Leetcode Problem  

*Difficulty - Easy*  

[Leetcode Link - Maximum Average Subarray 1](https://leetcode.com/problems/maximum-average-subarray-i/description/)  

## Description
You are given an integer array `nums` consisting of `n` elements, and an integer `k`. Find a contiguous subarray whose **length is equal to** `k` that has the maximum average value and return this *value*. Any answer with a calculation error less than `10`<sup>`-5`</sup> will be accepted.

## Example 1:
Input: `nums = [1,12,-5,-6,50,3], k = 4`  
Output: `12.75000`  
Explanation: Maximum average is `(12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75`

## Example 2:
Input: `nums = [5], k = 1`  
Output: `5.00000`

## Constraints:
* `n == nums.length`
* `1 <= k <= n <= 10`<sup>`5`</sup>
* `-10`<sup>`4`</sup> `<= nums[i] <= 10`<sup>`4`</sup>

## Solution
*My initial submission which is of complexity **O(kn)** passed the trivial tests but failed for large inputs as **Time Limit Exceeded**. I then moved to **O(n)** solution.*

Clearly, this is a sliding window problem. Here is the solution outline.
* Max average is possible for a sliding window with maximum sum. We first find the maximum sum and then return it's average.
* Calculate the sum of first k elements in nums. Let's call this `sumK`.
* `sumK = sum(nums[0] + nums[1] + ... + nums[k-1])`.
* Initialize `maxSumk = sumK`.
* Iterate thru' the `nums` array, to calculate `sumK` for each subsequent sliding window:
    * To get the current `sumK`, remove the first element of previous sliding window and include the last element of current sliding window from the previous `sumK`.
    * First element of previous sliding window is `nums[i]`.
    * Last element of current sliding window is `nums[i+k]`. 
    * `sumK += nums[i+k] - nums[i]`
    * Update `maxSumK` if `maxSumK > sumK`.
* Return (`maxSumK / k`) which is the maximum average.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, n.

## Space Complexity:
* **O(n):** Constant space is used in the form of variables to calculate sumK and maxSumK.

## Dry Run

Input: `nums = [1,12,-5,-6,50,3], k = 4`  
Variables: sumK = 0, maxSumK

Calculate sumK for the first sliding window.

| i | nums[i]  | sumK        |
| - | -------- | ----------- |
| 0 | 1        | 0 + 1 = 1   |
| 1 | 12       | 1 + 12 = 13 |
| 2 | -5       | 13 - 5 = 8  |
| 3 | -6       | 8 - 6 = 2   |

* Sum of first sliding window (`nums[0 to 3]`) = `sumK = 2`.
* `maxSumK = sumK = 2`.
* `new sumK += nums[i+k] - nums[i]`
* `new maxSumK = max(maxSumK, sumK)`

| Sliding Window | i | nums[i] | i+k | nums[i+k] | new sumK         | new maxSumK      |
| -------------- | - | ------- | --- | --------- | ---------------- | ---------------- |
| `nums[1 to 4]` | 0 | 1       | 4   | 50        | 2 - 1 + 50 = 51  | max(2, 51) = 51  |
| `nums[2 to 5]` | 1 | 12      | 5   | 3         | 51 - 12 + 3 = 42 | max(51, 42) = 51 |

`maxSumK = 51`  
Return `51/4 = 12.75`

## Source Code
[C++ Implementation](./findMaxAverage.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*