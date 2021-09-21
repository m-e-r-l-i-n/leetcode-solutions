class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String x:operations)
        if(x.charAt(0)=='-' || x.charAt(2)=='-') ans--;
        else ans++;
        return ans;
    }
}
