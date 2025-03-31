# 386. Lexicographical Numbers - Leetcode Problem
*Difficulty - Medium*  
[Leetcode Link - Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/description/)
## Description
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in **O(n)** time and uses **O(1)** extra space. 

### Example 1:
Input: n = 13  
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

### Example 2:
Input: n = 2  
Output: [1,2]

## Constraints:
1 <= n <= 5 * 10<sup>4</sup>

## Solution
The problem requires generating lexically sorted list of numbers until n and to be solved in O(n) time and O(1) space. Lexical order is similar to that of alphabetical order. So the solution needs to generate numbers as if they were strings. As the required time complexity is O(n), any brute force methods with nested loops is ruled out. Here is the solution outline.
* Initialize an empty array lexicalNumbers to store the output
* Initialize a variable current and set it to 1
* Run a loop from i = 0 to n-1
    * Add current to lexicalNumbers
    * To move to the next lexically valid number, check if current * 10 is less than or equal to n. If true, mulitply current by 10 and move to the next lexically valid number. Example: Moving from 1 to 10.
    * If not, adjust the current to move to the next lexically valid number. Example: Moving from 19 to 2. While current is greater than or equal to n or ends with 9, repeatedly divide it by 10.
    * Increment the current by 1 to move to the next lexically valid number. Example: Moving from 11 to 12.
## Time Complexity:
* **O(n):** Time complexity is proportional to the input number, n. Algorithm generates lexically sorted numbers until n.
## Space Complexity:
* **O(1):** Constant additional space is used by variables such as current. Output is expected to be the list of lexicographical numbers and hence is not considered for space complexity.

## Dry Run

Input: n = 13  
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]  
current = 1 (initial value)

| Iteration | current | Output List        | current * 10 <= n    | current *= 10 | current >= n or current%10 == 9  | current /= 10 | current++    |
| --------- | ------- | ------------------ | -----------------    | -----------   | -------------------------------- | ------------- | ---------    |
| i = 0     |  1      | [1]                | 1 * 10 < 13 (True)   | 1 * 10 = 10   |                                  |               |              |
| i = 1     |  10     | [1,10]             | 10 * 10 < 13 (False) |               | 10 >= 13 or 10 % 10 == 9 (False) |               | current = 11 |
| i = 2     |  11     | [1,10,11]          | 11 * 10 < 13 (False) |               | 11 >= 13 or 11 % 10 == 9 (False) |               | current = 12 |
| i = 3     |  12     | [1,10,11,12]       | 12 * 10 < 13 (False) |               | 12 >= 13 or 12 % 10 == 9 (False) |               | current = 13 |
| i = 4     |  13     | [1,10,11,12,13]    | 13 * 10 < 13 (False) |               | 13 >= 13 or 13 % 10 == 9 (True)  | 13 / 10 = 1   | current = 2  |
| i = 5     |  2      | [1,10,11,12,13,2]  | 2 * 10 < 13 (False)  |               | 2 >= 13 or 2 % 10 == 9 (False)   |               | current = 3  |
| i = 6     |  3      | [1,10,11,12,13,2,3]| 3 * 10 < 13 (False)  |               | 3 >= 13 or 3 % 10 == 9 (False)   |               | current = 4  |
| i = 7     |  4      | ...                | ...         (False)  |               | ... (False)                      |               | current = 5  |
| i = 8     |  5      | ...                | ...         (False)  |               | ... (False)                      |               | current = 6  |
| i = 9     |  6      | ...                | ...         (False)  |               | ... (False)                      |               | current = 7  |
| i = 10    |  7      | ...                | ...         (False)  |               | ... (False)                      |               | current = 8  |
| i = 11    |  8      | ...                | ...         (False)  |               | ... (False)                      |               | current = 9  |
| i = 12    |  9      | [1,10,11,12,13,2,3,4,5,6,7,8,9]| (False)  |               | ... (False)                      |               | current = 10 |

## Source Code
[C++ Implementation](./lexicographicalNumbers.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*