class Solution {
    public int[][] insert(int[][] in, int[] ni) {
        ArrayList<Interval> al=new ArrayList<>();
        int i=0,n=in.length;
        while(i<n && in[i][1]<ni[0])
            al.add(new Interval(in[i][0],in[i++][1]));
        Interval c=new Interval(ni[0],ni[1]);
        
        while(i<n)
        {
            if(in[i][0]<=c.r)
            {
                c.l=Math.min(c.l,in[i][0]);
                c.r=Math.max(c.r,in[i][1]);
            }
            else
            {
                al.add(c);
                c=new Interval(in[i][0],in[i][1]);
            }
            i++;
        }
        al.add(c);
        
        int ans[][]=new int[al.size()][2];
        for(i=0;i<al.size();i++)
        {
            ans[i][0]=al.get(i).l;
            ans[i][1]=al.get(i).r;
        }    
        return ans;    
    }
    
    class Interval
    {
        int l,r;
        Interval(int a,int b)
        {
            l=a;
            r=b;
        }
    }
}
