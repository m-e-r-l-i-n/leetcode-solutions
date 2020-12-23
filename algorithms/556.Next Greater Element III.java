class Solution {
    public int nextGreaterElement(int n) {
        if(n<12) return -1;
        char s[]=Integer.toString(n).toCharArray();
        int i,l=s.length;
        for(i=l-2;i>=0;i--)
        if(s[i]<s[i+1]) break;
        if(i<0) return i;
        
        //smallest digit larger than the found index
        int minp=i,min='9',f=i;
        for(;i<l;i++)
        if(s[i]>s[f] && s[i]<=min)
        {
            min=s[i];
            minp=i;
        }
        char t=s[f];
        s[f]=s[minp];
        s[minp]=t;
        Arrays.sort(s,f+1,l);
        long ans=Long.parseLong(new String(s));
        if(ans>Integer.MAX_VALUE) ans=-1;
        return (int)ans;
    }
}
