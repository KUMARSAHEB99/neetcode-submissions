class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

for (int x : nums) {
    set.add(x);
}
        int max=0;
        for(int x:nums){
            if(set.contains(x-1))continue;
            int y=x,count=0;
            while(set.contains(y)){
                y++;
                count++;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}
