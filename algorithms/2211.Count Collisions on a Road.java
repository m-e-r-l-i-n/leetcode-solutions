//Tamonash Chakraborty
//O(n)
class Solution {
    public int countCollisions(String directions) {
        int prev=' ',n=directions.length(),i,ans=0;
        //check collisions from left to right
        for(i=0;i<n;i++)
        {
            int j=i;
            while(j<n && directions.charAt(j)==directions.charAt(i)) j++;
            if(directions.charAt(i)=='L' && prev!=' ') ans+=j-i; //leftmost L will not be considered, all others will be
            prev=directions.charAt(i);   //store previous non similar character
            i=j-1;
        }
        
        prev=' ';
        for(i=n-1;i>=0;i--) //do same for R values now in reverse order
        {
            int j=i;
            while(j>=0 && directions.charAt(j)==directions.charAt(i)) j--;
            if(directions.charAt(i)=='R' && prev!=' ') ans+=i-j;
            prev=directions.charAt(i);
            i=j+1;
        }
        return ans;
    }
}
