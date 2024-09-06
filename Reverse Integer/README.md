# 7. Reverse Integer
*Difficulty - Medium*  
[Leetcode Link - Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)

## Description
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then return 0.  
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
* Example 1:
    * Input: x = 123
    * Output: 321

* Example 2:
    * Input: x = -123
    * Output: -321

* Example 3:
    * Input: x = 120
    * Output: 21

## Constraints:
-2<sup>31</sup> <= x <=  2<sup>31</sup> - 1

## Solution
1. **Digit Extraction:** Extract the last digit from the number (lastDigit = x % 10). After extraction, remove the last digit from the number (x /= 10).
2. **Overflow Check:**
    * INT32_MAX / 10 is the maximum possible value the reversed number can reach before multiplying by 10 without causing an overflow.
    * Similarly, INT32_MIN / 10 is the minimum possible value the reversed number can reach before multiplying by 10.
    * As an additional check, if reversed number is exactly INT32_MAX / 10 and last digit is greater than 7, return 0. INT32_MAX = 2<sup>31</sup> - 1 = 2147483647. Hence check for lastDigit > 7.
    * Similarly, if reversed number is exactly INT32_MIN / 10 and last digit is less than -8, return 0. INT32_MIN = -2<sup>31</sup> = -2147483648. Hence check for lastDigit < -8.
    * If these conditions are not met, then the reversed number would overflow in next iteration. So return 0.
3. **Build Reversed Number:** Reverse the number by doing reversed = reversed * 10 + last digit. This adds the extracted digit to rev after shifting its current digits one place to the left (i.e., multiplying by 10).

## Time Complexity
* **O(log(x)):** where x is the input number. Number of iterations is determined by the number of digits in x.
## Space Complexity
* **O(1):** as solution uses constant space.

## Dry Run
x = 10020 
Initial value of reversed = 0 

|    x   | digit = x % 10 |  Overflow Check  |   Reversed Number   | x = x / 10  |
| ------ | -------------- | ---------------- | ------------------- | ----------- |
| 10020  | 0              | False            | 0 * 10 + 0 = 0      | 1002        |
| 1002   | 2              | False            | 0 * 10 + 2 = 2      | 100         |
| 100    | 0              | False            | 2 * 10 + 0 = 20     | 10          |
| 10     | 0              | False            | 20 * 10 + 0 = 200   | 1           |
| 1      | 1              | False            | 200 * 10 + 1 = 2001 | 0           | 

Return reversed number = 2001  

[C++ Implementation](./reverseInteger.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go implementations to be added shortly.*