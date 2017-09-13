package MergeKSortedList;

import java.awt.List;
import java.util.ArrayList;

public class Heap {
	private int size;
	
	private ArrayList<ListNode> nodes;
	public int size(){
		return size;
	}
	
	public Heap(int initCap){
		nodes = new ArrayList<ListNode>(initCap);
		nodes.add(new ListNode(Integer.MAX_VALUE));
	}
	public boolean IsEmpty(){
		return size==0;
	}
	public void Add(ListNode node){
		nodes.add(node);
		SiftUp(++size);
	}
	
	public ListNode Poll() throws Exception{
		if(IsEmpty())
		{
			throw new Exception("the heap is underflow");
		}
		Exchange(nodes.get(1), nodes.get(size));
		size--;
		SiftDown(1);
		return nodes.remove(size+1);
	}
	
	public void SiftDown(int i)
	{
		ListNode curr= nodes.get(i);
		int largestIndex = i;
		if(2*i <= size && curr.val < nodes.get(2*i).val)
		{
			largestIndex = 2*i; 
		}
		if(2*i+1 <=size && curr.val < nodes.get(2*i + 1).val)
		{
			largestIndex = 2*i +1;
		}
		if(largestIndex != i)
		{
			Exchange(nodes.get(i),nodes.get(largestIndex));
			SiftDown(largestIndex);
		}
	}
	
	public void SiftUp(int i){
		while(i< size && i>1){			
			int parent = i/2;
			if(nodes.get(i).val > nodes.get(parent).val)
			{
				Exchange(nodes.get(i), nodes.get(parent));
				i = parent;
			}
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
