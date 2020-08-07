/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,List<Pair>> hm=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,0));
        int min=0,max=0,i;
        while(!q.isEmpty())
        {
            Pair p=q.poll(); 
            min=Math.min(min,p.x);
            max=Math.max(max,p.x);
            
            if(hm.get(p.x)==null) hm.put(p.x,new ArrayList<>());
            hm.get(p.x).add(p);
            
            if(p.node.left!=null) q.add(new Pair(p.node.left, p.x-1,p.y+1));
            if(p.node.right!=null) q.add(new Pair(p.node.right,p.x+1,p.y+1));
        }        

        for(i=min;i<=max;i++)
        {
            Collections.sort(hm.get(i), new Comparator<Pair>(){
                public int compare(Pair a, Pair b)
                {
                    if(a.y==b.y) //when y is equal, sort it by value
                        return a.node.val-b.node.val;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }});
            List<Integer> l=new ArrayList<>();
            for(int j=0; j<hm.get(i).size(); j++)
                l.add(hm.get(i).get(j).node.val);
            ans.add(l);
        }
        return ans;   
    }
    
    class Pair
    {
        TreeNode node;
        int x;  //horizontal
        int y;  //depth
        Pair(TreeNode n, int a, int b)
        {
            node=n;
            x=a;
            y=b;
        }
    }
}
