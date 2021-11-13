//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n=items.length,m=queries.length,i,qr[][]=new int[m][2],ans[]=new int[m];
        for(i=0;i<m;i++)
        {
            qr[i][0]=queries[i];
            qr[i][1]=i;
        }
        sort(items);
        sort(qr);
        int j=0,max=0;
        for(i=0;i<n;i++)
        {
            //all queries which are smaller than price of current item will be answered
            while(j<m && qr[j][0]<items[i][0]) ans[qr[j++][1]]=max;
            max=Math.max(max,items[i][1]);
        }
        while(j<m) ans[qr[j++][1]]=max;
        return ans;
    }
    
    void sort(int a[][])
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }});

        int i,n=a.length;
        for(i=0;i<n;i++) pq.add(new int[]{a[i][0],a[i][1]});
        for(i=0;i<n;i++) a[i]=pq.poll();
    }
}
