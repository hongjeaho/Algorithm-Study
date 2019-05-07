package com.alg.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class Player {

	public String solution(String[] participant, String[] completion) {
        
		if(participant == null || completion == null) {
			return "";
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
        			.orElse("");
    }

	/*
	 * 코딩테스트 연습 > 해시 > 완주하지 못한 선수
	 * 코딩 테스트 통과 코드 
	 * */
	public String solutionHash(String[] participant, String[] completion) {
        
		if(participant == null || completion == null) {
			return "";
		}
		
		Map<String, Integer> partMap = new HashMap<String, Integer>();
		for(String part : participant) {
			int value = Optional.ofNullable(partMap.get(part)).orElse(-1);			
			partMap.put(part, value+ 1);
		}

		
        for(String comp : completion) {
        	
        	if(partMap.get(comp) == 0) {        		
        		partMap.remove(comp);
        		continue;
        	}
        	
        	partMap.put(comp, partMap.get(comp) - 1);	
        }
        
        return partMap.keySet()
        		.stream()
        		.filter(keys -> keys.length() > 0)
        		.findFirst()
        		.orElse("");
        		        		
    }
	
	@Test
	public void test1() throws Exception {
		String[] participant = new String[] {"leo", "kiki", "eden"};
		String[] completion = new String[] {"eden", "kiki"};
		
		Player solution = new Player();
		String result1 = solution.solution(participant, completion);
		String result2 = solution.solutionHash(participant, completion);

		assertEquals(result1, result2);		
	}
	
	@Test
	public void test2() throws Exception {
		String[] participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = new String[] {"josipa", "filipa", "marina", "nikola"};
		
		Player solution = new Player();
		String result1 = solution.solution(participant, completion);
		String result2 = solution.solutionHash(participant, completion);

		assertEquals(result1, result2);	
	}
	
	@Test
	public void test3() throws Exception {
		String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completion = new String[] {"stanko", "ana", "mislav"};
		
		Player solution = new Player();
		String result1 = solution.solution(participant, completion);
		String result2 = solution.solutionHash(participant, completion);

		assertEquals(result1, result2);	
	}
	
	@Test
	public void test4() throws Exception {
		String[] participant = null;
		String[] completion = null;
		
		Player solution = new Player();
		String result1 = solution.solution(participant, completion);
		String result2 = solution.solutionHash(participant, completion);

		assertEquals(result1, result2);	
	}
}
