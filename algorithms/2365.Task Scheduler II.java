class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long current=0;
        HashMap<Integer,Long> prev=new HashMap<>();
        for(int x:tasks)
        {
            long pre=prev.getOrDefault(x,0l);
            if(pre!=0) current=Math.max(current,pre+space);
            current++;  //do the current task
            prev.put(x,current);
        }
        return current;
    }
}
