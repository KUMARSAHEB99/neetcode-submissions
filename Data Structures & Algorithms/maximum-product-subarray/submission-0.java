class Solution {
    public int maxProduct(int[] nums) {
       int max=nums[0];
       int min=nums[0];
       int curmin=nums[0];
       int curmax=nums[0];
       for(int i=1;i<nums.length;i++){
        int x=nums[i];
        int a=Math.min(x,Math.min(curmax*x,curmin*x));
       int b=Math.max(x,Math.max(curmax*x,curmin*x));
       curmin=a;
       curmax=b;
        max=Math.max(max,curmax);
        min=Math.min(min,curmin);
       } 
       return max;

    }
}
