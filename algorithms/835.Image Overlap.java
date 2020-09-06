class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int i,n=a.length;
        ArrayList<Integer> la=new ArrayList<>(),lb=new ArrayList<>();
        HashMap<Integer,Integer> c=new HashMap<>();
        for(i=0;i<n*n;i++)
        if(a[i/n][i%n]==1)
            la.add(i/n*100+i%n);
        for(i=0;i<n*n;i++)
        if(b[i/n][i%n]==1)
            lb.add(i/n*100+i%n);
        
        for(int x:la)
        for(int y:lb)
            c.put(x-y,c.getOrDefault(x-y,0)+1);
        int res=0;
        for(int x:c.keySet())
            res=Math.max(res,c.get(x));
        return res;
    }
}
