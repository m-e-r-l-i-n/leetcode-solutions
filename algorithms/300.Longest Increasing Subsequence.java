class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=20000,ans=0; st=new int[100000];
        for(int x:nums)
        {
            int i=x+10000,max=query(0,n,0,i-1,0);
            max++;
            //System.out.println(i+" "+max);
            ans=Math.max(ans,max);
            update(0,n,i,max,0);
        }
        return ans;
    }
    
    static int st[];
    static void update(int ss,int se,int i,int v,int n)
    {
        if(ss>se) return;
        if(ss==se)
        {
            st[n]=Math.max(st[n],v);
            return;
        }
        int m=ss+(se-ss)/2;
        if(i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=Math.max(st[2*n+1],st[2*n+2]);
    }

    static int query(int ss,int se,int qs,int qe,int n)
    {
        if(se<qs || ss>qe) return 0;
        if(qs<=ss && qe>=se) return st[n];
        int m=ss+(se-ss)/2;
        return Math.max(query(ss,m,qs,qe,2*n+1),query(m+1,se,qs,qe,2*n+2));
    }
}
