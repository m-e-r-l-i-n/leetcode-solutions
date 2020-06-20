class Solution {
    public String getPermutation(int n, int k) {
        int f[]=new int[n+1],i;
        f[0]=1;
        ArrayList<Integer> num=new ArrayList<>();
        for(i=1;i<=n;i++)
        {
            f[i]=i*f[i-1];
            num.add(i);
        }
        StringBuilder sb=new StringBuilder();
        k--;
        for(i=1;i<=n;i++)
        {
            int x=k/f[n-i]; 
            sb.append(num.get(x));
            num.remove(x);
            k-=x*f[n-i];
        }
        return sb.toString();
    }
}
