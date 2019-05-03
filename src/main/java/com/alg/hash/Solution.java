package com.alg.hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Solution {

	public String solution(String[] participant, String[] completion) {
        
		if(participant == null || completion == null) {
			return "none";
		}
		
        LinkedList<String> array = new LinkedList<String>(Arrays.asList(participant));
        for(int index = 0; index < completion.length; index ++) {
        	String  result = completion[index];
        	
        	if(array.contains(result)) {
        		array.remove(result);
        	}
        }
        
        return Optional.ofNullable(array)
        			.filter(arr -> arr.size() > 0)
        			.map(LinkedList::getFirst)
        			.orElse("none");
    }
	
	@Test
	public void test1() throws Exception {
		String[] participant = new String[] {"leo", "kiki", "eden"};
		String[] completion = new String[] {"eden", "kiki"};
		
		Solution solution = new Solution();
		String result = solution.solution(participant, completion);
		
		System.out.println(result);
	}
	
	@Test
	public void test2() throws Exception {
		String[] participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = new String[] {"josipa", "filipa", "marina", "nikola"};
		
		Solution solution = new Solution();
		String result = solution.solution(participant, completion);
		
		System.out.println(result);
	}
	
	@Test
	public void test3() throws Exception {
		String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completion = new String[] {"stanko", "ana", "mislav"};
		
		Solution solution = new Solution();
		String result = solution.solution(participant, completion);
		
		System.out.println(result);
	}
	
	@Test
	public void test4() throws Exception {
		String[] participant = null;
		String[] completion = null;
		
		Solution solution = new Solution();
		String result = solution.solution(participant, completion);
		
		System.out.println(result);
	}
}
