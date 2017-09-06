package ljq.leetcode;
import java.util.*;
import java.lang.*;

import ljq.leetcode.LocalClass.ListNode;
public class MergeTowSortedLists {


	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(9);
		ListNode l2 = new  ListNode(2);
		l2.next= new ListNode(3);
		l1 = mergeTowSortedLists(l1, l2);
		while(l1!=null){
			System.out.print(l1.val+"->");
			l1 = l1.next;
			
		}
		System.out.print("null");
	}
	
	
	
	public static ListNode mergeTowSortedLists(ListNode l1,ListNode l2)
	{
		
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode tail = dummy;//dummy  和 tail 新链表的 头和尾部
		
		while(l1!=null && l2 != null)
		{
			if(l1.val<l2.val){
				tail.next = l1;//操作next节点是在调整当前节点的next，而不是本身
				l1 = l1.next;
			}
			else if(l1.val >= l2.val)
			{
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		tail.next = (l1==null?l2:l1);
		
		return dummy.next;
	}
	

}
