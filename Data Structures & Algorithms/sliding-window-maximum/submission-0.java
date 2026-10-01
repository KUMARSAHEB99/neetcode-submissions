class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq=new LinkedList<>();
        int left=0,right=0;
        int[] ans=new int[nums.length-k+1];
        int i=0;
        while(right<nums.length){
            while(right<nums.length && right-left<k){
                if(dq.isEmpty()){
                    dq.offer(right);
                }
                else{
                    while(!dq.isEmpty() && nums[dq.peekLast()]<nums[right]){
                        dq.pollLast();
                    }
                    dq.offer(right);
                }
                right++;
            }
           
            ans[i++]=nums[dq.peekFirst()];
             if(right==nums.length)return ans;
            if(left==dq.peekFirst()){
                dq.pollFirst();
            }
            left++;
        }
        return ans;
    }
}
