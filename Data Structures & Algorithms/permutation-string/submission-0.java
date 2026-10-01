class Solution {
    public boolean checkInclusion(String p, String s) {
        int[]arr1=new int[26];
        int[]arr2=new int[26];
        for(int i=0;i<p.length();i++){
            arr1[p.charAt(i)-'a']++;
        }
        int left=0,right=0;
        
        while(right<s.length()){
           while(right<s.length() && arr1[s.charAt(right)-'a']!=0 &&      arr2[s.charAt(right)-'a']<arr1[s.charAt(right)-'a']){
            arr2[s.charAt(right)-'a']++;
            right++;
           }
           if(right-left==p.length())return true;
           if(right==s.length())return false;
           if(arr1[s.charAt(right)-'a']==0){
            Arrays.fill(arr2,0);
            right++;
            left=right;
           }
           else{
            while(left<right && arr2[s.charAt(right)-'a']==arr1[s.charAt(right)-'a']){
                 arr2[s.charAt(left)-'a']--;
            left++;
            }
           }
           
        }
        return false;
    }
}
