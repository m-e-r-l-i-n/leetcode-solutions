class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i,j,n=arr.length,m=pieces.length;
        int s[]=new int[101];
        boolean vis[]=new boolean[101];
        for(i=0;i<n;i++)
        s[arr[i]]=i;    
        for(i=0;i<m;i++)
        {
            int k=s[pieces[i][0]];
            for(j=0;j<pieces[i].length;j++)
            if(j+k<n && pieces[i][j]==arr[j+k]) vis[arr[j+k]]=true;
            else break;
        }
        for(i=0;i<n;i++)
        if(!vis[arr[i]]) return false;
        return true;
    }
}
