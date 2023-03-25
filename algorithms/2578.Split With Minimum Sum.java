class Solution {
    public int splitNum(int num) {
        ArrayList<Integer> d=new ArrayList<>();
        while(num>0)
        {
            d.add(num%10);
            num/=10;
        }
        
        Collections.sort(d);
        int num1=0,num2=0;
        for(int i=0;i<d.size();i++)
        if(i%2==0) num1=10*num1+d.get(i);
        else num2=10*num2+d.get(i);
        return num1+num2;
    }
}
