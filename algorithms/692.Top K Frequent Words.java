class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int i;
        HashMap<String,int[]> hm=new HashMap<>();
        for(i=0;i<words.length;i++)
        {
            if(hm.get(words[i])==null ) hm.put(words[i],new int[]{0,i});
            hm.get(words[i])[0]++;
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return words[o2[1]].compareTo(words[o1[1]]);
                else return -1;
            }});
        
        for(String x:hm.keySet())
        {
            pq.add(hm.get(x));
            while(pq.size()>k) pq.poll();
        }
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty()) ans.add(words[pq.poll()[1]]);
        Collections.reverse(ans);
        return ans;
    }
}
