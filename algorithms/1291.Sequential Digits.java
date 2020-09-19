class Solution {
    public List<Integer> sequentialDigits(int low, int high) 
    {
        ArrayList<Integer> el=new ArrayList<>();
        int i;
        for(i=1;i<10;i++)
        el.add(i);
        
        List<Integer> ans=new ArrayList<>();
        while(el.size()!=0)
        {
            ArrayList<Integer> t=new ArrayList<>();
            for(i=0;i<el.size();i++)
            {
                int c=el.get(i),num=c*10+c%10+1;
                if(c%10==9) continue;
                if(num<=high)
                {
                    t.add(num);
                    if(num>=low) ans.add(num);
                }
            }
            el=t;
        }
        return ans;
    }
}
