import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        int current = 1;
        List<Integer> lexicalNumbers = new ArrayList<>();
        // Generate lexical numbers from 1 to n
        for(int i = 0; i < n; i++){
            // Add the current number to the lexical list of numbers
            lexicalNumbers.add(current);
            // Move to the next lexically valid number by 
            // multiplying current by 10
            if(current * 10 <= n){
                current *= 10;
            } else {
                // current has moved out of the range of n
                // Adjust the value of current to move to the next
                // lexically valid number
                while(current >= n || current % 10 == 9){
                    current /= 10;
                }
                // Increment current
                current++;
            }
        }
        return lexicalNumbers;
    }
    
    public static void printList(List<Integer> A) {
        System.out.print("[ ");
        if(!A.isEmpty()) {
            for(int x : A){
                System.out.print(x + " ");
            }
        }
        System.out.println(" ]");
    }

    public static void main(String[] args){
        int n = 13;
        Solution sol = new Solution();
        List<Integer> output = sol.lexicalOrder(n);
        printList(output);
    }
}