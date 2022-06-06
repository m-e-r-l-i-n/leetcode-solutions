//Tamonash Chakraborty
//O(1) for sendMessage
//O(n) for createGroup
//O(1) for addUserToGroup
//O(n) for sendGroupMessage
//O(n) for gettMessagesForUser
class WhatsApp {

    ArrayList<String> text[];
    HashMap<Integer,Set<Integer>> group;
    public WhatsApp() {
        text=new ArrayList[1001];   //store texts received by each user
        for(int i=0;i<=1000;i++) text[i]=new ArrayList<>();
        
        group=new HashMap<>();  //composition of each group
    }
    
    public void sendMessage(int toUser, String message) {
        text[toUser].add(message);  //add message
    }
    
    public int createGroup(int[] initialUsers) {
        int groupNumber=group.size()+1;    //new group is being formed
        Set<Integer> set=new HashSet<>();   //using sets so that lookup is faster
        for(int x:initialUsers) set.add(x);
        group.put(groupNumber,set);
        return groupNumber;
    }
    
    public void addUserToGroup(int groupId, int userId) {
        if(groupId>group.size() || group.get(groupId).contains(userId)) return;
        group.get(groupId).add(userId);
    }
    
    public void sendGroupMessage(int fromUser, int groupId, String message) {
        if(groupId>group.size() || !group.get(groupId).contains(fromUser)) return;
        
        for(int x:group.get(groupId))
        if(x!=fromUser) text[x].add(message);   //user should not send message to himself    
    }
    
    public String[] getMessagesForUser(int userId) {
        int sz=text[userId].size();
        String ans[]=new String[sz];    //obtain messages by latest ones first
        for(int i=sz-1,j=0;i>=0;i--,j++) ans[j]=text[userId].get(i);
        return ans;
    }
}

/**
 * Your WhatsApp object will be instantiated and called as such:
 * WhatsApp obj = new WhatsApp();
 * obj.sendMessage(toUser,message);
 * int param_2 = obj.createGroup(initialUsers);
 * obj.addUserToGroup(groupId,userId);
 * obj.sendGroupMessage(fromUser,groupId,message);
 * String[] param_5 = obj.getMessagesForUser(userId);
 */
