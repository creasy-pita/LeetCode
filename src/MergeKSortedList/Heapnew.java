package MergeKSortedList;

import java.awt.List;
import java.util.ArrayList;

public class Heapnew {
	private int size;
	
	private ListNode[] nodes;
	public int size(){
		return size;
	}
	
	public Heapnew(int maxCap){
		nodes = new ListNode[maxCap];
		
	}
	public boolean IsEmpty(){
		return size==0;
	}
	public void Add(ListNode node){
		nodes[++size] = node;
		SiftUp(size);
	}
	
	public ListNode Poll() throws Exception{
		if(IsEmpty())
		{
			throw new Exception("the heap is underflow");
		}
		ListNode temp = nodes[1];
		nodes[1] = nodes[size];
		nodes[size]= temp;
		size--;
		SiftDown(1);
		return nodes[size+1];
	}
	
	public void SiftDown(int i)
	{
		ListNode curr= nodes[i];
		int largestIndex = i;
		if(2*i <= size && curr.val < nodes[2*i].val)
		{
			largestIndex = 2*i; 
		}
		if(2*i+1 <=size && curr.val < nodes[2*i + 1].val)
		{
			largestIndex = 2*i +1;
		}
		if(largestIndex != i)
		{
			ListNode temp = nodes[i];
			nodes[i] = nodes[largestIndex];
			nodes[largestIndex]= temp;
			SiftDown(largestIndex);
		}
	}
	
	public void SiftUp(int i){
		while(i<= size && i>1){			
			int parent = i/2;
			if(nodes[i].val > nodes[parent].val)
			{
				ListNode temp = nodes[i];
				nodes[i] = nodes[parent];
				nodes[parent]= temp;
				i = parent;
			}
			else break;
		}
	}
	
	private void Exchange(ListNode n1,ListNode n2){
		ListNode temp = n1;
		n1 = n2;
		n2 = temp;
	}
	
	public void SortPrint(){
		while(!IsEmpty()){			
			try {
				System.out.print(Poll().val+"->");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

