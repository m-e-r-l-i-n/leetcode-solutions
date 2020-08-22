class Solution {
    int s[],rt[][],n;
    Random rn=new Random();
    
    public Solution(int[][] rects) 
    {
        n=rects.length;
        rt=new int[n][4];
        s=new int[n];
        int sum=0,i;
        for(i=0;i<n;i++)
        {
            rt[i]=rects[i];
            sum+=(rt[i][2]-rt[i][0]+1)*(rt[i][3]-rt[i][1]+1);
            s[i]=sum;
        }
    }
    
    public int[] pick() 
    {
        int l=0,r=n-1;
        int k=rn.nextInt(s[n-1]);
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(s[mid]>k) r=mid;
            else l=mid+1;
        }
        
        int[] rect=rt[l];
        int width=rect[2]-rect[0]+1,height=rect[3]-rect[1]+1, base=s[l]-width*height;
        return new int[]{rect[0]+(k-base)%width,rect[1]+(k-base)/width};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
