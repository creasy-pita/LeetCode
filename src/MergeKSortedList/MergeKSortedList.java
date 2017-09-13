package MergeKSortedList;

import java.util.*;

public class MergeKSortedList {
	
	public ListNode sort(ArrayList<ListNode> list){
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(1
				, new Comparator<ListNode>() {
					@Override
					public int compare(ListNode node1, ListNode node2)
					{
						return node1.val - node2.val;
					}
				});
		//heap.poll()
		for(int i=0;i<list.size();i++)
		{
			heap.offer(list.get(i));
		}
		ListNode curr=null,head=null,pre=null;
		while(heap.size()>0){
			curr= heap.poll();
			if(head == null){
				head = curr;
			}
			else{
				pre.next = curr;
			}
			pre = curr;
			if(curr.next != null){
				heap.offer(curr.next);
			}
		}
		return head;
	}
}
