//Tamonash Chakraborty
//O(n*log(n)*log(sum))
//extra log for the gcd
class Solution {
    public int halveArray(int[] nums) {
        //can be speeded up using int, but should not be necessary here
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
            public int compare(long o1[],long o2[])
            {
                return greater(o1,o2)?-1:1; //the larger the number, the closer it should be to being polled
            }});
        
        long sum[]={0,2},cur[]={0,1};
        for(int x:nums) 
        {
            sum[0]+=x;
            cur[0]+=x;
            pq.add(new long[]{x,1});
        }
        
        int ans=0;
        //keep reducing the largest value by 2 as long as cur>sum (we need to bring it to at least half)
        while(greater(cur,sum))
        {
            long p[]=pq.poll();
            ans++;
            operate(cur,p,false);    //subtract p from cur
            p[1]*=2;
            operate(cur,p,true); //add p to cur
            pq.add(p);  //keep the value in the priority queue
        }
        return ans;
    }
    
    boolean greater(long a[],long b[]) //comparing fractions
    {
        //a[0]/a[1] > b[0]/b[1]
        long u=a[0]*b[1],v=b[0]*a[1];
        return u>v;
    }
    
    long gcd(long a,long b)
    {
        long t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    
    void operate(long a[],long b[],boolean add)    
    {
        //note that as per the parameters a>b
        long num=a[0]*b[1],den=a[1]*b[1];
        if(add) num+=a[1]*b[0];
        else num-=a[1]*b[0];
        
        long g=gcd(num,den);
        num/=g; den/=g;
        a[0]=num; a[1]=den;
    }
    
}
