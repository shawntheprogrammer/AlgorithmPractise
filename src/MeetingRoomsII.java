
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }    
        });
        
        Queue<Integer> queue = new PriorityQueue<Integer>();
        
        //build a queue with all the ending point
        for (int i = 0; i < intervals.length; i++) {
            if (queue.peek() == null) {
                queue.add(intervals[i].end);
            } else {
                if (intervals[i].start >= queue.peek()) {
                    queue.remove();
                }
                queue.add(intervals[i].end);
            }
        }
        return queue.size();
    }
    
    //O(MAX - MIN) build up an array  each index represent a time point
    public int minMeetingRoomsII(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i].start);
            max = Math.max(max, intervals[i].end);
        }
        int[] nums = new int[max - min + 1];
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i].start; j < intervals[i].end; j++) {
                result = Math.max(result, ++nums[j - min]);
            }
        }
        return result;
    }
}
