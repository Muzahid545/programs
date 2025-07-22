package com.mujahidpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceofHighest {
	public static String str ="Muzahiddin";
	
	
	public static Map<Character, Long> counteachChar(String str) {
		Map<Character, Long> charMap = str.chars().mapToObj(e->(char)e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charMap);
	Entry<Character,Long> result=	charMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow(()-> new RuntimeException("invalid or empty"));
		System.out.println(result);
		return charMap;
		
	}
	
	static public void main(String[] args) {
		counteachChar(str);
		char res2=highOccur(str);
		char res=getMaxOccurringChar(str);
		System.out.println(res);
		System.out.println(res2);
		
	}
	 public static char highOccur(String str) {
	        Map<Character, Long> charMap = str.chars()
	            .mapToObj(e -> (char) e)
	            .filter(Character::isLetter) 
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	        Entry<Character, Long> result = charMap.entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .orElseThrow(() -> new RuntimeException("Empty or invalid string"));

	        return result.getKey(); 
	    }

	
	public static char getMaxOccurringChar(String str) {
        if (str == null || str.isEmpty()) {
            return ' '; // you can throw exception here if need
        }

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }

        char maxChar = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxChar;
    }
}
