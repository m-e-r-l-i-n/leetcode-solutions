class Solution {
    public int findMinArrowShots(int[][] p) {
        Arrays.sort(p,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]<=o2[1]?1:-1;
                else return -1;
            }});
        
        int n=p.length,i,ans=0;
        if(n==0) return n;
        int l=-1,r=-1;
        for(i=0;i<n;i++)
        if(l==-1)
        {
            l=p[i][0];
            r=p[i][1];
        }
        else if(p[i][0]>r)
        {
            ans++;
            l=p[i][0];
            r=p[i][1];
        }
        else
        {
            l=Math.max(l,p[i][0]);
            r=Math.min(r,p[i][1]);
        }
        if(l!=-1) ans++;
        return ans;
    }
}
