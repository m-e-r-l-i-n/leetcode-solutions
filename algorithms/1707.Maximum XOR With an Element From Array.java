class Solution {
    Node head;
    public int[] maximizeXor(int[] nums, int[][] qu) {
        head=new Node();
        Arrays.sort(nums);
        int i,q=qu.length,ans[]=new int[q],qr[][]=new int[q][3];
        for(i=0;i<q;i++)
        {
            qr[i][0]=qu[i][0];
            qr[i][1]=qu[i][1];
            qr[i][2]=i;
        }
        Arrays.sort(qr,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[2]>=o2[2]?1:-1;
                else return -1;
            }});

        int j=0;
        for(i=0;i<q;i++)
        {
            if(qr[i][1]<nums[0]) {ans[qr[i][2]]=-1; continue;}
            while(j<nums.length && nums[j]<=qr[i][1]) insert(nums[j++]);
            ans[qr[i][2]]=maxxor(qr[i][0]);
        }
        return ans;
    }

    class Node
    {
        Node nxt[]=new Node[2];
        int c;
        Node()
        {
            nxt[0]=nxt[1]=null;
            c=0;
        }
    }

    void insert(int x)
    {
        Node cur=head;
        int i,b;
        for(i=30;i>=0;i--)
        {
            b=(x>>i)&1;
            if(cur.nxt[b]==null) cur.nxt[b]=new Node();
            cur=cur.nxt[b];
            cur.c++;
        }
    }

    int maxxor(int x)
    {
        Node cur=head;
        int ans=0,i,b;
        for(i=30;i>=0;i--)
        {
            b=(x>>i)&1;
            if(cur.nxt[1-b]!=null && cur.nxt[1-b].c>0)
            {
                ans+=1<<i;
                cur=cur.nxt[1-b];
            }
            else cur=cur.nxt[b];
        }
        return ans;
    }
}
