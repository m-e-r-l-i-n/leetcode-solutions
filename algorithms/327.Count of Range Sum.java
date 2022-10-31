class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length,i,c[]=new int[n+1];
        long pre=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
            public int compare(long o1[],long o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) 
                {
                    if(o1[1]>o2[1]) return 1;
                    else if(o1[1]==o2[1]) return o1[2]>o2[2]?1:-1;
                    else return -1;
                }
                else return -1;
            }});
        pq.add(new long[]{0,1,0});
        for(i=1;i<=n;i++)
        {
            pre+=nums[i-1];
            pq.add(new long[]{pre,1,i});
            pq.add(new long[]{pre-lower,2,i});
            pq.add(new long[]{pre-upper,0,i});
            if(pre>=pre-upper && pre<=pre-lower) c[i]++;
        }
        
        int bit[]=new int[n+2],ans=0;
        while(!pq.isEmpty())
        {
            long e[]=pq.poll(); i=(int)e[2];
            //System.out.print(e[0]+" "+e[1]+" "+i+"\n");
            if(e[1]==1) update(bit,i,n+1);
            else if(e[1]==0) c[i]+=query(bit,i);
            else if(e[1]==2) ans+=query(bit,i)-c[i];
            //System.out.println(ans);
        }
        return ans;
    }
    
    void update(int bit[],int i,int n)
    {
        i++;
        while(i<=n)
        {
            bit[i]++;
            i+=i&-i;
        }
    }
    
    int query(int bit[],int i)
    {
        i++;
        int s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
