# 6. Zigzag Conversion
*Difficulty - Medium*  
[Leetcode Link - Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/description/)
## Description
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:  
P   A   H   N  
A P L S I I G  
Y   I   R  
And then read line by line: "PAHNAPLSIIGYIR"  
Write the code that will take a string and make this conversion given a number of rows.  
Example 1:  
Input: s = "PAYPALISHIRING", numRows = 3  
Output: "PAHNAPLSIIGYIR"  
Explanation:  
P     A     H     N  
A  P  L  S  I  I  G  
Y     I     R  

Example 2:  
Input: s = "PAYPALISHIRING", numRows = 4  
Output: "PINALSIGYAHRPI"  
Explanation:  
P       I       N  
A    L  S    I  G  
Y  A    H  R  
P       I

## Constraints
* 1 <= s.length <= 1000
* s consists of English letters (lower-case and upper-case), ',' and '.'.
* 1 <= numRows <= 1000

## Solution
* Edge Case: There are two edge cases here. If the number of rows is 1 or greater than equal to string length then output is same as input. There is no zigzag pattern.
* Initialize an array of strings where each string represents a row in output.
* Traverse the input string s by each character and append the character to string in each row simulating a zigzag pattern. Simulation is done by going up or down the grid - when at top row we go down and when at bottom we go up.
* Concatenate all strings from each row and return the result.

## Time Complexity:
* **O(N):** where N is the length of the string s. Solution visits each character once.
## Space Complexity:
* **O(N):** where N is size of the output string (same length as that of string s).

## Dry Run
Input s = "PAYPALISHIRING"  
Rows = 4  
Initial Values: Current Row = 0, Going Down = False, Output = ["", "", "", ""]  
*Going Down flag is flipped at Row = 0 or Row = 3*  

| Current Character | Current Row | Output[ 0 ] | Output[ 1 ] | Output[ 2 ] | Output[ 3 ] | Going Down | New Current Row |
| ----------------- | ----------- | ----------- | ----------- | ----------- | ----------- | ---------- | --------------- |
| 'P'               | 0           | "P"         | ""          | ""          | ""          | True       | 0 + 1 = 1       |
| 'A'               | 1           | "P"         | "A"         | ""          | ""          | True       | 1 + 1 = 2       |
| 'Y'               | 2           | "P"         | "A"         | "Y"         | ""          | True       | 2 + 1 = 3       |
| 'P'               | 3           | "P"         | "A"         | "Y"         | "P"         | False      | 3 - 1 = 2       |
| 'A'               | 2           | "P"         | "A"         | "YA"        | "P"         | False      | 2 - 1 = 1       |
| 'L'               | 1           | "P"         | "AL"        | "YA"        | "P"         | False      | 1 - 1 = 0       |
| 'I"               | 0           | "PI"        | "AL"        | "YA"        | "P"         | True       | 0 + 1 = 1       |
| 'S'               | 1           | "PI"        | "ALS"       | "YA"        | "P"         | True       | 1 + 1 = 2       |
| 'H'               | 2           | "PI"        | "ALS"       | "YAH"       | "P"         | True       | 2 + 1 = 3       |
| 'I'               | 3           | "PI"        | "ALS"       | "YAH"       | "PI"        | False      | 3 - 1 = 2       |
| 'R'               | 2           | "PI"        | "ALS"       | "YAHR"      | "PI"        | False      | 2 - 1 = 1       |
| 'I'               | 1           | "PI"        | "ALSI"      | "YAHR"      | "PI"        | False      | 1 - 1 = 0       |
| 'N'               | 0           | "PIN"       | "ALSI"      | "YAHR"      | "PI"        | True       | 0 + 1 = 1       |
| 'G'               | 1           | "PIN"       | "ALSIG"     | "YAHR"      | "PI"        | True       | 1 + 1 = 2       |

Output = **"PIN"** + **"ALSIG"** + **"YAHR"** + **"PI"** = **"PINALSIGYAHRPI"**  

[C++ Implementation](./zigZagConversion.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go implementations will be added shortly.*