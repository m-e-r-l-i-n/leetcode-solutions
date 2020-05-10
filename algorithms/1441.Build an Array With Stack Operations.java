class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i,max=0,c[]=new int[101];
        for(i=0;i<target.length;i++)
        {
            c[target[i]]++;
            max=Math.max(target[i],max);
        }
        List<String> l=new ArrayList<>();
        for(i=1;i<=Math.min(max,n);i++)
        {
            if(c[i]==0) {l.add("Push"); l.add("Pop");}
            else l.add("Push");
        }
        return l;
    }
}
