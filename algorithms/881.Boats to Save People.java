class Solution {
    public int numRescueBoats(int[] p, int l) {
        Arrays.sort(p);
        int ans=0;  //atleast 1 boat is required
        int i=0,j=p.length-1;
        while(i<j)
        {
            if(p[j]+p[i]<=l)
            {
                i++; j--;
                ans++;
            }
            else 
            {
                j--; 
                ans++;
            }
        }
        if(i==j) ans++;
        return ans;
    }
}
