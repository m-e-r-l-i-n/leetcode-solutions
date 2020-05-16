class Solution {
    public String largestNumber(int[] cost, int target) {
        String dp[]=new String[target+1];
        return coinchange(cost,target,dp);
    }
    
    String coinchange(int c[],int n,String dp[])
    {
        if(n==0) return "";
        if(dp[n]!=null) return dp[n];
        String max="0";
        for(int i=0;i<9;i++)
        if(n>=c[i])
        {
            String curr=coinchange(c,n-c[i],dp);
            if(curr.equals("0")) continue;
            curr=Integer.toString(i+1)+curr;
            if(max.length()>curr.length()) continue;
            if(curr.length()>max.length()|| (curr.length()==max.length() && curr.compareTo(max)>0)) max=curr;
        }
        return dp[n]=max;
    }
}
