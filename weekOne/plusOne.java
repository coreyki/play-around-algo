class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            //for the 9's in the back, update them to 0 and carry over the 1;
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // got first none 9, increment it and return the result
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        //all the digits are 9, the new number is 10000... with digits.length of 0s
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
