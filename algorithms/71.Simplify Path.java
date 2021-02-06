class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack=new LinkedList<>();
        for(String s: path.split("/"))
        if(s.equals("..")) stack.poll();
        else if(!s.equals("") && !s.equals(".")) stack.push(s);
        
        StringBuilder sb=new StringBuilder();
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
