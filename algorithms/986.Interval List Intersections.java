class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0,s=0,e=0;
        ArrayList<Integer> al=new ArrayList<>();
        while(i<A.length && j<B.length)
        {
            s=Math.max(A[i][0],B[j][0]);
            e=Math.min(A[i][1],B[j][1]);
            if(s<=e) {al.add(s); al.add(e);}
            if(A[i][1]>B[j][1]) j++;
            else i++;
        }
        int a[][]=new int[al.size()/2][2];
        j=0;
        for(i=0;i<al.size();i+=2)
        {
            a[j][0]=al.get(i);
            a[j++][1]=al.get(i+1);
        }
        return a;
    }
}
