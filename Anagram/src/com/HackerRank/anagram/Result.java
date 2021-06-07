package com.HackerRank.anagram;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Result {

	/*
	 * Complete the 'countSentences' function below.
	 *
	 * The function is expected to return a LONG_INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING_ARRAY wordSet
	 *  2. STRING_ARRAY sentences
	 */
	static Map<ArrayList<String>, ArrayList<String>> dictionaryMap = new HashMap<ArrayList<String>, ArrayList<String>>();

	public static List<Long> countSentences(List<String> wordSet, List<String> sentences, int List) {

		int numberOfsentences;
		List<Long> m = null;

		ArrayList<String> anagramList = dictionaryMap.get(wordSet);

		if (anagramList == null) {
			anagramList = new ArrayList<String>();
			anagramList.addAll(sentences);
			dictionaryMap.put((ArrayList<String>) wordSet, anagramList);

		}
		if (!anagramList.contains(sentences)) {
			anagramList.addAll(sentences);
			dictionaryMap.put((ArrayList<String>) wordSet, anagramList);
		}

		private static Object createMap(List<List> wordSet) {
			Map<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
			StringBuffer buff = new StringBuffer();
			char arr[] = wordSet.toLowerCase().toCharArray();
			Arrays.sort(arr);
			String sortString = Arrays.toString(arr);
			for (int i = 0; i < sortString.length(); i++) {
				char c = sortString.charAt(i);
				if (characterCountMap.containsKey(c))
					characterCountMap.put(c, characterCountMap.get(c) + 1);
				else
					characterCountMap.put(c, 1);
			}

			for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet())
				buff.append(entry.getKey() + entry.getValue());

			return buff.toString();
		}

		private Map<ArrayList<String>, ArrayList<String>> init(String[] words) {
			for (List<String> wordSet : words) {
				addToMap(createMap(wordSet), wordSet);

			}
			return (List<Long>) dictionaryMap;
		}

		private String[] getAnagrams(List<List> wordSet) {

			String key = createMap(wordSet);
			List<String> al = dictionaryMap.get(key);
			String[] arr = al.toArray(new String[al.size()]);
			return arr;
		}
	}
}



/*
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("This is a debug message");
        String arr[] = { "ate", "eat", "THIS", "EAT" };
        obj.init(arr);
        for (String anagram : obj.getAnagrams("tea"))
            System.out.println(anagram);

    }
}

 */