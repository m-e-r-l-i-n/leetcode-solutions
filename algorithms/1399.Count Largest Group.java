class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i,max=0;
        for(i=1;i<=n;i++)
        {
            int sum=0,no=i;
            while(no>0)
            {
                sum+=no%10;
                no/=10;
            }
            if(hm.get(sum)==null) hm.put(sum,1);
            else hm.put(sum,hm.get(sum)+1);
            if(hm.get(sum)>max) max=hm.get(sum);
        }
        int c=0;
        for(int x:hm.keySet())
        {
            if(hm.get(x)==max) c++;
        }
        return c;
    }
}
