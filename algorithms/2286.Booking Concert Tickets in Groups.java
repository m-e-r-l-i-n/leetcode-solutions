//Tamonash Chakraborty
//O(log^2(n)) for gather
//O(nlog(n)) total for all calls of scatter
class BookMyShow {

    int st[],row,col,avail[];
    long bit[];
    Queue<Integer> q;
    public BookMyShow(int n, int m) {
        row=n; col=m;
        st=new int[4*n];
        bit=new long[n+1];
        avail=new int[n];
        
        int i;
        q=new LinkedList<>();   //non empty rows
        for(i=0;i<n;i++)
        {
            update(0,n-1,i,m,0);    //update st
            update(i,m);    //update bit
            avail[i]=m;     //number of seats available in this row
        	q.add(i);
        } 
    }
    
    public int[] gather(int k, int maxRow) {
        if(query(0,row-1,0,maxRow,0)<k) return new int[]{};   //not a possible solution
        
        int l=0,r=maxRow,mid,ans=r;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(query(0,row-1,0,mid,0)>=k)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        
        int ret[]={ans,col-avail[ans]}; 
        //if i have 2 seats available out of 6, it means first seat no will be 4 (start from 0)
        avail[ans]-=k;
        update(0,row-1,ans,avail[ans],0);
        update(ans,-k);
        return ret;
    }
    
    public boolean scatter(int k, int maxRow) {
        if(query(maxRow)<k) return false;   //it is not possible at all
        //now start removing values
        
        //remove the empty rows
        while(k>0 && q.peek()<=maxRow)
        {
            int i=q.peek(),use=Math.min(k,avail[i]);
            avail[i]-=use;
            update(i,-use);
            update(0,row-1,i,avail[i],0);
            if(avail[i]==0) q.poll();   //this is empty now
            
            k-=use;
        }
        return true;
    }
    
    void update(int i,int v)    //binary index tree update
    {
        i++;
        while(i<=row)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }
    
    long query(int i)     //binary index tree query
    {
        i++;
        long s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
    
    void update(int ss,int se,int i,int v,int n)    //segment tree update
    {
        if(ss>se) return;
        if(ss==se)
        {
            st[n]=v;
            return;
        }
        
        int m=(ss+se)>>1;
        if(i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=Math.max(st[2*n+1],st[2*n+2]);
    }
    
    int query(int ss,int se,int qs,int qe,int n)    //segment tree range max query
    {
        if(ss>se || qs>qe || se<qs || qe<ss) return 0;
        if(qs<=ss && qe>=se) return st[n];
        
        int m=(ss+se)>>1;
        return Math.max(query(ss,m,qs,qe,2*n+1),query(m+1,se,qs,qe,2*n+2));
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
