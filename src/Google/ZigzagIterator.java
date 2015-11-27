package Google;
import java.util.*;

public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int index = 0;
    boolean on_v1;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        on_v1 = (v1 == null || v1.size() == 0) ? false : true;
    }

    public int next() {
        int res = (on_v1) ? v1.get(index) : v2.get(index);
        
        if (on_v1) {
            if (index < v2.size())
                on_v1 = false;
            else 
                index++;
        } else {
            if (index + 1 < v1.size()) 
                on_v1 = true;
            index++;
        }
        
        return res;
    }

    public boolean hasNext() {
        if (on_v1 && index < v1.size())
            return true;
        if (!on_v1 && index < v2.size())
            return true;
        return false;
    }
}
