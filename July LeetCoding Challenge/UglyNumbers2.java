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