# 8. String to Integer (atoi)
*Difficulty - Medium*  
[Leetcode Link - String to Integer (myatoi)](https://leetcode.com/problems/string-to-integer-atoi/description/)

## Description
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.  
The algorithm for myAtoi(string s) is as follows:  
1. **Whitespace:** Ignore any leading whitespace (" ").
2. **Signedness:** Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
3. **Conversion:** Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
4. **Rounding:** If the integer is out of the 32-bit signed integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then round the integer to remain in the range. Specifically, integers less than -2<sup>31</sup> should be rounded to -2<sup>31</sup>, and integers greater than 2<sup>31</sup> - 1 should be rounded to 2<sup>31</sup> - 1.

Return the integer as the final result.

### Example 1:
Input: s = "42"  
Output: 42  
Explanation:  
The underlined characters are what is read in and the caret is the current reader position.  
Step 1: "42" (no characters read because there is no leading whitespace)  
Step 2: "42" (no characters read because there is neither a '-' nor '+')  
Step 3: "42" ("42" is read in)  

### Example 2:
Input: s = "____-042"  
Output: -42  
Explanation:  
Step 1: "____-042" (leading whitespace is read and ignored)  
Step 2: "   -042" ('-' is read, so the result should be negative)  
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)  

### Example 3:
Input: s = "1337c0d3"  
Output: 1337  
Explanation:  
Step 1: "1337c0d3" (no characters read because there is no leading whitespace)  
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')  
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)  

### Example 4:
Input: s = "0-1"  
Output: 0  
Explanation:  
Step 1: "0-1" (no characters read because there is no leading whitespace)  
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')  
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)  

### Example 5:
Input: s = "words and 987"  
Output: 0  
Explanation:  
Step 1: Reading stops at the first non-digit character 'w'.  

## Constraints:
* 0 <= s.length <= 200
* s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

## Solution
Key points in the implementation:
1. **Whitespace Handling:** Skip leading spaces in the input string.
2. **Sign Handling:** Check for '-' or '+' sign to determine sign of the result. Result is +ve when no sign is found.
3. **Zeros Handling:** Skip leading zeros in the input string.
4. **Digit Conversion:** Iterate over the string only if there is a digit in the input string and build the integer. After reading each digit, check for overflow or underflow.
4. **Over/Underflow Handling:**
    * If the integer is greater than INT32_MAX / 10, return the INT32_MAX if sign is +ve else return the INT32_MIN.
    * If the integer is exactly INT32_MAX/10 and the current digit is > 7:
        * If sign is +ve, return INT32_MAX
        * If sign is -ve, return INT_32_MIN
5. **Non-Numeric Characters:** Processing stops when a non-numeric character is encountered.

## Time Complexity
* **O(n):** where n is the length of the input string. Solution processes each character in the string in the worst case scenario.

## Space Complexity
* **O(1):** as solution uses only constant space to process in the form of variables. 

## Dry Run
We will dry run an edge case.  
Input s = "2147483648". Note this is one more than INT32_MAX  
Output = 2147483647  
Initial values: i = 0, sign = 1 (+ve), result = 0  

|   i   |   sign   |   digit   |   Over/Underflow Check   |            result             |
| ----- | -------- | --------- | ------------------------ | ----------------------------- |
|  0    |  1       |  2        | False                    | 0 * 10 + 2 = 2                |
|  1    |  1       |  1        | False                    | 2 * 10 + 1 = 21               |
|  2    |  1       |  4        | False                    | 21 * 10 + 4 = 214             |
|  3    |  1       |  7        | False                    | 214 * 10 + 7 = 2147           |
|  4    |  1       |  4        | False                    | 2147 * 10 + 4 = 21474         |
|  5    |  1       |  8        | False                    | 21474 * 10 + 8 = 214748       |
|  6    |  1       |  3        | False                    | 214748 * 10 + 3 = 2147483     |
|  7    |  1       |  6        | False                    | 2147483 * 10 + 6 = 21474836   |
|  8    |  1       |  4        | False                    | 21474836 * 10 + 4 = 214748364 |
|  9    |  1       |  8        | True                     | INT32_MAX = 2147483647        |

In last iteration, value of result = 214748364, which is equal to INT32_MAX/10. Current digit, 8 is > 7 and sign is +ve.  
So return as INT32_MAX which is 2147483647.  

[C++ Implementation](./stringtoInt.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go implementations to be added shortly.*