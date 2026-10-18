/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
         Collections.sort(intervals,(a,b)->a.start-b.start);
         int prev=-1;
         for(Interval x:intervals){
            if(x.start<prev){
                return false;
            }else{
                prev=x.end;
            }
         }
         return true;
    }
}
