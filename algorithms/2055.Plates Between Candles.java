//Tamonash Chakraborty
//O(n)
class Solution {
    public int[] platesBetweenCandles(String s, int[][] q) 
    {
        int i,n=s.length(),bl[]=new int[n],br[]=new int[n],dl[]=new int[n],dr[]=new int[n];
        int num=0,x=-1;
        for(i=0;i<n;i++)
        {
            x++;
            if(s.charAt(i)=='|') {num++; x=0;}
            if(num!=0)
            {
                bl[i]=num;
                dl[i]=x;
            }
            else bl[i]=dl[i]=-1;
        }    
        num=0; x=-1;
        for(i=n-1;i>=0;i--)
        {
            x++;
            if(s.charAt(i)=='|') {num=bl[i]; x=0;}
            if(num!=0)
            {
                br[i]=num;
                dr[i]=x;
            }
            else br[i]=dr[i]=-1;
        }
        
        int l=q.length,ans[]=new int[l];
        for(i=0;i<l;i++)
        {
            //q[i][0]--; q[i][1]--;
            if(br[q[i][0]]==-1 || bl[q[i][1]]==-1) continue;
            int u=q[i][0]+dr[q[i][0]],v=q[i][1]-dl[q[i][1]];
            ans[i]=v-u;
            v=bl[q[i][1]]; u=br[q[i][0]];
            ans[i]-=v-u;
            ans[i]=Math.max(ans[i],0);
        }
        return ans;
    }
}
