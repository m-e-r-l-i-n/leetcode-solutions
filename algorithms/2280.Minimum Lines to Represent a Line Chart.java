//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n=stockPrices.length;
        Arrays.sort(stockPrices,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }});
        
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++)
        {
            int j=st.pop();
            if(st.isEmpty())    //there is only 1 point, so we make a line here
            {
                st.push(j);
                st.push(i);
                continue;
            }
            
            int k=st.peek(); //k j i are 3 points, if slope of k-j and j-i are same, we don't need a new line
            long v1[]={stockPrices[j][0]-stockPrices[k][0],stockPrices[j][1]-stockPrices[k][1]};
            long v2[]={stockPrices[i][0]-stockPrices[j][0],stockPrices[i][1]-stockPrices[j][1]};
            if(v1[0]*v2[1]!=v2[0]*v1[1])    //slopes do not match
            st.push(j);
            
            st.push(i);
        }
        return st.size()-1; //number of points-1 lines will be there
    }
}
