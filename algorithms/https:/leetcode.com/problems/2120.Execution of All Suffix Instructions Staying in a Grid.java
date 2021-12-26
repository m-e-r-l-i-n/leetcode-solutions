//created the problem from scratch
class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int l=s.length(),ans[]=new int[l],i,x[]={0,0};
        for(i=0;i<l;i++)
        {
            x[0]=startPos[0];
            x[1]=startPos[1];
            int j,c=0,ch;
            
            for(j=i;j<l;j++)
            {
                ch=s.charAt(j);
                if(ch=='L') x[1]--;
                else if(ch=='R') x[1]++;
                else if(ch=='U') x[0]--;
                else x[0]++;
                
                if(x[0]>=0 && x[0]<n && x[1]>=0 && x[1]<n) c++;
                else break;
            }
            ans[i]=c;
        }
        return ans;
    }
}
