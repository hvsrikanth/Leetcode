class Solution {
    public int findComplement(int num) {
        // Create a mask with all bits set to 1
        // Primarirly bitwise NOT of 0
        int mask = ~0;
        // Now left shift the mask until all the bits of input num are covered
        while((num & mask) != 0){
            mask = mask << 1;
        }
        // Now negate the mask and return the XOR with num
        // Negating the mask ensures the mask matches the number of bits in input number
        return ~mask ^ num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = 5;
        System.out.println("Complement of " + num + " is: " + sol.findComplement(num));
    }
}