import java.util.*;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0 || newInterval == null) {
            List<Interval> result = new ArrayList<>();
            result.add(newInterval);
            return result;
        }
        
        List<Interval> result = new ArrayList<>();  // return value
        boolean added = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            //merge if overlapped
            if (cur.start > newInterval.end) {
                if (!added) {
                    result.add(newInterval);
                    added = true;
                }
                result.add(cur);
            //no overlapping
            } else if (cur.end < newInterval.start){
                result.add(cur);
            //overlapped, merge it up
            } else {
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            }
        }
        
        //add it if it's the last 
        if (!added) {
            result.add(newInterval);
        } 
        
        return result;
    }
}
