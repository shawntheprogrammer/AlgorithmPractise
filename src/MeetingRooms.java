import java.util.*;


public class MeetingRooms {
    public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }    
        });
        
        for (int i = 1; i < intervals.length; i++) {
            //if overlapped , return false
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        
        return true;
    }
}
