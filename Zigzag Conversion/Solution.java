import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        int sLen = s.length();
        String answer = "";
        // Handle the edge case of only 1 row or rows >= string length
        if(numRows == 1 || numRows >= sLen) {
            answer = s;
        } else {
            List<StringBuilder> rows = new ArrayList<>();
            // Initialize the List with the number of rows
            for (int i = 0; i < Math.min(numRows, sLen); i++) {
                rows.add(new StringBuilder());
            }
            int curRow = 0;
            boolean goingDown = false;
            // Traverse through each character in the string
            for (char c : s.toCharArray()) {
                // Append the character to current row
                rows.get(curRow).append(c);
                // At first or last row, reverse direction
                if (curRow == 0 || curRow == numRows - 1) {
                    goingDown = !goingDown;
                }
                curRow += goingDown ? 1 : -1;
            }
            // Combine all rows to form the result
            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }
            answer = result.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println("Zigzag Conversion: " + sol.convert(s, numRows));
    }
}
