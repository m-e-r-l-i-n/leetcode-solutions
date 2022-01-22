//Tamonash Chakraborty
//O(n)
class Solution {
    public int numberOfWays(String s) {
        ArrayList<int[]> pairs=new ArrayList<>();
        int i,n=s.length();
        for(i=0;i<n;i++)
        if(s.charAt(i)=='S')    //seat
        {
            //find the next pair of this seat
            int j=i+1;
            while(j<n && s.charAt(j)=='P') j++;
            if(j==n) return 0;  //odd number of seats
            pairs.add(new int[]{i,j});
            i=j;
        }
        if(pairs.size()==0) return 0;   //no seats to form pairs
        
        long ans=1,M=(int)1e9+7;
        for(i=1;i<pairs.size();i++)
        ans=ans*(pairs.get(i)[0]-pairs.get(i-1)[1])%M;  //number of places where we can place the ith divider
        return (int)ans;
    }
}
