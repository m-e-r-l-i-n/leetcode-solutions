class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        int i,j;
        for(i=0;i<10;i++)
        if(n==1 || (i-k)>=0 || (i+k)<10) ans.add(i);
        for(i=1;i<n;i++)
        {
            ArrayList<Integer> t=new ArrayList<>();
            for(j=0;j<ans.size();j++)
            {
                int cur=ans.get(j),d=cur%10;
                if(d+k<10) t.add(cur*10+(d+k));
                if(d-k>=0) t.add(cur*10+(d-k));
            }
            ans=t;
        }
        Set<Integer> s=new HashSet<>();
        for(i=0;i<ans.size();i++)
        {
            int cur=ans.get(i);
            if((int)Math.floor(Math.log10(cur)+1)!=n) continue;
            s.add(cur);
        }
        if(n==1) s.add(0);
        int ar[]=new int[s.size()];
        i=0;
        for(int x:s)
        ar[i++]=x;
        return ar;
    }
    
    
}
