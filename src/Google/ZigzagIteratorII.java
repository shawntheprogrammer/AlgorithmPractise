package Google;
import java.util.*;

public class ZigzagIteratorII {
	public List<List<Integer>> lists;
	public int element_index;
	public Queue<Integer> queue;
	public int size;
	public int count;
	
	public ZigzagIteratorII(List<List<Integer>> lists) {
		this.lists = lists;
		queue = new LinkedList<>();
		for (int i = 0; i < lists.size(); i++) {
			List<Integer> list = lists.get(i);
			if (list != null && list.size() != 0)
				queue.add(i);
			element_index = 0;
		}
		size = queue.size();
		count = 0;
	}
	
	public int next() {
		int list_index = queue.remove();
		List<Integer> list = lists.get(list_index);
		int res = list.get(element_index);
		if (element_index != list.size() - 1)
			queue.add(list_index);
		//update element_index
		count++;
		if (count == size) {
			element_index++;
			count = 0;
			size = queue.size();
		}
		return res;
	}
	
	public boolean hasNext() {
		return queue.size() != 0;
	}
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		l1.add(0); l1.add(2);
		l2.add(1); l2.add(3);  l2.add(4); l2.add(5);
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(l1); lists.add(l2); lists.add(new ArrayList<>());
		
		ZigzagIteratorII z = new ZigzagIteratorII(lists);
		while (z.hasNext())
			System.out.print(z.next()+ ",");
	}
}
