/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length-1;
        int carry=0;
        int i=0;
        for(i=n;i>=0;i--){
            digits[i]=digits[i]+1;
            if(digits[i]<10){
                break;
            }else{
                carry=digits[i]/10;
                digits[i]%=10;
            }
        }
        if(i==-1&&carry==1){
            int arr[]=new int[n+2];
            arr[0]=1;
            // for(int j=1;j<arr.length;j++)
            //     arr[j]=digits[j-1];
            
            return arr;
        }
        return digits;
    }
}
