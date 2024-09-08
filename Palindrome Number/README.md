# 9. Palindrome Number
*Difficulty - Easy*  
[Leetcode Link](https://leetcode.com/problems/palindrome-number/description/)

## Description
Given an integer x, return true if x is a palindrome, and false otherwise.  

Example 1:  
Input: x = 121  
Output: true  
Explanation: 121 reads as 121 from left to right and from right to left.  

Example 2:  
Input: x = -121  
Output: false  
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.  

Example 3:  
Input: x = 10  
Output: false  
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.  

## Constraints:
* -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1

**Follow Up:** Could you solve it without converting the integer to a string?

## Solution
The idea is to reverse the digits of the input number and compare the reversed number with the input. If they are equal then the input number is a palindrome. Here are the key steps:
1. **Check for Negative Number:** If the input is negative then it is not palindrome. E.g.: -121 is not same as 121-.
2. **Reverse the integer:** Perform repeated division by 10 until the input number becomes 0.
    * Get the digit in the one's place by doing mod 10.
    * Shift the digits of the reversed number by multiplying with 10.
    * Add the current digit to reversed number.
3. **Overflow Check:** There is a possibility of integer overflow of the reversed integer. If reversed becomes too large (larger than INT32_MAX / 10), then stop the reversal process. This is important to avoid exceeding the 32-bit integer limit when reversing large numbers.
4. **Palindrome Check:** Compare the reversed number with the input. If they are equal, the input number is a palindrome otherwise, it is not.

## Time Complexity
* **O(log<sub>10</sub>n):** where n is the input number. We are extracting each digit by repeated division by 10 and hence the complexity.
## Space Complexity
* **O(1):** as a constant amount of space is used in the process.

## Dry Run
Input x = 21412  
Input x is copied to temp for repeated division  
temp = x = 21412  
Initial value of reversed = 0  

| Iteration |  temp   |  Current Digit |     Reversed Number    |  Overflow Check  |
| --------- | ------- | -------------- | ---------------------- | ---------------- |
|  1        | 21412   | 2              | 0 * 10 + 2 = 2         | False            |
|  2        | 2141    | 1              | 2 * 10 + 1 = 21        | False            |
|  3        | 214     | 4              | 21 * 10 + 4 = 214      | False            |
|  4        | 21      | 1              | 214 * 10 + 1 = 2141    | False            |
|  5        | 2       | 2              | 2141 * 10 + 2 = 21412  | False            |

x = Reversed Number = 21412 is a palindrome.

[C++ Implementation](./palindromeNumber.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go implementations to be added shortly.*