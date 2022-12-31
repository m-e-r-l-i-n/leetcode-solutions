class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive=new HashSet<>(),negative=new HashSet<>();
        for(String x:positive_feedback) positive.add(x);
        for(String y:negative_feedback) negative.add(y);
        
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]<o2[1]?1:-1;
                else return -1;
            }});
        for(int i=0;i<report.length;i++)
        {
            int score=0;
            String s[]=report[i].split(" ");
            for(String x:s)
            if(positive.contains(x)) score+=3;
            else if(negative.contains(x)) score--;
            pq.add(new int[]{score,student_id[i]});
            if(pq.size()>k) pq.poll();
        }
        
        Stack<Integer> st=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()) st.add(pq.poll()[1]);
        while(!st.isEmpty()) ans.add(st.pop());
        return ans;
    }
}
