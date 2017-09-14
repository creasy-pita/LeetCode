package MergeKSortedList;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Administrator
 *�󶥶�
 */
public class Heapnew {
	private int size;
	
	private Comparator<ListNode> comparator = null;
	
	private ListNode[] nodes;
	public int size(){
		return size;
	}
	
	public Heapnew(int maxCap){
		nodes = new ListNode[maxCap];
		
	}
	
	public Heapnew(int maxCap, Comparator<ListNode> comparator){
		nodes = new ListNode[maxCap];
		this.comparator = comparator;
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
		nodes[size--]= temp;
		SiftDown(1);
		return nodes[size+1];
	}
	
	public void SiftDown(int i)
	{
		if(comparator != null){
			SiftDownByComparator(i);
		}
		
/*		ListNode curr= nodes[i];
		int largestIndex = i;
		if(2*i <= size && curr.val < nodes[2*i].val)
		{
			largestIndex = 2*i; 
		}
		if(2*i+1 <=size && nodes[largestIndex].val < nodes[2*i + 1].val)
		{
			largestIndex = 2*i +1;
		}
		if(largestIndex != i)
		{
			ListNode temp = nodes[i];
			nodes[i] = nodes[largestIndex];
			nodes[largestIndex]= temp;
			SiftDown(largestIndex);
		}*/
	}
	
	public void SiftDownByDefComparator(int i)
	{
		ListNode curr= nodes[i];
		int largestIndex = i;
		if(2*i <= size && curr.val < nodes[2*i].val)
		{
			largestIndex = 2*i; 
		}
		if(2*i+1 <=size && nodes[largestIndex].val < nodes[2*i + 1].val)
		{
			largestIndex = 2*i +1;
		}
		if(largestIndex != i)
		{
			ListNode temp = nodes[i];
			nodes[i] = nodes[largestIndex];
			nodes[largestIndex]= temp;
			SiftDownByDefComparator(largestIndex);
		}
	}
	
	public void SiftDownByComparator(int i)
	{
		
		ListNode curr= nodes[i];
		int largestIndex = i;
		
		if(2*i <= size &&  comparator.compare(curr, nodes[2*i]) < 0 )
		{
			largestIndex = 2*i; 
		}
		if(2*i+1 <=size && comparator.compare(nodes[largestIndex], nodes[2*i + 1]) < 0)
		{
			largestIndex = 2*i +1;
		}
		if(largestIndex != i)
		{
			ListNode temp = nodes[i];
			nodes[i] = nodes[largestIndex];
			nodes[largestIndex]= temp;
			SiftDownByComparator(largestIndex);
		}
	}	
	
	
	public void SiftUp(int i){
		if(comparator != null){
			SiftDownByComparator(i);
		}
		else{
			SiftUpByDefComparator(i);
		}
	}
	
	public void SiftUpByDefComparator(int i){
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
	
	public void SiftUpByComparator(int i){
		while(i<= size && i>1){			
			int parent = i/2;
			if(comparator.compare(nodes[i], nodes[parent])>0)
			{
				ListNode temp = nodes[i];
				nodes[i] = nodes[parent];
				nodes[parent]= temp;
				i = parent;
			}
			else break;
		}
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

