class Solution {
    public int maxProfit(int[] prices) {
        int cur=Integer.MAX_VALUE,max=0;
        for(int x:prices){
            if(x<cur)cur=x;
            else{
                max=Math.max(x-cur,max);
            }
        }
        return max;
    }
}
