package ljq.leetcode.GenerateParentheses;

import java.util.ArrayList;


public class GenerateParentheses {
	
	public void generateParentheses(ArrayList<String> list, String s,int l,int r,int n){
		if(l==n)
		{
			while(r++<n)
				s+=")";
			list.add(s);
			return;
		}
		generateParentheses(list, s+"(", l+1, r, n);
		if(l>r)generateParentheses(list, s+")", l, r+1, n);
	}
}
