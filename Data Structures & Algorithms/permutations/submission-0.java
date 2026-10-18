class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer>list=new ArrayList<>();
        HashSet<Integer>visited=new HashSet<>();
        fill(nums,list,visited);
        return ans;
    }
    public void fill(int[] nums,List<Integer>list,HashSet<Integer>set){
          if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
          }
          for(int i=0;i<nums.length;i++){
            if(!set.contains(i)){
                   set.add(i);
                   list.add(nums[i]);
                   fill(nums,list,set);
                   set.remove(i);
                   list.remove(list.size()-1);
            }
          }
    }
}