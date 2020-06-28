class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> targets=new HashMap<>();
        for(List<String> ticket:tickets)
        targets.computeIfAbsent(ticket.get(0),k->new PriorityQueue()).add(ticket.get(1));
        
        ArrayList<String> route=new ArrayList();
        Stack<String> stack=new Stack<>();
        stack.push("JFK");
        while(!stack.empty()) 
        {
            while(targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0,stack.pop());
        }
        return route;
    }
}
