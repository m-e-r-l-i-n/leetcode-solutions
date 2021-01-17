class Solution {
    public int tupleSameProduct(int[] a) {
        int i,j,ans=0,n=a.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        for(j=i+1;j<n;j++)
        hm.put(a[i]*a[j],hm.getOrDefault(a[i]*a[j],0)+1);
        
        for(int x:hm.values())
        ans+=x*(x-1)/2*8;
        return ans;
    }
}
