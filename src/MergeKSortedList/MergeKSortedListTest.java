package MergeKSortedList;

import java.util.ArrayList;

import org.junit.Test;

public class MergeKSortedListTest {
	
	public void MyHeapTest(){
		Heapnew heap = new Heapnew(30);
		heap.Add(new ListNode(2));
		heap.Add(new ListNode(8));
		heap.Add(new ListNode(3));
		heap.Add(new ListNode(15));
		heap.Add(new ListNode(6));
		System.out.println(heap.size());
		heap.SortPrint();
	}
	
	@Test
	public void Test()
	{
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(2);
		ListNode l2 = new ListNode(10);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(1);
		ListNode l3 = new ListNode(16);
		l3.next = new ListNode(4);
		l3.next.next = new ListNode(3);
		ArrayList<ListNode> list  = new 
				ArrayList<ListNode>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
		MergeKSortedList mergeKSortedList = new MergeKSortedList();
		ListNode lnew = null;
		try {
			lnew = mergeKSortedList.sort2(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ListNode nodeTemp = lnew;
		while(nodeTemp!=null){
			System.out.print(nodeTemp.val+"->");
			nodeTemp = nodeTemp.next;
		}
	}
}
