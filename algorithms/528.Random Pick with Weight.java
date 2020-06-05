class Solution {

    int a[],max=0;
    Random r=new Random();
    public Solution(int[] w) 
    {
        int arr[]=new int[w.length],i;
        arr[0]=w[0];
        max+=w[0];
        for(i=1;i<w.length;i++)
        {
            arr[i]=arr[i-1]+w[i];
            max+=w[i];
        }
        a=arr;
    }
    
    public int pickIndex() 
    {
        int rnd=r.nextInt(max) + 1;
        int ret=Arrays.binarySearch(a,rnd); 
        if(ret<0) ret=-ret-1;
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
