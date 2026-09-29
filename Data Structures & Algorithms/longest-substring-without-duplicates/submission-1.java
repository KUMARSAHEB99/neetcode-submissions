class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visit=new boolean[128];
        int max=0;
        int left=0,right=0;
        while(right<s.length()){
            while(right<s.length() && !visit[(int)s.charAt(right)]){
                visit[(int)s.charAt(right)]=true;
                right++;
            }
            max=Math.max(right-left,max);
            if(right==s.length())return max;
            while(left<right && visit[(int)s.charAt(right)]){
                visit[(int)s.charAt(left)]=false;
                left++;
            }
        }
        return max;
    }
}
