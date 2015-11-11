import java.util.*;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        //find max (max (size(citations greater that i), i))
        Arrays.sort(citations);
        return binarySearch(citations, 0, citations.length - 1);
    }
    
    public int binarySearch(int[] citations, int start, int end) {
        if (start == end) {
            return Math.min(citations[start], citations.length - start);
        }
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int num = citations.length - mid;
        //perfect match
        int res = Math.min(citations[mid], num);
        
        if (num == citations[mid]) {
            return num;
        } else if (num > citations[mid]) {
            return binarySearch(citations, mid + 1, end);
        } else {
            return Math.max(res, binarySearch(citations, start, mid - 1));
        }
    }
}
