package ljq.leetcode;

import java.util.*;
import java.lang.*;
public class LongestSubstring {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcca";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s)
	{
		int ans = 0;
		int n = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0,j=0;j<n;j++)
		{
			if(map.containsKey(s.charAt(j)))
			{
				i = Math.max( map.get(s.charAt(j)),i);
				//i =  map.get(s.charAt(j));
			}
			ans = Math.max(ans, j-i +1);
			map.put(s.charAt(j), j+1);//一旦后重复，直接跳过 【i,j】，新的判断需要从j+1开始
		}
		return ans;
	}

}
