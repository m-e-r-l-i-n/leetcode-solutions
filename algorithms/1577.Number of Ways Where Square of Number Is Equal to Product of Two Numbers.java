class Solution {
    public int numTriplets(int[] n1, int[] n2) {
        int i,j,N=100000,c1[]=new int[N+1],c2[]=new int[N+1];
        ArrayList<Integer> al=new ArrayList<>();
        for(i=0;i<n1.length;i++)
        {
            c1[n1[i]]++;
            for(j=i+1;j<n1.length;j++)
            if(perfectsq(n1[i],n1[j])) al.add(root(n1[i],n1[j]));
        }
        
        ArrayList<Integer> ar=new ArrayList<>();
        for(i=0;i<n2.length;i++)
        {
            c2[n2[i]]++;
            for(j=i+1;j<n2.length;j++)
            if(perfectsq(n2[i],n2[j])) ar.add(root(n2[i],n2[j]));    
        }
        
        int ans=0;
        for(i=0;i<al.size();i++)
        ans+=c2[al.get(i)];
        for(i=0;i<ar.size();i++)
        ans+=c1[ar.get(i)];
        return ans;
    }
    
    boolean perfectsq(int a,int b)
    {
        double v=1l*a*b;
        v=Math.sqrt(v); 
        return Math.floor(v)==Math.ceil(v);
    }
    
    int root(int a,int b)
    {
        long v=1l*a*b;
        return (int)Math.sqrt(v);
    }
}
