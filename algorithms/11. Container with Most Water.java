class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,max=0;
        while(l<r)
        {
            int area=(r-l)*(int)Math.min(height[r],height[l]);
            max=area>max?area:max;
            if(height[l]>height[r]) r--;
            else l++;
        }
        return max;
    }
}
