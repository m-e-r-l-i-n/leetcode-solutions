class Solution {
    public int[][] merge(int[][] p) {
        Arrays.sort(p,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]<o2[1]?1:-1;
                else return -1;
            }});
        ArrayList<Integer> ans=new ArrayList<>();
        int l=p[0][0],r=p[0][1],i;
        for(i=1;i<p.length;i++)
        if(p[i][0]<=r) r=Math.max(r,p[i][1]);
        else
        {
            ans.add(l); ans.add(r);
            l=p[i][0]; r=p[i][1];
        }
        ans.add(l); ans.add(r);
        int ret[][]=new int[ans.size()/2][2];
        for(i=0;i<ans.size();i+=2)
        {
            ret[i/2][0]=ans.get(i);
            ret[i/2][1]=ans.get(i+1);
        }    
        return ret;
    }
}
