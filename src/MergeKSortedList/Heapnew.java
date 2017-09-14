package MergeKSortedList;

import java.awt.List;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 *´ó¶¥¶Ñ
 */
public class Heapnew {
	private int size;
	private static final int  MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private Comparator<ListNode> comparator = null;
	
	private ListNode[] nodes;
	public int size(){
		return size;
	}
	
	public Heapnew(int intiCap){
		nodes = new ListNode[intiCap];
		
	}
	
	public Heapnew(int intiCap, Comparator<ListNode> comparator){
		nodes = new ListNode[intiCap];
		this.comparator = comparator;
	}	
	public boolean IsEmpty(){
		return size==0;
	}
	
	private void grow(int minCapacity){
		int oldCapacity = nodes.length;
		int newCapacity = oldCapacity + ((oldCapacity < 64)?
										oldCapacity+2:
										oldCapacity>>1);
		if(newCapacity > MAX_ARRAY_SIZE)
			newCapacity = MAX_ARRAY_SIZE;
		nodes = Arrays.copyOf(nodes, newCapacity);
	}
	
	public void Add(ListNode node){
		if(size== nodes.length-1){
			grow(size+1);
			System.out.println("grow to "+nodes.length);
		}
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
		else{
			SiftDownByDefComparator(i);
		}
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
			SiftUpByComparator(i);
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

