class Solution {
    public int maxArea(int h, int w, int[] hor, int[] ver) {
        Arrays.sort(hor);
        Arrays.sort(ver);
        int i;long maxh=hor[0],maxv=ver[0];
        for(i=1;i<hor.length;i++)
        maxh=Math.max(maxh,hor[i]-hor[i-1]);
        maxh=Math.max(maxh,h-hor[hor.length-1]);
        for(i=1;i<ver.length;i++)
        maxv=Math.max(maxv,ver[i]-ver[i-1]);
        maxv=Math.max(maxv,w-ver[ver.length-1]);
        return (int)((maxh*maxv)%1000000007);
    }
}
