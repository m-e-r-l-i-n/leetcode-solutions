class Solution {
    public int countTriplets(int[] arr) {
        int curr=0,ans=0,i,n=arr.length;   
        TrieNode root=new TrieNode(); 
  
        for(i=0;i<n;i++)
        {
            insert(root,curr,i);
            curr^=arr[i];
            ans+=query(root,curr,i);
        }
        return ans;
    }
    
    class TrieNode 
    { 
  
        TrieNode children[]; 
        int sum,n; 
        TrieNode() 
        { 
            children=new TrieNode[2]; 
            this.children[0]=null; 
            this.children[1]=null; 
            this.sum=0; 
            this.n=0; 
        } 
    }; 

    
    void insert(TrieNode node,int num,int index) 
    { 
  
        for(int i=31;i>=0;i--)  
        { 
  
            int curr=(num>>i)&1; 
            if(node.children[curr]==null) 
            node.children[curr]=new TrieNode(); 
            node=node.children[curr]; 
        } 
        node.sum+=index; 
        node.n++; 
    }
    
    int query(TrieNode node,int num,int index) 
    { 
  
        for(int i=31;i>=0;i--) 
        { 
  
            int curr=(num>>i)&1; 
            if(node.children[curr]==null) return 0; 
            node=node.children[curr]; 
        } 
  
        int ans=node.n*index-node.sum;
        return ans;
    }
}
