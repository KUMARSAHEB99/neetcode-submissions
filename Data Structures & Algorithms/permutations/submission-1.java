class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer>list=new ArrayList<>();
        fill(nums,list);
        return ans;
    }
    public void fill(int[] nums,List<Integer>list){
          if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
          }
          for(int i=0;i<nums.length;i++){
            if(nums[i]!=-11){
                   int a=nums[i];
                   
                   list.add(nums[i]);
                   nums[i]=-11;
                   fill(nums,list);
                   nums[i]=a;
                   list.remove(list.size()-1);
            }
          }
    }
}