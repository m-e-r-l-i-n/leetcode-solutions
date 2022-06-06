//Tamonash Chakraborty
//O(n^2)
class ConsistentHashing {

    TreeSet<Integer> nodes;
    ArrayList<Integer> data[];
    Set<Integer> key[];
    int id;
    public ConsistentHashing(int initialNodes) {
        data=new ArrayList[1001];   //max is 1000
        key=new HashSet[1001];
        int i;
        for(i=0;i<=1000;i++) 
        {
            data[i]=new ArrayList<>();
            key[i]=new HashSet<>();
        }
        
        nodes=new TreeSet<>();
        for(i=1;i<=initialNodes;i++) nodes.add(i);
        id=i;
    }
    
    public int getNodeForKey(int k) {
        if(key[k].isEmpty()) 
        {
            int ky=nodes.higher(-1);    //first node
            key[k].add(ky);    
            data[ky].add(k);
        }
        int ans=-1;
        for(int x:key[k]) {ans=x; break;}
        return ans;
    }
    
    public int removeNode(int node) {
        nodes.remove(node);
        int k=nodes.higher(-1);
        for(int x:data[node]) 
        {
            if(!key[x].contains(k)) data[k].add(x);
            key[x].add(k);
            key[x].remove(node);
        }
        data[node].clear();
        return k;
    }
    
    public int[] addNode() {
        int ans[]=new int[2],k=nodes.higher(-1);
        ans[0]=id; ans[1]=k; nodes.add(id);
        
        for(int x:data[k]) 
        {
            data[id].add(x);
            key[x].add(id);
        }
        id++;
        return ans;
    }
    
    public int[] getKeysInNode(int node) {
        int ans[]=new int[data[node].size()];
        for(int i=0;i<ans.length;i++) ans[i]=data[node].get(i);
        return ans;
    }
}

/**
 * Your ConsistentHashing object will be instantiated and called as such:
 * ConsistentHashing obj = new ConsistentHashing(initialNodes);
 * int param_1 = obj.getNodeForKey(key);
 * int param_2 = obj.removeNode(node);
 * int[] param_3 = obj.addNode();
 * int[] param_4 = obj.getKeysInNode(node);
 */
