class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,cur=0,start=0;
        for(int i=0;i<gas.length;i++){
            int d=gas[i]-cost[i];
            total+=d;
            cur+=d;
            if(cur<0){
                cur=0;
                start=i+1;
            }
        }
        return total<0?-1:start;
    }
}
