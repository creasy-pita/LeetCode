package ljq.leetcode.GenerateParentheses;

import java.util.ArrayList;

import org.junit.Test;

public class GenerateParenthesesTest {
	@Test
	public void Test()
	{
		GenerateParentheses gp = new GenerateParentheses();
		ArrayList<String> list = new ArrayList<String>();
		gp.generateParentheses(list, "",0,0,4);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
