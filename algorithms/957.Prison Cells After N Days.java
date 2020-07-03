class Solution {
    int pow2[]=new int[10];
    public int[] prisonAfterNDays(int[] cells, int n) 
    {
        boolean cycle=false; int i,c=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        pow2[0]=1;
        for(i=1;i<10;i++)
        pow2[i]=2*pow2[i-1];
        
        for(i=0;i<n;i++)
        {
            int x[]=nextDay(cells);
            int val=value(x);
            if(hm.get(val)==null) 
            {hm.put(val,1); c++;}
            else 
            {cycle=true; break;}
            cells=x;
        }
        
        if(cycle)
        {
            n%=c;
            for(i=0;i<n;i++)
            cells=nextDay(cells);
        }
        return cells;
    }
    
    int[] nextDay(int a[])
    {
        int ans[]=new int[a.length],i;
        for(i=1;i<a.length-1;i++)
        ans[i]=a[i-1]==a[i+1]?1:0;
        return ans;
    }
    
    int value(int a[])
    {
        int ans=0,i;
        for(i=0;i<a.length;i++)
        if(a[i]==1) ans+=pow2[i];
        return ans;
    }
}
