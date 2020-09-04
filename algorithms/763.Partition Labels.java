class Solution {
    public List<Integer> partitionLabels(String s) {
        int i,n=s.length(),c[]=new int[26];
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<n;i++)
        c[s.charAt(i)-'a']=i;
        
        int st=0,l=0;
        for(i=0;i<n;i++)
        {
            l=Math.max(l,c[s.charAt(i)-'a']);
            if(l==i)
            {
                ans.add(l-st+1);
                st=l+1;
            }
        }
        return ans;
    }
}
