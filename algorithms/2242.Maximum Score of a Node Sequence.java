//Tamonash Chakraborty
//O(n)
//just find the maximum 3 scores adjacent to a node
class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int i,j,n=scores.length,max[][]=new int[n][3];
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) 
        {
            g[i]=new ArrayList<>(); //g will stores nodes adjacent to a node
            Arrays.fill(max[i],-1); 
            //max will store the node with 3 largest scores (if any) adjacent to a node
        }
        
        for(int x[]:edges)
        {
            g[x[0]].add(x[1]);
            g[x[1]].add(x[0]);
        }
        
        for(i=0;i<n;i++)
        for(int x:g[i])
        for(j=0;j<3;j++)
        if(max[i][j]==-1 || scores[x]>scores[max[i][j]])    //first 3 maxima values are needed    
        {
            for(int k=2;k>j;k--)
            max[i][k]=max[i][k-1];
            max[i][j]=x;
            break;
        }
        
        int ans=-1;
        for(int x[]:edges)  //check for every edge
        for(i=0;i<3;i++)    //choose ith max connected to x[0] 
        for(j=0;j<3;j++)    //choose jth max connected to x[1]
        {
            //pqrs will be the sequence
            int p=max[x[0]][i],q=x[0],r=x[1],s=max[r][j];
            if(p==-1 || s==-1 || p==s || p==r || s==q) continue;    //not a valid sequence
            ans=Math.max(ans,scores[p]+scores[q]+scores[r]+scores[s]);  //calculate score
        }    
        return ans;
    }
}
