class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       Arrays.sort(hand);
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int x:hand){
            
                map.put(x,map.getOrDefault(x,0)+1);
            
       }
       for(int x:hand){
        if(map.containsKey(x)){
             for(int i=x;i<x+groupSize;i++){
                 if(!map.containsKey(i))return false;
                 int a=map.get(i);
                 a-=1;
                 if(a==0){map.remove(i);}else{
                     map.put(i,a);
                 }
                 
             }
        }
       }
       return true; 
    }
}
