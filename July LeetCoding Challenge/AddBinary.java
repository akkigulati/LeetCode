/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*/
class Solution {
    
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        char[] ch = new char[Math.max(i,j)+1]; // create char array to store addition value
        int k=ch.length-1;
        int carry = 0; // carry
        while(k>=0){
		   // iterate each character from the string from last
		   // if any of the string iteration going below 0 index, consider 0 value.
            int c = j<0?0:b.charAt(j)-'0';
            int d = i<0?0:a.charAt(i)-'0';
			
			//There can be 4 possibilities of below addition : 0, 1, 2, 3
			// And, values could be stored as                  0, 1, 0, 1 respectively, So, these are remainder when dividing possible value with 2.
			// And carry would be                              0, 0, 1, 1 respectively, these are quotient when dividing possible values with 2.
            ch[k]=(char)('0'+((c+d+carry)%2));
            carry=(c+d+carry)/2;
            i--;
            j--;
            k--;
        }
        //create string with popuated character array
        String str = new String(ch);
		//append at the beging if we have carry 1.
        return carry==1?'1'+str:str;
    }
    
}
