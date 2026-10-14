class Solution {
    public int jump(int[] nums) {
         int count=0,max=0,curmax=0;
        for(int i=0;i<nums.length;i++){
            if(curmax<i){
                curmax=max;
                count++;
            }
            max=Math.max(i+nums[i],max);
        }
        return count;
    }
}
