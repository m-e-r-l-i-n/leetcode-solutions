//Tamonash Chakraborty
//O(2^n) where n=15
class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n=aliceArrows.length,ans[]=new int[n],max=-1,i;
        for(i=0;i<(1<<n);i++)
        {
            int tot=0,j,score=0;
            for(j=0;j<n;j++)
            if(((i>>j)&1)==1) {tot+=aliceArrows[j]+1; score+=j;}
            if(tot>numArrows) continue; //not a possible answer
            
            if(score>=max)   //new high score
            {
                int fi=0;
                for(j=0;j<n;j++)
                {
                    ans[j]=0;
                    if(((i>>j)&1)==1) {ans[j]=aliceArrows[j]+1; fi=j;}
                }
                max=score;
                ans[fi]+=numArrows-tot;  //add the residue to any cell 
            }
        }
        return ans;
    }
}
