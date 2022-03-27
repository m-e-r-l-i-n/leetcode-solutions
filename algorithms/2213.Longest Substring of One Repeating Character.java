//Tamonash Chakraborty
//O(n+qlogn)
class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char c[]=s.toCharArray();
        TreeMap<Integer,Integer> range[]=new TreeMap[26],count=new TreeMap<>();
        
        int i,j,n=c.length;
        for(i=0;i<26;i++) range[i]=new TreeMap<>();
        for(i=0;i<n;i++)    //store ranges of same characters
        {
            j=i;
            while(j<n && c[j]==c[i]) j++;
            range[c[i]-'a'].put(i,j);
            count.put(j-i,count.getOrDefault(j-i,0)+1);
            i=j-1;
        }
        
        int q=queryCharacters.length(),ans[]=new int[q];
        for(i=0;i<q;i++)
        {
            j=queryIndices[i];
            deleteRange(range[c[j]-'a'],count,j);  
            c[j]=queryCharacters.charAt(i);
            insertRange(range[c[j]-'a'],count,j);
            ans[i]=count.lowerKey(n+1);
        }
        return ans;
    }
    
    void deleteRange(TreeMap<Integer,Integer> range,TreeMap<Integer,Integer> count,int i)
    {
        int u=range.lowerKey(i+1),v=range.get(u);
        subtract(count,v-u);
        if(i>u) 
        {
            range.put(u,i);
            count.put(i-u,count.getOrDefault(i-u,0)+1);
        }
        else range.remove(u);
        
        if(i+1<v) 
        {
            range.put(i+1,v);
            count.put(v-i-1,count.getOrDefault(v-i-1,0)+1);
        }
    }
    
    void insertRange(TreeMap<Integer,Integer> range,TreeMap<Integer,Integer> count,int i)
    {
        int l=i,r=i+1;
        if(range.lowerKey(i)!=null)
        {
            int key=range.lowerKey(i);
            if(range.get(key)==l) 
            {
                l=key;
                subtract(count,i-key);
            }
        }
        
        if(range.higherKey(i)!=null)
        {
            int key=range.higherKey(i);
            if(key==r)
            {
                r=range.get(key);
                subtract(count,r-i-1);
                range.remove(key);
            }
        }
        range.put(l,r);
        count.put(r-l,count.getOrDefault(r-l,0)+1);
    }
    
    void subtract(TreeMap<Integer,Integer> count,int k)
    {
        int v=count.get(k);
        if(v==1) count.remove(k);
        else count.put(k,v-1);
    }
}
