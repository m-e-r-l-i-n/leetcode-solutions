//Tamonash Chakraborty
//O(n)
class Solution {
    public long numberOfWays(String s) {
        int i,n=s.length(),z=0,o=0,prev[]=new int[n];
        for(i=0;i<n;i++)
        if(s.charAt(i)=='0')  
        {
            z++;
            prev[i]=o;  //number of ones before it
        }
        else
        {
            o++;
            prev[i]=z;  //number of zeros before it
        }
        
        z=0; o=0;
        long ans=0;
        for(i=n-1;i>=0;i--)
        if(s.charAt(i)=='0')
        {
            z++;
            ans+=1l*prev[i]*o; //fix this index, choose 1 of opposite type from before and after
        }
        else
        {
            o++;
            ans+=1l*prev[i]*z; //do the same as above with opposite value
        }
        return ans;
    }
}
