/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/
class Solution {
    public int nthUglyNumber(int n) {
             if(n==0)
                 return 0;
        int i=0;
        int j=0;
        int k=0;
        List<Integer> li=new ArrayList<>();
        li.add(1);
        while(li.size()<n){
            int temp1=li.get(i)*2;
            int temp2=li.get(j)*3;
            int temp3=li.get(k)*5;
            
            int min=Math.min(temp1,Math.min(temp2,temp3));
            li.add(min);
            if(min==temp1){
                i++;
            }if(min==temp2){
                j++;
            }if(min==temp3){
                k++;
            }
            
        }
        return li.get(li.size()-1);
    }
}
