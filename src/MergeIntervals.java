import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               if (i1.start != i2.start) {
                   return i1.start - i2.start;
               }
               return i1.end - i2.end;
           } 
        });
        
        List<Interval> result = new ArrayList<>();
        //variables to track the last interval
        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;
        
        for (int i = 1; i < intervals.size(); i++) {
            int thisStart = intervals.get(i).start;
            int thisEnd = intervals.get(i).end;
            
            //no overlapping : add last to list
            if (thisStart > lastEnd) {
                result.add(new Interval(lastStart, lastEnd));
                lastStart = thisStart;
                lastEnd = thisEnd;
            //overlapped, update lastStart and lastEnd
            } else {
                lastStart = Math.min(lastStart, thisStart);
                lastEnd = Math.max(lastEnd, thisEnd);
            }
        }
        
        //add the last one to result
        result.add(new Interval(lastStart, lastEnd));
        
        return result;
    }
}
